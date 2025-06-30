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
            clusterDrill;
    public static void load() {
        {
            {
                clusterDrill = new ClusterDrill("cluster-drill"){{
                    requirements(Category.production, with(VerdaraItems.quartz, 20, VerdaraItems.magnetite, 15));
                    consumePower(0.5f);
                    consumeLiquid(Liquids.hydrogen, 0.05f).boost();

                    squareSprite = false;
                    drillTime = 700;
                    tier = 3;
                    size = 3;
                    fogRadius = 3;
                    researchCost = with(VerdaraItems.quartz, 10);
                }};
            }
        }
    }
}
