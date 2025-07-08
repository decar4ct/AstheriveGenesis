package astherivegen.content.Verdara.blocks;

import arc.graphics.Color;
import mindustry.world.Block;
import mindustry.world.blocks.production.*;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.content.*;
import mindustry.graphics.*;
import mindustry.gen.Sounds;
import mindustry.content.*;
import mindustry.world.draw.*;
import astherivegen.world.blocks.production.*;
import astherivegen.content.Verdara.VerdaraItems;

import static mindustry.type.ItemStack.with;

public class VerdaraProduction {
    public static Block
    cliffBore, clusterDrill,

    polteritePress;
    public static void load() {
        cliffBore = new CliffDrill("cliff-bore"){{
            requirements(Category.production, with(VerdaraItems.quartz, 10, VerdaraItems.magnetite, 20));
            consumePower(1/3f);
            consumeLiquid(Liquids.hydrogen, 0.05f).boost();

            drillTime = 400;
            tier = 3;
            size = 2;
            researchCost = with(VerdaraItems.quartz, 50, VerdaraItems.magnetite, 50);
        }}
        clusterDrill = new ClusterDrill("cluster-drill"){{
            requirements(Category.production, with(VerdaraItems.quartz, 20, VerdaraItems.magnetite, 15));
            consumePower(0.5f);
            consumeLiquid(Liquids.hydrogen, 0.05f).boost();

            squareSprite = false;
            drillTime = 550;
            tier = 3;
            size = 3;
            fogRadius = 3;
            researchCost = with(VerdaraItems.quartz, 10);
        }};
        polteritePress = new GenericCrafter("polterite-press"){{
            requirements(Category.crafting, with(VerdaraItems.quartz, 20, VerdaraItems.magnetite, 15));
            
            drawer = new DrawMulti(new DrawRegion("-bottom"), new DrawPistons(){{
                sinMag = 2.75f;
                sinScl = 5f;
                sides = 4;
                sideOffset = (float) Math.PI / 2f;
                angleOffset = 45f;
            }}, new DrawDefault());

            size = 2;

            ambientSound = Sounds.smelter;
            ambientSoundVolume = 0.06f;

            researchCostMultiplier = 0.1f;
            consumePower(1/6f);
            consumeItems(with(VerdaraItems.magnetite, 1, VerdaraItems.carbon, 2));
            craftTime = 150f;
            outputItem = new ItemStack(VerdaraItems.polterite, 2);
        }};
    }
}
