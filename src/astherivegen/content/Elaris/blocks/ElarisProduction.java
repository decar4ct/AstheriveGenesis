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
            mechanicalAuger;
    public static void load() {
        {
            {
                mechanicalAuger = new Drill("mechanical-auger"){{
                    requirements(Category.production, with(ElarisItems.quartz, 40));
                    consumePower(0.2f);

                    drillTime = 200;
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
