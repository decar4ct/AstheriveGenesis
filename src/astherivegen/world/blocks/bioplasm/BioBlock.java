package astherivegen.world.blocks.bioplasm;

import arc.Core;
import arc.graphics.*;
import arc.graphics.g2d.*;
import arc.graphics.g2d.TextureRegion;
import arc.math.*;
import arc.util.*;
import arc.math.geom.*;
import mindustry.world.blocks.defense.*;
import mindustry.gen.Building;
import mindustry.graphics.*;
import mindustry.ui.*;
import mindustry.world.*;
import mindustry.world.Tile;
import mindustry.graphics.*;
import mindustry.content.*;
import java.util.ArrayList;
import java.util.Random;

import static mindustry.Vars.*;

public class BioBlock extends Block {
    public boolean isRoot=false;
    public BioBlock(String name){
        super(name);
        update=true;
    }
    public class BioBuilding extends Building {
        public float pulseProgress=0;
        public int biopulse=0;
        public float pulseTimer=0;
        public float resetPulseTimer=0;
        public float deathTimer=0;
        public float deathTimerLimit=70f;
        public boolean pulsed=false;

        public ArrayList<Integer> possibleGrowDir = new ArrayList<>();
        public float drawPulseScale=0;
        public @Nullable Tile advNearby(int rotation, int branchRotation){
            //terrible mess, but if it work it work
            int bx = switch(branchRotation){
                case 0 -> x+1;
                case 1 -> x;
                case 2 -> x-1;
                case 3 -> x;
                default -> x;
            };
            int by = switch(branchRotation){
                case 0 -> y;
                case 1 -> y+1;
                case 2 -> y;
                case 3 -> y-1;
                default -> y;
            };
            return switch(rotation){
                case 0 -> world.tile(bx + 1, by);
                case 1 -> world.tile(bx, by + 1);
                case 2 -> world.tile(bx - 1, by);
                case 3 -> world.tile(bx, by - 1);
                default -> null;
            };
        }
        @Override
        public void updateTile() {
            //TODO try syncing invididually?
            if (biopulse>0&&!pulsed){
                deathTimer=0f;
                if (pulseTimer<4f) {
                    pulseTimer+=delta();
                } else {
                    updatePulse();
                    pulseTimer=0;
                    biopulse=0;
                    pulsed=true;
                    drawPulseScale=0.7f;
                }
            }
            if (pulsed) {
                if (resetPulseTimer<7f) {
                    resetPulseTimer+=delta();
                } else {
                    resetPulseTimer=0;
                    pulsed=false;
                }
            }
            if (biopulse>=0&&deathTimer<deathTimerLimit){
                deathTimer+=delta();
            }
            if (deathTimer>=deathTimerLimit){
                this.damage(4);
            }
            
            if (drawPulseScale>0.01f) {
                drawPulseScale*=0.85;
            }
        }
        public void updatePulse() {
            //TODO rework back to this->pulse
            boolean pulseEnd=true;
            if (true) {
                possibleGrowDir.clear();
                for (int i=0;i<4;i++) {
                    Building nearroot = tile.nearbyBuild(i);
                    Tile neartile = tile.nearby(i);
                    if (nearroot instanceof BioBuilding nearbuild) {
                        if (!nearbuild.pulsed) {                      
                            nearbuild.biopulse=Math.max(nearbuild.biopulse,biopulse-1);
                            pulseEnd=false;
                        }
                    } else if (neartile.block() == Blocks.air) {
                        int nearnearcount=0;
                        for (int i2=0;i2<4;i2++) {
                            Tile nearneartile = advNearby(i,i2); //stoopid variable naming lol
                            if (nearneartile.block() != Blocks.air) {
                                nearnearcount++;
                            }
                        }
                        if (nearnearcount<2) {
                            possibleGrowDir.add(i);
                        }
                    }
                }
                if (pulseEnd&&isRoot&&possibleGrowDir.size()>0){
                    growRoot();
                }
            }
        }
        public void growRoot() {
            Random random = new Random();
            int randomIndex = random.nextInt(possibleGrowDir.size());
            int growDir = possibleGrowDir.get(randomIndex);
            Tile targetTile = tile.nearby(growDir);
            targetTile.setBlock(block,team);
        }
        public void drawPulse(TextureRegion sprite,float scale) {
            scale+=1f;
            if (scale>0.01f) {
                float sx=x-scale*0.5f;
                float sy=y-scale*0.5f;
                Draw.scl(scale,scale);
                Draw.rect(sprite,sx,sy);
            } else {
                Draw.rect(sprite,x,y,rotation);
            }
        }
        @Override
        public void draw() {
            drawPulse(region,drawPulseScale);
        }
    }
}
