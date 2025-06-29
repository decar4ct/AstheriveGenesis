package astherivegen.world.blocks.environment;

import arc.graphics.*;
import arc.graphics.g2d.*;
import arc.math.*;
import arc.math.geom.*;
import arc.struct.*;
import arc.util.*;
import mindustry.*;
import mindustry.content.*;
import mindustry.entities.*;
import mindustry.graphics.*;
import mindustry.world.*;
import mindustry.world.meta.*;
import mindustry.world.blocks.environment.SteamVent;

import static mindustry.Vars.*;

//can't use an overlay for this because it spans multiple tiles
public class OreCluster extends SteamVent{
    public OreCluster(String name, Item clusterItem){
        super(name);
        variants = 2;
        effect = Fx.none;
        flags = EnumSet.of(BlockFlag.steamVent);
    }
    public Item drop(){
        return lusterItem;
    }
}
