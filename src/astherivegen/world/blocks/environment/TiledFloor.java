package astherivegen.world.blocks.environment;

import arc.Core;
import arc.graphics.*;
import arc.graphics.g2d.*;
import arc.graphics.g2d.TextureRegion;
import arc.math.*;
import arc.util.*;
import arc.util.io.*;
import arc.math.geom.*;
import arc.struct.*;
import mindustry.world.blocks.defense.*;
import mindustry.gen.Building;
import mindustry.graphics.*;
import mindustry.ui.*;
import mindustry.world.*;
import mindustry.world.Tile;
import mindustry.graphics.*;
import mindustry.content.*;
import mindustry.entities.*;
import mindustry.type.*;
import mindustry.world.meta.*;
import mindustry.gen.*;
import mindustry.world.blocks.environment.*;

import static mindustry.Vars.*;

public class TiledFloor extends Floor {
    public TextureRegion[][] atlasRegion = new TextureRegion[12][4];
    
    //...manually written
    public int[] horBitmask = {
        //0 bit
        3,
        //1 bit >
        0,
        //2 bit >^
        3,0,
        //3 bit ^
        3,4,3,0,
        //4 bit <^
        3,0,3,0,3,4,3,0,
        //5 bit <
        2,1,2,1,5,5,5,7,2,1,2,1,2,9,2,1,
        //6 bit <v
        3,0,3,0,3,4,3,0,3,0,3,0,3,4,3,0,2,1,2,1,5,5,5,7,2,1,2,1,2,9,2,1,
        //7 bit v
        3,4,3,4,3,4,3,8,3,4,3,4,3,4,3,8,5,4,5,4,5,10,5,11,5,4,5,4,7,11,7,8,3,4,3,4,3,4,3,8,3,4,3,4,3,4,3,8,2,6,2,6,9,11,9,10,2,6,2,6,2,8,2,6,
        //8 bit >v
        3,0,3,0,3,4,3,0,3,0,3,0,3,4,3,0,2,1,2,1,5,5,5,7,2,1,2,1,2,9,2,1,3,0,3,0,3,4,3,0,3,0,3,0,3,4,3,0,2,1,2,1,5,5,5,7,2,1,2,1,2,9,2,1,3,0,3,0,3,6,3,0,3,0,3,0,3,6,3,0,5,8,5,8,5,11,5,9,5,8,5,8,7,10,7,7,3,0,3,0,3,6,3,0,3,0,3,0,3,6,3,0,2,1,2,1,9,9,9,7,2,1,2,1,2,6,2,1
    };
    public int[] verBitmask = {
        //0 bit
        3,
        //1 bit >
        3,
        //2 bit >^
        3,3,
        //3 bit ^
        2,1,2,2,
        //4 bit <^
        3,3,3,3,2,1,2,2,
        //5 bit <
        3,3,3,3,1,3,1,3,3,3,3,3,2,1,2,2,
        //6 bit <v
        3,3,3,3,2,1,2,2,3,3,3,3,2,1,2,2,3,3,3,3,1,3,1,3,3,3,3,3,2,1,2,2,
        //7 bit v
        0,0,0,0,1,3,1,1,0,0,0,0,1,3,1,1,0,2,0,2,2, 0,2, 1,0,2,0,2,2, 0,2,2,0,0,0,0,1,3,1,1,0,0,0,0,1,3,1,1,0,2,0,2,0, 3,0, 1,0,2,0,2,1,3,1,0,
        //8 bit >v
        3,3,3,3,2,1,2,2,3,3,3,3,2,1,2,2,3,3,3,3,1,3,1,3,3,3,3,3,2,1,2,2,3,3,3,3,2,1,2,2,3,3,3,3,2,1,2,2,3,3,3,3,1,3,1,3,3,3,3,3,2,1,2,2,0,0,0,0,1,3,1,1,0,0,0,0,1,3,1,1,0,0,0,0,2,2,2,2,0,0,0,0,2,2,2,0,0,0,0,0,1,3,1,1,0,0,0,0,1,3,1,1,0,0,0,0,0,3,0,1,0,0,0,0,1,1,1,1
        
    };
    public TiledFloor(String name){
        super(name);
        update=true;
    }
    @Override
    public void load(){
        super.load();
        int y = 0;
        for(int cy = 0; cy < 4; cy++, y += 32){
            int x = 0;
            for(int cx = 0; cx < 12; cx++, x += 32){
                atlasRegion[cx][cy] = new TextureRegion(Core.atlas.find(name+"-atlas"), x, y, 32, 32);
            }
        }
    }
    boolean blends(Tile tile,Tile other){
        return(other.floor().realBlendId(other) > realBlendId(tile));
    }
    public void drawMain(Tile tile){
        int blending = 0;
            for(int i = 0; i < 8; i++){
                if(blends(tile,world.tile(tile.x + Geometry.d8[i].x, tile.y + Geometry.d8[i].y))){
                    blending |= (1 << i);
                }
            }
        Draw.rect(atlasRegion[horBitmask[blending]][verBitmask[blending]], tile.worldx(), tile.worldy());      
        Draw.alpha(1f);
    }  
}
                               
