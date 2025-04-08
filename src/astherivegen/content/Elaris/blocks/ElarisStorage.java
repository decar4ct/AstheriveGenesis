package astherivegen.content.Elaris.blocks;

import arc.graphics.Color;
import mindustry.world.Block;
import mindustry.world.blocks.storage.*;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.content.*;
import mindustry.graphics.*;
import mindustry.gen.Sounds;
import mindustry.content.*;
import astherivegen.content.Elaris.ElarisUnitTypes;

import static mindustry.type.ItemStack.with;

public class ElarisStorage {
    public static Block
            coreProtocol;
    public static void load() {
        {
            {
                coreProtocol = new CoreBlock("core-protocol"){{
                    requirements(Category.effect, with(Items.copper, 6));
                    size = 4;
                    isFirstTier = true;
                    squareSprite = false;
                    unitType = ElarisUnitTypes.ward;
                }};
            }
        }
    }
}
