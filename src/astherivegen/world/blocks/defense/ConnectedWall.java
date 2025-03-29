package astherivegen.world.blocks.defense;

import arc.Core;
import arc.graphics.*;
import arc.graphics.g2d.*;
import arc.graphics.g2d.TextureRegion;
import arc.math.*;
import arc.util.*;
import mindustry.world.blocks.defense.*;
import mindustry.gen.Building;
import mindustry.graphics.*;
import mindustry.world.Tile;

public class ConnectedWall extends Wall {
    public TextureRegion sideRegion;
    public ConnectedWall(String name){
        super(name);
    }
    @Override
    public void load(){
        super.load();
        sideRegion = Core.atlas.find(name);
    }
    public class ConnectedWallBuild extends WallBuild {
        @Override
        public void draw(){
            super.draw();
            Draw.rect(region, x, y, 0);
            for (int i=0;i<4;i++) {
                Draw.rect(sideRegion, x, y, 90+i*90);
            }
        }
    }
}
