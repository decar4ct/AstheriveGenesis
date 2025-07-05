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
import astherivegen.content.bioplasm.Bioplasm;

import static mindustry.Vars.*;

public class BioHeart extends BioBlock {
    public BioHeart(String name){
        super(name);
    }
    public class BioHeartBuild extends BioBuilding {        
        @Override
        public void updateTile() {
            if (true){
                if (pulseTimer<45f) {
                    pulseTimer+=delta();
                } else {
                    updatePulse();
                    pulseTimer=0;
                    drawPulseScale=pulseScale;
                    growRoots();
                }
                if (drawPulseScale>0.01f) {
                    drawPulseScale*=0.9;
                }
            }
        }
        public void updatePulse() {
            //TODO rework back to this->pulse
            if (true) {
                for (int i=0;i<4;i++) {
                    Building advroot = tile.nearbyBuild(i);
                    if (advroot instanceof BioBuilding advbuild) {
                        if (!advbuild.pulsed) {                        
                            advbuild.biopulse=Math.max(advbuild.biopulse,32);
                        }
                    }
                }
            }
        }
        public void growRoots(){
            //only for 3x3 block smh
            //well who cares lmao
            for(int i=0;i<4;i++){
                for(int j=-1;j<=1;j++){
                    Tile adj;
                    if(i==0||i==2){
                        adj = tile.nearby(Geometry.d4(i).x*2,Geometry.d4(i).y*2+j);
                    } else {
                        adj = tile.nearby(Geometry.d4(i).x*2+j,Geometry.d4(i).y*2);
                    }
                    adj.setBlock(Bioplasm.root,team);
                }
            }
        }
        @Override
        public void draw(){
            drawPulse(block.region,drawPulseScale);
        }
    }
}

