package astherivegen.content.Elaris.blocks;

import arc.graphics.Color;
import mindustry.world.Block;
import mindustry.world.blocks.production.*;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.content.*;
import mindustry.graphics.*;
import mindustry.gen.Sounds;
import mindustry.content.*;
import astherivegen.world.blocks.production.*;
import astherivegen.content.Elaris.ElarisItems;

import static mindustry.type.ItemStack.with;

public class ElarisProduction {
    public static Block
            cliffBore;
    public static void load() {
        {
            {
                cliffBore = new CliffDrill("cliff-bore"){{
                    requirements(Category.production, with(ElarisItems.quartz, 20));
                    consumePower(0.15f);

                    drillTime = 200f;
                    tier = 3;
                    size = 3;
                    range = 5;
                    fogRadius = 3;
                    researchCost = with(ElarisItems.quartz, 10);
                }};
            }
        }
    }
}
