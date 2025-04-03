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
        public boolean pulsed=false;
        @Override
        public void updateTile() {
            pulseProgress+=delta();
            if (pulseProgress>=5f){
                if (!pulsed) {
                    pulsed=true;
                    updatePulse();
                    biopulse=0;
                }
            }
            if (pulseProgress>=15f){
                pulseProgress=0f;
                pulsed=false;
            }
        }
        public void updatePulse() {
            if (biopulse>0) {
                for (int i=0;i<4;i++) {
                    Building advroot = tile.nearbyBuild(i);
                    if (advroot instanceof BioBuilding advbuild) {
                        if (advbuild.biopulse>=0&&!advbuild.pulsed&&biopulse>0){
                            advbuild.biopulse=biopulse-1;
                            advbuild.pulsed=true;
                            Fx.healBlockFull.at(advbuild.x, advbuild.y, advbuild.block().size, Color.valueOf("84f491"), advbuild.block());
                        }
                    }
                }
            }
        }
    }
}
