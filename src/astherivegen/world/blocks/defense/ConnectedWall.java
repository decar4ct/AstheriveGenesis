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
        public void drawPlace(int x, int y, int rotation, boolean valid){
            drawPlace(x, y, rotation, valid);
        }
        public void draw(){
            for(int i = 0; i < 4; i++){
                Draw.rect(sideRegion, x, y, (i * 90) - 180);
            }
        }
    }
}
