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
    public TextureRegion side;
    public ItemOverpass(String name){
         super(name);
    }
    @Override
    public void load(){
        super.load();
        dir1=Core.atlas.find(name+"-dir1");
        dir2=Core.atlas.find(name+"-dir2");
        side=Core.atlas.find(name+"-dir-side");
    }
    public class ItemOverpassBuild extends DuctBridgeBuild {
        @Override
        public void draw(){
            Draw.rect(region, x, y);
            if (rotation<2){
                Draw.rect(dir1, x, y, rotation*90);
            } else {
                Draw.rect(dir2, x, y, rotation*90);
            }
            Draw.rect(side, x, y, rotation%2==0?0:90);
            var link = findLink();
            if(link != null){
                Draw.z(Layer.power - 1);
                drawBridge(rotation, x, y, link.x, link.y, null);
            }
        }
    }
}
