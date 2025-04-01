package astherivegen.world.blocks.distribution;

import arc.Core;
import arc.graphics.*;
import arc.graphics.g2d.*;
import arc.graphics.g2d.TextureRegion;
import arc.math.*;
import arc.util.*;
import arc.math.geom.*;
import mindustry.world.blocks.distribution.*;
import mindustry.gen.Building;
import mindustry.graphics.*;
import mindustry.ui.*;
import mindustry.world.*;
import mindustry.world.Tile;

import static mindustry.Vars.*;

public class ItemTube extends Conveyor {
    //AWFUL
    public TextureRegion[] topRegions = new TextureRegion[16];
    public ItemTube(String name){
         super(name);
    }
    @Override
    public void load(){
        super.load();
        for (int i=0;i<16;i++){
            topRegions[i]=Core.atlas.find(name+"-top"+String.valueOf(i+1));
        }
    }
    //permanently borrowed from canvasblock.java :troll:
    public class ItemTubeBuild extends ConveyorBuild {
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
            return other.build != null &&
                (other.build.block.outputsItems() || (other.build.block == block &&
                                                      lookingAt(other, other.build.rotation, tile.x, tile.y, block)))
                && other.build.tileX() == other.x && other.build.tileY() == other.y;
        }
        @Override
        public void draw(){
            super.draw();
            Draw.rect(topRegions[blending], x, y, 0);
        }
    }
}
