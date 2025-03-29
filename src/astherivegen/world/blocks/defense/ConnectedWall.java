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
    
    @Override
    public void load(){
        super.load();
        sideRegion = Core.atlas.find(name+"-side");
    }
    //permanently borrowed from payloadblock.java :troll:
    public static boolean blends(Building build){
        Building accept = build.nearby(Geometry.d4(direction).x, Geometry.d4(direction).y);
        return accept != null && (accept.block.size == size
            && Math.me+"-side");
    }
    //permanently borrowed from payloadblock.java :troll:
    public static boolean blends(Building build){
        Building accept = build.nearby(Geometry.d4(direction).x, Geometry.d4(direction).y);
        return accept != null &&

            //if size is the same, block must either be facing this one, or not 
            (accept.block.size == size
            && Math.abs(accept.tileX() - build.tileX()) % size == 0 //check alignment
            && Math.abs(accept.tileY() - build.tileY()) % size == 0);
    }
    public class ConnectedWallBuild extends WallBuild {
        @Override
        public void draw(){
            super.draw();
            Draw.rect(region, x, y, 0);
            for (int i=0;i<4;i++) {
                if (blends(i)){
                    Draw.rect(sideRegion, x, y, (i*90)-180);
                }
            }
        }
    }
}
