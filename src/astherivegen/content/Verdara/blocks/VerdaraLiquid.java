package astherivegen.content.Verdara.blocks;

import arc.graphics.Color;
import mindustry.world.Block;
import mindustry.world.blocks.distribution.*;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.content.*;
import mindustry.graphics.*;
import mindustry.gen.Sounds;
import mindustry.content.*;
import astherivegen.world.blocks.liquid.*;
import astherivegen.content.Verdara.VerdaraItems;

import static mindustry.type.ItemStack.with;

public class VerdaraLiquid{
    public static Block
            pipe;
    public static void load() {
        {
            {
                pipe = new LiquidPipe("pipe"){{
                    requirements(Category.liquid, with(VerdaraItems.quartz, 2));
                }};
            }
        }
    }
}
