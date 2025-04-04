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
        public boolean hasPulse=false;
        public boolean removePulse=false;
        @Override
        public void updateTile() {
            pulseProgress+=delta();
            if (pulseProgress>=5f){
                if (!pulsed) {
                    if (biopulse>0) hasPulse=true;
                    updatePulse();
                    pulsed=true;
                    if (removePulse) {
                        hasPulse=false;
                        removePulse=false;
                    }
                }
            }
            if (pulseProgress>=15f){
                pulseProgress=0f;
                if (hasPulse=true) {
                    removePulse=true;
                    biopulse=0;
                }
                pulsed=false;
                updateAfterPulse();
            }
        }
        public void updatePulse() {
            //TODO rework from this->pulse to pulse->this
            int maxPulse=0;
            if (!hasPulse) {
                for (int i=0;i<4;i++) {
                    Building advroot = tile.nearbyBuild(i);
                    if (advroot instanceof BioBuilding advbuild) {
                        if (true) {                        
                            maxPulse=Math.max(advbuild.biopulse,maxPulse);
                        }
                    }
                }
            }
            if (maxPulse>0) {
                Fx.healBlockFull.at(x, y, block.size, Color.valueOf("84f491"), block);
                biopulse=maxPulse;
            }
        }
        public void updateAfterPulse() {
            //Overriden by subclass
        }
    }
}
