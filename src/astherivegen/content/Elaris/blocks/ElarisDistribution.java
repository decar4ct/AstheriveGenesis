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
import astherivegen.content.Elaris.ElarisItems;

import static mindustry.type.ItemStack.with;

public class ElarisDistribution {
    public static Block
            itemTube, itemOverpass, filter, splitter;
    public static void load() {
        {
            {
                itemTube = new ItemTube("item-tube"){{
                    requirements(Category.distribution, with(ElarisItems.quartz, 1));
                    speed = 0.05f;
                    bridgeReplacement=itemOverpass;
                }};
                itemOverpass = new ItemOverpass("item-overpass"){{
                    requirements(Category.distribution, with(ElarisItems.quartz, 6, ElarisItems.magnetite, 3));
                    range=4;
                }};
                filter = new Sorter("filter"){{
                    requirements(Category.distribution, with(ElarisItems.quartz, 1));
                }};
                splitter = new Router("splitter"){{
                    requirements(Category.distribution, with(ElarisItems.quartz, 1));
                }};
            }
        }
    }
}
