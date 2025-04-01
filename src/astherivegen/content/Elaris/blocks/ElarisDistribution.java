package astherivegen.content.Elaris.blocks;

import arc.graphics.Color;
import mindustry.world.Block;
import mindustry.world.blocks.distribution.*;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.content.*;
import mindustry.graphics.*;
import mindustry.gen.Sounds;
import mindustry.content.*;
import astherivegen.world.blocks.distribution.*;

import static mindustry.type.ItemStack.with;

public class ElarisDistribution {
    public static Block
            itemTube;
    public static void load() {
        {
            {
                itemTube = new ItemTube("item-tube"){{
                    requirements(Category.distribution, with(Items.copper, 1));
                    speed = 4;
                }};
            }
        }
    }
}
