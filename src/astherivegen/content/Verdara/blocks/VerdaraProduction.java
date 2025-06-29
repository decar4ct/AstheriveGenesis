package astherivegen.content.Verdara.blocks;

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
import astherivegen.content.Verdara.VerdaraItems;

import static mindustry.type.ItemStack.with;

public class VerdaraProduction {
    public static Block
            mechanicalAuger, advancedAuger;
    public static void load() {
        {
            {
                mechanicalAuger = new FullDrill("mechanical-auger"){{
                    requirements(Category.production, with(VerdaraItems.quartz, 40));
                    consumePower(0.2f);

                    squareSprite = false;
                    drillTime = 1000;
                    tier = 3;
                    size = 3;
                    fogRadius = 3;
                    researchCost = with(VerdaraItems.quartz, 10);
                }};
            }
            {
                advancedAuger = new FullDrill("advanced-auger"){{
                    requirements(Category.production, with(VerdaraItems.quartz, 80));
                    consumePower(1);

                    squareSprite = false;
                    drillTime = 600;
                    tier = 5;
                    size = 3;
                    fogRadius = 3;
                    researchCost = with(VerdaraItems.quartz, 10);
                }};
            }
        }
    }
}
