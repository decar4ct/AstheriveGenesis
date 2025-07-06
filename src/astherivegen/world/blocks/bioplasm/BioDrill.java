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
import mindustry.entities.*;
import java.util.Random;
import astherivegen.graphics.*;

import static mindustry.Vars.*;

public class BioDrill extends BioBlock {
    protected final ObjectIntMap<Item> oreCount = new ObjectIntMap<>();
    protected final Seq<Item> itemArray = new Seq<>();
    protected @Nullable Item returnItem;
    protected int returnCount;
    
    public BioDrill(String name){
        super(name);
        update=true;
        isRoot=false;
    }

    protected void countOre(Tile tile){
        returnItem = null;
        returnCount = 0;

        oreCount.clear();
        itemArray.clear();

        for(Tile other : tile.getLinkedTilesAs(this, tempTiles)){
            if(canMine(other)){
                oreCount.increment(getDrop(other), 0, 1);
            }
        }

        for(Item item : oreCount.keys()){
            itemArray.add(item);
        }

        itemArray.sort((item1, item2) -> {
            int type = Boolean.compare(!item1.lowPriority, !item2.lowPriority);
            if(type != 0) return type;
            int amounts = Integer.compare(oreCount.get(item1, 0), oreCount.get(item2, 0));
            if(amounts != 0) return amounts;
            return Integer.compare(item1.id, item2.id);
        });

        if(itemArray.size == 0){
            return;
        }

        returnItem = itemArray.peek();
        returnCount = oreCount.get(itemArray.peek(), 0);
    }
    
    public class BioDrillBuild extends BioBuilding {
        public int drillProgress = 0;
        
        @Override
        public void updatePulse() {
            //TODO rework back to this->pulse
            //ONLY WORK FOR 2x2, smh my head
            if (true) {
                for(int i=0;i<4;i++){
                    for(int j=0;j<=1;j++){
                        Building adj;
                        if(i==0){
                            adj = tile.nearby(Geometry.d4(i).x*2,Geometry.d4(i).y*2+j).build;
                        } else if(i==1) {
                            adj = tile.nearby(Geometry.d4(i).x*2+j,Geometry.d4(i).y*2).build;
                        } else if(i==2) {
                            adj = tile.nearby(Geometry.d4(i).x,Geometry.d4(i).y+j).build;
                        } else {
                            adj = tile.nearby(Geometry.d4(i).x+j,Geometry.d4(i).y).build;
                        }
                        if (adj instanceof BioBuilding adjbuild) {
                            if (!adjbuild.pulsed) {                        
                                adjbuild.biopulse=Math.max(adjbuild.biopulse,biopulse-8); //less biopulse because drill ate it
                            }
                        }
                    }
                }
                if(drillProgress<4){
                    drillProgress++;
                } else {
                    drillProgress = 0;
                    if(items.total()<itemCapacity){
                        countOre(tile);
                        for(int i = 0; i < returnCount; i++){
                            offload(returnItem);
                        }
                    }
                }
            }
        }
        @Override
        public void draw(){
            drawPulse(block.region,drawPulseScale);
        }
        @Override
        public void write(Writes write){
            super.write(write);
            write.i(drillProgress);
        }

        @Override
        public void read(Reads read, byte revision){
            super.read(read, revision);
            drillProgress=read.i();
        }
    }
 }     
