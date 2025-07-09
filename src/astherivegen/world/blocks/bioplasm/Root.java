package astherivegen.world.blocks.bioplasm;

import arc.Core;
import arc.graphics.*;
import arc.graphics.g2d.*;
import arc.graphics.g2d.TextureRegion;
import arc.math.*;
import arc.util.*;
import arc.util.io.*;
import arc.math.geom.*;
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
import java.util.Random;
import astherivegen.graphics.*;
import astherivegen.content.bioplasm.Bioplasm;

import static mindustry.Vars.*;

public class Root extends BioBlock {
    public TextureRegion[][] atlasRegion = new TextureRegion[12][4];
    public TextureRegion[] leafRegion = new TextureRegion[2];
    private Seq<Building> heartArray = new Seq<>(Building.class);
    //SUFFERING
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
    public Root(String name){
        super(name);
        update=true;
        isRoot=true;
        pulseScale=0.5f;
        priority = TargetPriority.under;
        solid = false;
        underBullets = true;
        hasItems = true;
        itemCapacity = 1;
        unloadable = false;
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
        public Item lastItem;
        public int itemTargetX = -1, itemTargetY = -1;
        
        @Override
        public void updateTile(){
            super.updateTile();
            blending = 0;
            for(int i = 0; i < 8; i++){
                if(blends(world.tile(tile.x + Geometry.d8[i].x, tile.y + Geometry.d8[i].y))){
                    blending |= (1 << i);
                }
            }
        }
        @Override
        public void updatePulse(){
            super.updatePulse();
            if(tile != null && tile.drop() != null){
                boolean clear = true;
                for(int i=0;i<=1;i++){
                    for(int j=0;j<=1;j++){
                        Building adj;
                        adj = tile.nearby(i,j).build;
                        if (adj != null && !(adj instanceof RootBuild)) {                        
                            clear = false;
                        }
                    }
                }
                if(clear) tile.setBlock(Bioplasm.harvester,team);
            }
            if(lastItem == null && items.any()){
                lastItem = items.first();
            }
            if(itemTargetX == -1 || itemTargetY == -1){
                itemTargetX = getNearestHeart().tile.x;
                itemTargetY = getNearestHeart().tile.y;
            }
            if(lastItem != null && itemTargetX != -1 && itemTargetY != -1) {
                Building target = null;
                float bestDist = Float.POSITIVE_INFINITY;
                for(int i=0;i<=1;i++){
                    Building adj;
                    adj = tile.nearby(Geometry.d4(i).x,Geometry.d4(i).y).build;
                    if(adj != null && !(adj instanceof RootBuild)){
                        float dist = getDist(itemTargetX,adj.tile.x,itemTargetY,adj.tile.y);
                        if(dist<bestDist){
                            target = adj;
                            bestDist = dist;
                        }
                    }
                }
                if(target != null && target instanceof BioBuilding && target.acceptItem(this, lastItem)){
                    target.handleItem(this, lastItem);
                    items.remove(lastItem, 1);
                    lastItem = null;
                }
            }
        }
        boolean blends(Tile other){
            if(other.build instanceof BioBuilding otherbuild){
                return other != null && other.build != null && other.build.tileX() == other.x && other.build.tileY() == other.y && otherbuild.fullyGrown;
            }
            return false;
        }
        @Override
        public void draw(){
            Draw.z(Layer.blockUnder);
            if(fullyGrown){
                drawPulse(atlasRegion[horBitmask[blending]][verBitmask[blending]],drawPulseScale);
            } else {
                drawPulse(atlasRegion[3][3],drawPulseScale);
            }
            Fx.healBlockFull.at(tile.x, tile.y, tile.block().size, GenesisPal.bioGreen, tile.block());
            if (xyRand(x,y)<0.08f) {
                Draw.z(Layer.power-1.1f);
                // SHUT UP
                //Draw.rect(leafRegion[(xyRand(x+113f,y+197f)>0.5f)?0:1],x,y,xyRand(x+17f,y+11f)*360);
            }
            Draw.z(Layer.blockUnder+0.1f);
            if(lastItem!=null){
                Draw.rect(lastItem.fullIcon, x, y, itemSize, itemSize);
            }
        }

        public Building getNearestHeart() {
            float bestDist = Float.POSITIVE_INFINITY;
            Building bestBuild = null;

            heartArray.clear();
            var buildings = team.data().buildingTree;
            if(buildings == null) return null;
            int range = 50;
            buildings.intersect(wx - range, wy - range, range*2f, range*2f, b -> {
                if(b.within(wx, wy, range + b.hitSize() / 2f) && b.block instanceof BioHeart){
                    heartArray.add(b);
                }
            });
            int size = heartArray.size;
            for(int i = 0; i < size; i++){
                dist = getDist(this,heartArray[i]);
                if(dist < bestDist){
                    bestDist = dist;
                    bestBuild = heartArray[i];
                }
            }
        }

        public float getDist(Building build1,Building build2){
            return getDist(build1.tile.x,build2.tile.x,build1.tile.y,build2.tile.y);
        }

        public float getDist(int x1,int x2,int y1, int y2){
            //literally just pythagoras
            return (float)Math.sqrt((float)Math.abs(x1-x2)*Math.abs(x1-x2)+(float)Math.abs(y1-y2)*Math.abs(y1-y2));
        }

        //item mechanic

        @Override
        public int acceptStack(Item item, int amount, Teamc source){
            return 0;
        }

        @Override
        public boolean acceptItem(Building source, Item item){
            return team == source.team && lastItem == null && items.total() == 0;
        }

        @Override
        public void handleItem(Building source, Item item){
            items.add(item, 1);
            lastItem = item;
        }

        @Override
        public int removeStack(Item item, int amount){
            int result = super.removeStack(item, amount);
            if(result != 0 && item == lastItem){
                lastItem = null;
            }
            return result;
        }
    }
}
