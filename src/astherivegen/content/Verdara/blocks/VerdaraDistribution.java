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
import astherivegen.world.blocks.distribution.*;
import astherivegen.content.Verdara.VerdaraItems;

import static mindustry.type.ItemStack.with;

public class VerdaraDistribution {
    public static Block
            itemTube, itemOverpass, filter, splitter, itemGate;
    public static void load() {
        {
            {
                itemTube = new ItemTube("item-tube"){{
                    requirements(Category.distribution, with(VerdaraItems.quartz, 1));
                    speed = 0.065f;
                    displayedSpeed = 9f;
                    rotBridgeReplacement=itemOverpass;
                }};
                itemOverpass = new ItemOverpass("item-overpass"){{
                    requirements(Category.distribution, with(VerdaraItems.quartz, 6, VerdaraItems.magnetite, 3));
                    range=4;
                }};
                filter = new Sorter("filter"){{
                    requirements(Category.distribution, with(VerdaraItems.quartz, 4, VerdaraItems.magnetite, 2));
                }};
                splitter = new Router("splitter"){{
                    requirements(Category.distribution, with(VerdaraItems.quartz, 5));
                }};
                itemGate = new OverflowGate("item-gate"){{
                    requirements(Category.distribution, with(VerdaraItems.quartz, 4, VerdaraItems.magnetite, 2));
            }
        }
    }
}
