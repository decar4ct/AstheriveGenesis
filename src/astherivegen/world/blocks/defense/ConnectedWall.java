package astherivegen.world.blocks.defense;

import arc.Core;
import arc.graphics.*;
import arc.graphics.g2d.*;
import arc.graphics.g2d.TextureRegion;
import arc.math.*;
import arc.util.*;
import mindustry.world.blocks.defense.*;
import mindustry.gen.Building;
import mindustry.graphics.Drawf;
import mindustry.graphics.Layer;
import mindustry.graphics.Pal;

public class ConnectedWall extends Wall {
    public TextureRegion sideRegion;
    public ConnectedWall(String name){
        super(name);
    }

    public class ConnectedWallBuild extends WallBuild {
        public void load(){
            sideRegion = Core.atlas.find(name + "-side");
        }
        @Override
        public void draw(){
            super.draw();
            Draw.rect(region, x, y);
        }
    }
}
