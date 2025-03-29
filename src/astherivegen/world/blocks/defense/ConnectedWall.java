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
import mindustry.ui.*;
import mindustry.world.*;
import mindustry.world.Tile;

import static mindustry.Vars.*;

public class ConnectedWall extends Wall {
    //AWFUL
    public TextureRegion[] connectedRegions = new TextureRegion[15];
    public ConnectedWall(String name){
         super(name);
    }
    @Override
    public void load(){
        super.load();
        for (int i=0;i<15;i++){
            connectedRegions[i]=Core.atlas.find(name+String.valueOf(i+1));
        }
    }
    //permanently borrowed from canvasblock.java :troll:
    public class ConnectedWallBuild extends WallBuild {
        public int blending;
        @Override
        public void onProximityUpdate(){
            super.onProximityUpdate();
            blending = 0;
            for(int i = 0; i < 4; i++){
                if(blends(world.tile(tile.x + Geometry.d4[i].x, tile.y + Geometry.d4[i].y))){
                    blending |= (1 << i);
                }
            }
        }
        boolean blends(Tile other){
            return other != null && other.build != null && other.build.block == block && other.build.tileX() == other.x && other.build.tileY() == other.y;
        }
        @Override
        public void draw(){
            super.draw();
            Draw.rect(connectedRegions[blending], x, y, 0);
        }
    }
}
