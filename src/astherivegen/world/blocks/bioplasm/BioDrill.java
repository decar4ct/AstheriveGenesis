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
import mindustry.entities.*;
import java.util.Random;
import astherivegen.graphics.*;

import static mindustry.Vars.*;

public class BioDrill extends BioBlock {
    public BioDrill(String name){
        super(name);
        update=true;
        isRoot=false;
    }
    public class BioDrillBuild extends BioBuilding {
        @Override
        public void updatePulse() {
            //TODO rework back to this->pulse
            //ONLY WORK FOR 2x2, smh my head
            if (true) {
                for(int i=0;i<4;i++){
                    for(int j=0;j<=1;j++){
                        Building adj;
                        if(i==0){
                            adj = tile.nearby(Geometry.d4(i).x*2,Geometry.d4(i).y*2+j).build;
                        } else if(i==1) {
                            adj = tile.nearby(Geometry.d4(i).x*2+j,Geometry.d4(i).y*2).build;
                        } else if(i==2) {
                            adj = tile.nearby(Geometry.d4(i).x,Geometry.d4(i).y+j).build;
                        } else {
                            adj = tile.nearby(Geometry.d4(i).x+j,Geometry.d4(i).y).build;
                        }
                        if (adj instanceof BioBuilding adjbuild) {
                            if (!adjbuild.pulsed) {                        
                                adjbuild.biopulse=Math.max(adjbuild.biopulse,biopulse-8); //less biopulse because drill ate it
                            }
                        }
                    }
                }
            }
        }
        @Override
        public void draw(){
            drawPulse(block.region,drawPulseScale);
        }
    }
}
