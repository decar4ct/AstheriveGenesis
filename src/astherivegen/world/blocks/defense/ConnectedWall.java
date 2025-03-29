package astherivegen.world.blocks.defense;

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
import mindustry.world.Tile;

public class ConnectedWall extends Wall {
    public TextureRegion sideRegion;
    public ConnectedWall(String name){
         super(name);
    }
    @Override
    public void load(){
        super.load();
        sideRegion = Core.atlas.find(name+"-side");
    }
    //permanently borrowed from canvasblock.java :troll:
    public class ConnectedWallBuild extends WallBuild {
        public int blending;
        @Override
        public void onProximityUpdate(){
            super.onProximityUpdate();

            blending = 0;
            for(int i = 0; i < 4; i++){
                if(blends(world.tile(tile.x + Geometry.d4[i].x * size, tile.y + Geometry.d4[i].y * size))) blending |= (1 << i);
            }
        }
        boolean blends(Tile other){
            return other != null && other.build != null && other.build.block == block && other.build.tileX() == other.x && other.build.tileY() == other.y;
        }
        @Override
        public void draw(){
            super.draw();
            Draw.rect(region, x, y, 0);
            for(int i = 0; i < 4; i ++){
                if((blending & (1 << i)) == 0){
                    Draw.rect(i >= 2 ? sideRegion : sideRegion, x, y, i * 90);

                    if((blending & (1 << ((i + 1) % 4))) != 0){
                        Draw.rect(i >= 2 ? sideRegion : sideRegion, x, y, i * 90);
                    }

                    if((blending & (1 << (Mathf.mod(i - 1, 4)))) != 0){
                        Draw.yscl = -1f;
                        Draw.rect(i >= 2 ? sideRegion : sideRegion, x, y, i * 90);
                        Draw.yscl = 1f;
                    }
                }
            }
        }
    }
}
