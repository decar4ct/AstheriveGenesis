package astherivegen.content.Verdara.blocks;

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
import astherivegen.content.Verdara.VerdaraItems;
import mindustry.content.*;

import static mindustry.type.ItemStack.with;

public class VerdaraDefense {
    public static Block
            quartzWall,
            renewer;
    public static void load() {
        {
            {
                quartzWall = new ConnectedWall("quartz-wall"){{
                    requirements(Category.defense, with(VerdaraItems.quartz, 6));
                }};
                renewer = new RegenProjector("renewer"){{
                    requirements(Category.effect, with(VerdaraItems.quartz, 30, VerdaraItems.magnetite, 30, VerdaraItems.polterite, 20));
                    size = 3;
                    health = 400;
                    drawer = new DrawMulti(new DrawDefault(), new DrawRegion("-mid", -1, true), new DrawRegion("-top", 2, true), new DrawPulseShape(false));
                }};
            }
        }
    }
}
