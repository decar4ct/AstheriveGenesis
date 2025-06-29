package astherivegen.content.Verdara.blocks;

import astherivegen.content.Verdara.VerdaraItems;
import mindustry.type.Category;
import mindustry.world.Block;
import mindustry.world.blocks.power.*;

import static mindustry.type.ItemStack.with;

public class VerdaraPower{
    public static Block
    relay;

    public static void load(){
        relay = new PowerNode("relay"){{
            requirements(Category.power, with(VerdaraItems.quartz, 5));
            health = 20;
            size = 1;
            squareSprite = false;
        }};
    }
}
