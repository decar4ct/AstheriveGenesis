package astherivegen.world.blocks.production;

import arc.*;
import arc.graphics.*;
import arc.graphics.g2d.*;
import arc.math.*;
import arc.struct.*;
import arc.util.*;
import arc.util.io.*;
import mindustry.content.*;
import mindustry.entities.*;
import mindustry.entities.units.*;
import mindustry.game.*;
import mindustry.gen.*;
import mindustry.graphics.*;
import mindustry.logic.*;
import mindustry.type.*;
import mindustry.ui.*;
import mindustry.world.*;
import mindustry.world.blocks.environment.*;
import mindustry.world.consumers.*;
import mindustry.world.meta.*;
import mindustry.world.blocks.production.Drill;

import static mindustry.Vars.*;

//a drill that can only work if all its tiles is fully covered with ores
public class FullDrill extends Drill{
    @Override
    public boolean canPlaceOn(Tile tile, Team team, int rotation){
        countOre(tile);
        if(isMultiblock()){
            for(Tile other : tile.getLinkedTilesAs(this, tempTiles)){
                if(canMine(other)){
                    if(returnCount>=size*size){
                        return true;
                    }
                }
            }
            return false;
        }else{
            return canMine(tile);
        }
    }
}
