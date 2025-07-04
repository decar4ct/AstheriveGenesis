package astherivegen.world.blocks.bioplasm;

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
import mindustry.graphics.*;
import mindustry.content.*;
import java.util.Random;

import static mindustry.Vars.*;

public class Root extends BioBlock {
    public TextureRegion[][] atlasRegion = new TextureRegion[12][4];
    public TextureRegion[] leafRegion = new TextureRegion[2];
    //SUFFERING
    public int[] horBitmask = {
        //0 bif
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
        2,1,2,1,5,5,5,7,2,1,2,1,2,9,1,
        //6 bit <v
        3,0,3,0,3,4,3,0,3,0,3,0,3,4,3,0,2,1,2,1,5,5,5,7,2,1,2,1,2,9,1,
        //7 bit v
        3,4,3,4,3,4,3,8,3,4,3,4,3,4,3,8,5,4,5,4,5,10,5,11,5,4,5,4,7,11,7,8,3
    };
    public int[] verBitmask = {
        //0 bif
        3,
        //1 bit >
        3,
        //2 bit >^
        3,3,
        //3 bit ^
        2,1,2,2,
        //4 bit <^
        3,3,3,3,2,1,2,2,
        //8 bit <
        3,3,3,3,1,3,1,3,3,3,3,3,2,1,3,
        //6 bit <v
        3,3,3,3,2,1,2,2,3,3,3,3,2,1,2,2,3,3,3,3,1,3,1,3,3,3,3,3,2,1,3,
        //7 bit v
        0,0,0,0,1,3,1,1,0,0,0,0,1,3,1,1,0,2,0,2,2,0,2,1,0,2,0,2,2,2,0,2,2,0
    };
    public Root(String name){
        super(name);
        update=true;
        isRoot=true;
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
        for (int i=0;i<2;i++){
            leafRegion[i]=Core.atlas.find(name+"-leaf"+String.valueOf(i+1));
        }
    }
    public static float xyRand(float x,float y) {
        int xi=Float.floatToIntBits(x);
        int yi=Float.floatToIntBits(y);
        long seed=((long)xi*179424691)^((long)yi*19349663);
        Random rand=new Random(seed);
        return rand.nextFloat();
    }
    public class RootBuild extends BioBuilding {
        public int blending;
        @Override
        public void onProximityUpdate(){
            super.onProximityUpdate();
            blending = 0;
            for(int i = 0; i < 8; i++){
                if(blends(world.tile(tile.x + Geometry.d8[i].x, tile.y + Geometry.d8[i].y))){
                    blending |= (1 << i);
                }
            }
        }
        boolean blends(Tile other){
            return other != null && other.build != null && other.build.block == block && other.build.tileX() == other.x && other.build.tileY() == other.y;
        }
        @Override
        public void draw(){
            drawPulse(atlasRegion[horBitmask[blending]][verBitmask[blending]],drawPulseScale);
            if (xyRand(x,y)<0.08f) {
                Draw.z(Layer.power-1.1f);
                // SHUT UP
                //Draw.rect(leafRegion[(xyRand(x+113f,y+197f)>0.5f)?0:1],x,y,xyRand(x+17f,y+11f)*360);
            }
        }
    }
}
