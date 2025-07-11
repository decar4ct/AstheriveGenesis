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
import astherivegen.content.Verdara.*;

import static mindustry.type.ItemStack.with;

public class Bioplasm {
    public static Block
            root, branchNode, sighter, heart, harvester, spawningBulb,
            pulseSource;
    public static void load() {
        {
            {
                root = new Root("root"){{
                    requirements(Category.distribution, with(VerdaraItems.quartz, 1));
                }};
                
                branchNode = new BioBridge("branch-node"){{
                    requirements(Category.distribution, with(VerdaraItems.quartz, 1));
                }};

                sighter = new BioEye("sighter"){{
                    requirements(Category.distribution, with(VerdaraItems.quartz, 1));
                }};
                
                harvester = new BioDrill("harvester"){{
                    requirements(Category.distribution, with(VerdaraItems.quartz, 1));
                    size = 2;
                }};
                heart = new BioHeart("heart"){{
                    requirements(Category.distribution, with(VerdaraItems.quartz, 1));
                    size = 3;
                }};
                pulseSource = new PulseSource("pulse-source"){{
                    requirements(Category.distribution, with(VerdaraItems.quartz, 1));
                }};
                spawningBulb = new BioSpawner("spawning-bulb"){{
                    requirements(Category.distribution, with(VerdaraItems.quartz, 1));
                    size = 3;
                    unitType = BioUnitTypes.turf;
                }};
            }
        }
    }
}
