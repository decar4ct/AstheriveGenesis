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

public class Root extends Block {
    //AWFUL
    public TextureRegion[] connectedRegions = new TextureRegion[16];
    public int biopulse = 0;
    public Root(String name){
        super(name);
        update=true;
    }
    @Override
    public void load(){
        super.load();
        for (int i=0;i<16;i++){
            connectedRegions[i]=Core.atlas.find(name+String.valueOf(i+1));
        }
    }
    public class RootBuild extends Building {
        public int blending;
        @Override
        public void onProximityUpdate(){
            super.onProximityUpdate();
            blending = 0;
            for(int i = 0; i < 4; i++){
                if(blends(world.tile(tile.x + Geometry.d4[i].x, tile.y + Geometry.d4[i].y))){
                    blending |= (1 << i);
                }
            }
        }
        boolean blends(Tile other){
            return other != null && other.build != null && other.build.block == block && other.build.tileX() == other.x && other.build.tileY() == other.y;
        }
        @Override
        public void draw(){
            Draw.rect(connectedRegions[blending], x, y, 0);
        }
        @Override
        public void updateTile() {
            for (int i=0;i<4;i++) {
                Building advroot = tile.nearbyBuild(i);
                if (advroot instanceof Building) {
                    if (advroot.getPulse()>0){
                        advroot.setPulse(biopulse-1);
                        Fx.healBlockFull.at(advroot.x, advroot.y, advroot.block().size, Color.valueOf("84f491"), advroot.block());
                    }
                }
            }
            biopulse=biopulse>0?-1:0;
        }
        public int getPulse() {
            return biopulse;
        }
        public void setPulse(int amount) {
            biopulse=amount;
        }
    }
}
