package astherivegen.content.Elaris.blocks;

import arc.graphics.Color;
import mindustry.world.Block;
import mindustry.world.blocks.environment.*;
import mindustry.type.Category;
import mindustry.type.ItemStack;

import static mindustry.type.ItemStack.with;

public class ElarisEnv {
    public static Block
            //eonstone
            eonstoneFloor,
            eonstoneWall;
    public static void load() {
        {
            {
                //eonstone
                //floor
                eonstoneFloor = new Floor("eonstone-floor", 4);
                //wall
                eonstoneWall = new StaticWall("eadston-wall"){{variants = 2;
                    eonstoneloor.asFloor().wall = this;
            }
        }
    }
}
