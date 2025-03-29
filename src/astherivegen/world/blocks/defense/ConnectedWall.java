package astherivegen.world.blocks.defense;

import arc.graphics.*;
import arc.graphics.g2d.*;
import arc.math.*;
import arc.util.*;
import mindustry.world.blocks.defense.*;

public class ConnectedWall extends Wall {
    public @Load("@-side") TextureRegion sideRegion;
    public ConnectedWall(String name){
        super(name);
    };

    public class ConnectedWallBuild extends WallBuild {
        public void draw(){
            for(int i = 0; i < 4; i++)
                Draw.rect(sideRegion, x, y, (i * 90) - 180);
            }
        }
    };
}
