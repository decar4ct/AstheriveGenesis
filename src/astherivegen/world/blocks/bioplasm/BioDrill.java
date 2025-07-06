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
        public void draw(){
            drawPulse(block.region,drawPulseScale);
        }
    }
}
