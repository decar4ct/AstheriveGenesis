package astherivegen.content.Elaris.blocks;

import arc.graphics.Color;
import mindustry.world.Block;
import mindustry.world.blocks.environment.*;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.content.*;
import mindustry.graphics.*;
import mindustry.gen.Sounds;
import astherivegen.world.blocks.environment.*;

import static mindustry.type.ItemStack.with;

public class ElarisEnv {
    public static Block
            //eonstone
            eonstoneFloor, eonstoneLightlyErodedFloor, eonstoneErodedFloor,
            eonstoneWall, eonstoneErodedWall,
            alyogelFloor,
            eonstoneBoulder,eonstoneErodedBoulder,
            sporfloreTree,
            //cromosand
            cromosandFloor;
    public static void load() {
        {
            {
                //eonstone
                //floor
                eonstoneFloor = new Floor("eonstone-floor", 5);
                eonstoneLightlyErodedFloor = new Floor("eonstone-lightly-eroded-floor", 5);
                eonstoneErodedFloor = new Floor("eonstone-eroded-floor", 5);
                //wall
                eonstoneWall = new StaticTree("eonstone-wall"){{variants = 5;}};
                eonstoneErodedWall = new StaticWall("eonstone-eroded-wall"){{variants = 4;}};
                //liquid
                alyogelFloor = new Floor("alyogel-floor"){{
                    speedMultiplier = 0.4f;
                    variants = 4;
                    liquidDrop = Liquids.water;
                    isLiquid = true;
                    cacheLayer = CacheLayer.water;
                    albedo = 0.95f;
                    supportsOverlay = true;
                }};
                //prop
                eonstoneBoulder = new Prop("eonstone-boulder"){{
                    variants = 2;
                    eonstoneLightlyErodedFloor.asFloor().decoration = this;
                }};
                eonstoneErodedBoulder = new Prop("eonstone-eroded-boulder"){{
                    variants = 2;
                    eonstoneErodedFloor.asFloor().decoration = this;
                }};
                sporfloreTree = new TallBlock("sporflore-tree"){{
                    variants = 2;
                    eonstoneFloor.asFloor().decoration = this;
                }};
                //cromosand
                //floor
                cromosandFloor = new DustyFloor("cromosand-floor"){{
                    variants = 5;
                }};
            }
        }
    }
}
