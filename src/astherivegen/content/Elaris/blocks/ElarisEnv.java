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
            eonstoneFloor, eonstoneLightlyErodedFloor, eonstoneErodedFloor,
            eonstoneWall, eonstoneErodedWall;
    public static void load() {
        {
            {
                //eonstone
                //floor
                eonstoneFloor = new Floor("eonstone-floor", 5);
                eonstoneLightlyErodedFloor = new Floor("eonstone-lightly-eroded-floor", 5);
                eonstoneErodedFloor = new Floor("eonstone-eroded-floor", 5);
                //wall
                eonstoneWall = new StaticTree("eonstone-wall"){{variants = 5;}};
                eonstoneErodedWall = new StaticWall("eonstone-eroded-wall"){{variants = 4;}};
            }
        }
    }
}
