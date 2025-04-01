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
        @Override
        public void draw(){
            super.draw();
            Draw.rect(topRegions[blending], x, y, 0);
            Log.info(blendbits,blendsclx,blendscly,blending);
        }
    }
}
