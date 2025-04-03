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

public class PulseSource extends Block {
    public Root(String name){
        super(name);
        update=true;
    }
    public class PulseSourceBuild extends Building {
        @Override
        public void updateTile() {
            for (int i=0;i<4;i++) {
                Building advroot = tile.nearbyBuild(i);
                if (advroot instanceof RootBuild advbuild) {
                    if (advbuild.biopulse>0){
                        advbuild.biopulse=biopulse-1;
                        Fx.healBlockFull.at(advbuild.x, advbuild.y, advbuild.block().size, Color.valueOf("84f491"), advbuild.block());
                    }
                }
            }
        }
    }
}
