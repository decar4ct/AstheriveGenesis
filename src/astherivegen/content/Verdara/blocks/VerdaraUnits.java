package astherivegen.content.Verdara.blocks;

import arc.graphics.Color;
import mindustry.world.Block;
import mindustry.world.blocks.units.*;
import mindustry.world.draw.*;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.content.*;
import mindustry.graphics.*;
import mindustry.gen.Sounds;
import astherivegen.content.*;
import astherivegen.content.Verdara.VerdaraItems;
import astherivegen.content.Verdara.*;
import mindustry.content.*;

import static mindustry.type.ItemStack.with;

public class VerdaraUnits {
    public static Block
            mechAssembler;
    public static void load() {
        {
            {
                mechAssembler = new UnitFactory("mech-assembler"){{
                    requirements(Category.units, with(VerdaraItems.polterite, 15, VerdaraItems.quartz, 30, VerdaraItems.magnetite,25));
                    plans.add(new UnitPlan(VerdaraUnitTypes.saber, 12 * 60f, with(VerdaraItems.polterite, 15, VerdaraItems.quartz, 10)));
                    consumePower(10/60f);
                    size = 3;
                }};
            }
        }
    }
}
