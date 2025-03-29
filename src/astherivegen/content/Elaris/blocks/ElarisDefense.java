package astherivegen.content.Elaris.blocks;

import arc.graphics.Color;
import mindustry.world.Block;
import mindustry.world.blocks.defense.*;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.content.*;
import mindustry.graphics.*;
import mindustry.gen.Sounds;
import astherivegen.world.blocks.defense.*;

import static mindustry.type.ItemStack.with;

public class ElarisDefense {
    public static Block
            quartz-wall;
    public static void load() {
        {
            {
                quartzWall = new ConnectedWall("quartz-wall")
            }
        }
    }
}
