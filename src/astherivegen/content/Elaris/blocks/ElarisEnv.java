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
            eonstoneFloor;
    public static void load() {
        {
            {
                //eonstone
                //floor
                eonstoneFloor = new Floor("eonstone-floor", 4);
            }
        }
    }
}
