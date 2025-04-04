package astherivegen.world.blocks.distribution;

import arc.Core;
import arc.graphics.*;
import arc.graphics.g2d.*;
import arc.graphics.g2d.TextureRegion;
import arc.math.*;
import arc.util.*;
import arc.math.geom.*;
import mindustry.world.blocks.distribution.*;
import mindustry.gen.Building;
import mindustry.graphics.*;
import mindustry.ui.*;
import mindustry.world.*;
import mindustry.world.Tile;

import static mindustry.Vars.*;

public class ItemOverpass extends DuctBridge {
    public TextureRegion dir1;
    public TextureRegion dir2;
    public ItemOverpass(String name){
         super(name);
    }
    @Override
    public void load(){
        super.load();
        dir1=Core.atlas.find(name+"dir1");
        dir2=Core.atlas.find(name+"dir2");
    }
    public class ItemOverpassBuild extends DuctBridgeBuild {
        @Override
        public void draw(){
            super.draw();
        }
    }
}
