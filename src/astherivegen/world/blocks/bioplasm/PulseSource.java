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

public class PulseSource extends BioBlock {
    public PulseSource(String name){
        super(name);
    }
    public class PulseSourceBuild extends BioBuilding {
        public int pulseDelay=0;
        @Override
        public void updatePulse() {
            if (pulseDelay>=4) {
                pulseDelay=0;
                bioPulse=16;
            } else {
                pulseDelay++;
            }
        }
        @Override
        public void updateAfterPulse() {
            bioPulse=0;
        }
    }
}
