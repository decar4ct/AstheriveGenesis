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
    public TextureRegion[] topRegions = new TextureRegion[4][4];
    public ItemTube(String name){
         super(name);
    }
    @Override
    public void load(){
        super.load();
        for (int i=0;i<4;i++){
            for (int j=0;j<4;j++) {
                topRegions[i][j]=Core.atlas.find(name+"-top-"+String.valueOf(i)+"-"+String.valueOf(j));
            }
        }
    }
    @Override
    public boolean blends(Tile tile, int rotation, int otherx, int othery, int otherrot, Block otherblock){
        return (otherblock.outputsItems() || (lookingAt(tile, rotation, otherx, othery, otherblock) && otherblock.hasItems))
        && lookingAtEither(tile, rotation, otherx, othery, otherrot, otherblock);
    }
    //permanently borrowed from canvasblock.java :troll:
    public class ItemTubeBuild extends ConveyorBuild {
        @Override
        public void draw(){
            super.draw();
            Draw.rect(topRegions[blendbits==4?2:blendbits][rotation], x, y, 0);
        }
    }
}
