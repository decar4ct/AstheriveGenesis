package astherivegen.content.Verdara.blocks;

import arc.graphics.Color;
import mindustry.world.Block;
import mindustry.world.blocks.distribution.*;
import mindustry.world.blocks.production.*;
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
            pipe, outlet;
    public static void load() {
        {
            {
                pistonPump = new Pump("piston-pump"){{
                    requirements(Category.liquid, with(VerdaraItems.quartz, 25, VerdaraItems.magnetite, 10));
                    
                    drawer = new DrawMulti(new DrawRegion("-bottom"), new DrawPumpLiquid(), new DrawPistons(){{
                    sinMag = 2.75f;
                    sinScl = 5f;
                    sides = 4;
                    sideOffset = (float) Math.PI / 2f;
                    angleOffset = 45f;
                    }}, new DrawDefault());
                    size = 2;
                    researchCostMultiplier = 0.05f;
                    consumePower(10/60f);
                    hasPower = true;
                    liquidCapacity = 20f;
                    pumpAmount = 8/60f;
                }};
                pipe = new LiquidPipe("pipe"){{
                    requirements(Category.liquid, with(VerdaraItems.quartz, 2));
                }};
                outlet = new PipePump("outlet"){{
                    requirements(Category.liquid, with(VerdaraItems.quartz, 10));
                }};
            }
        }
    }
}
