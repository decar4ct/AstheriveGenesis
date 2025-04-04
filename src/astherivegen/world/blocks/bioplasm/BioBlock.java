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

import static mindustry.Vars.*;

public class BioBlock extends Block {
    public BioBlock(String name){
        super(name);
        update=true;
    }
    public class BioBuilding extends Building {
        public float pulseProgress=0;
        public int biopulse=0;
        public float pulseTimer=0;
        public float resetPulseTimer=0;
        public boolean pulsed=false;

        public float drawPulseScale=0;
        @Override
        public void updateTile() {
            //TODO try syncing invididually?
            if (biopulse>0&&!pulsed){
                if (pulseTimer<5f) {
                    pulseTimer+=delta();
                } else {
                    updatePulse();
                    pulseTimer=0;
                    biopulse=0;
                    pulsed=true;
                    drawPulseScale=1;
                }
            }
            if (pulsed) {
                if (resetPulseTimer<8f) {
                    resetPulseTimer+=delta();
                } else {
                    resetPulseTimer=0;
                    pulsed=false;
                }
            }
            
            if (drawPulseScale>0.01f) {
                drawPulseScale*=0.75;
            }
        }
        public void updatePulse() {
            //TODO rework back to this->pulse
            if (true) {
                for (int i=0;i<4;i++) {
                    Building advroot = tile.nearbyBuild(i);
                    if (advroot instanceof BioBuilding advbuild) {
                        if (!advbuild.pulsed) {                        
                            advbuild.biopulse=Math.max(advbuild.biopulse,biopulse-1);
                        }
                    }
                }
            }
        }
        public void drawPulse(TextureRegion sprite,float scale) {
            float sx=x-block.size*scale*0.5;
            float sy=y-block.size*scale*0.5;
            Draw.scl(scale,scale);
            Draw.rect(sprite,sx,sy);
        }
        @Override
        public void draw() {
            if (drawPulseScale>0.01f) {
                drawPulse(region,drawPulseScale+1);
            } else {
                super.draw();
            }
        }
    }
}
