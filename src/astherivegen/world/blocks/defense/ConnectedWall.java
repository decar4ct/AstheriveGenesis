package astherivegen.world.blocks.defense;

import arc.graphics.*;
import arc.graphics.g2d.*;
import arc.graphics.g2d.TextureRegion;
import arc.math.*;
import arc.util.*;
import mindustry.world.blocks.defense.*;

public class ConnectedWall extends Wall {
    public TextureRegion sideRegion;
    public ConnectedWall(String name){
        super(name);
    }

    public class ConnectedWallBuild extends WallBuild {
        public void load(){
            super.load();
            sideRegion = Core.atlas.find(name + "-side");
        }
        
        public void draw(){
            for(int i = 0; i < 4; i++){
                Draw.rect(sideRegion, x, y, (i * 90) - 180);
            }
        }
    }
}
