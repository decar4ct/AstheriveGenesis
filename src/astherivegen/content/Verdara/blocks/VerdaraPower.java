package astherivegen.content.Verdara.blocks;

import astherivegen.content.Verdara.VerdaraItems;
import mindustry.type.Category;
import mindustry.world.Block;
import mindustry.world.blocks.power.*;
import astherivegen.world.blocks.power.*;

import static mindustry.type.ItemStack.with;

public class VerdaraPower{
    public static Block
    relay, windTurbine;

    public static void load(){
        relay = new PowerNode("relay"){{
            requirements(Category.power, with(VerdaraItems.quartz, 5));
            health = 20;
            size = 1;
            squareSprite = false;
            laserRange = 12f;
            maxNodes = 8;
        }};
        windTurbine = new WindTurbine("wind-turbine"){{
            requirements(Category.power, with(VerdaraItems.quartz, 40));
            size = 2;
            squareSprite = false;
            powerProduction = 1;
            drawer = new DrawMulti(new DrawDefault(), new DrawRegion("-rotator", 3, true));
        }};
    }
}
