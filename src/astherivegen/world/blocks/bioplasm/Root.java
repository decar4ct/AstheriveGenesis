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
    //AWFUL
    public TextureRegion[] connectedRegions = new TextureRegion[16];
    public TextureRegion[] leafRegion = new TextureRegion[2];
    public Root(String name){
        super(name);
        update=true;
        isRoot=true;
    }
    @Override
    public void load(){
        super.load();
        for (int i=0;i<16;i++){
            connectedRegions[i]=Core.atlas.find(name+String.valueOf(i+1));
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
            drawPulse(connectedRegions[blending],drawPulseScale);
            if (xyRand(x,y)<0.08f) {
                Draw.z(Layer.power-1.1f);
                Draw.rect(leafRegion[(xyRand(x+113f,y+197f)>0.5f)?0:1],x,y,xyRand(x+17f,y+11f)*360);
            }
        }
    }
}
