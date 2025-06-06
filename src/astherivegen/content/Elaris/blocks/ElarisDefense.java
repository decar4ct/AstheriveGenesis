package astherivegen.content.Elaris.blocks;

import arc.graphics.Color;
import mindustry.world.Block;
import mindustry.world.blocks.defense.*;
import mindustry.world.draw.*;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.content.*;
import mindustry.graphics.*;
import mindustry.gen.Sounds;
import astherivegen.world.blocks.defense.*;
import astherivegen.content.*;
import astherivegen.content.Elaris.ElarisItems;
import mindustry.content.*;

import static mindustry.type.ItemStack.with;

public class ElarisDefense {
    public static Block
            quartzWall,
            renewer;
    public static void load() {
        {
            {
                quartzWall = new ConnectedWall("quartz-wall"){{
                    requirements(Category.defense, with(ElarisItems.quartz, 6));
                }};
                renewer = new RegenProjector("renewer"){{
                    requirements(Category.effect, with(ElarisItems.quartz, 30, ElarisItems.magnetite, 30, ElarisItems.polterite, 20));
                    size = 3;
                    health = 400;
                    drawer = new DrawMulti(new DrawDefault(), new DrawRegion("-mid", -1, true), new DrawRegion("-top", 2, true), new DrawPulseShape(false));
                }};
            }
        }
    }
}
