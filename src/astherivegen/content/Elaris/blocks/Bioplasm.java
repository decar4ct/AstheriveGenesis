package astherivegen.content.bioplasm;

import arc.graphics.Color;
import mindustry.world.Block;
import mindustry.world.blocks.storage.*;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.content.*;
import mindustry.graphics.*;
import mindustry.gen.Sounds;
import mindustry.content.*;
import astherivegen.world.blocks.bioplasm.*;

import static mindustry.type.ItemStack.with;

public class Bioplasm {
    public static Block
            root,
            pulseSource;
    public static void load() {
        {
            {
                root = new Root("root"){{
                    requirements(Category.distribution, with(Items.copper, 1));
                }};
                pulseSource = new pulseSource("pulse-source"){{
                    requirements(Category.distribution, with(Items.copper, 1));
                }};
            }
        }
    }
}
