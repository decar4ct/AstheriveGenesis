package astherivegen.content.Verdara.blocks;

import arc.graphics.Color;
import mindustry.world.Block;
import mindustry.world.blocks.environment.*;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.content.*;
import mindustry.graphics.*;
import mindustry.gen.Sounds.*;
import mindustry.content.Fx;
import astherivegen.content.Verdara.VerdaraItems;

import static mindustry.type.ItemStack.with;

public class VerdaraEnv {
    public static Block
            //h
            //this code is so messy lmao
            shallowWatergel, deepWatergel,
            //cromosand
            cromosandFloor,cromosandLightlyHardenedFloor,cromosandHardenedFloor,
            cromosandHardenedWall,
            cromosandHardenedBoulder,
            //eonstone
            eonstoneFloor, eonstoneLightlyErodedFloor, eonstoneErodedFloor,
            eonstoneWall, eonstoneErodedWall,
            //ranston
            ranston, platedRanston,
            //idk
            alyogelDeepFloor,alyogelFloor,
            eonstoneBoulder,eonstoneErodedBoulder,
            smallSporfloreFern, sporfloreFern,
            sporfloreTree, largeSporfloreTree,
            eonstoneHugeVent,
            //this code is so messy lmao
            eonstoneQuartzCluster, quartzOre;
    public static void load() {
        {
            {
                //h
                //liquid
                deepWatergel = new Floor("deep-watergel"){{
                    speedMultiplier = 0.2f;
                    variants = 3;
                    liquidDrop = Liquids.water;
                    isLiquid = true;
                    cacheLayer = CacheLayer.water;
                    albedo = 0.95f;
                    supportsOverlay = false;
                    drownTime = 120;
                }};
                shallowWatergel = new Floor("shallow-watergel"){{
                    speedMultiplier = 0.4f;
                    variants = 3;
                    liquidDrop = Liquids.water;
                    isLiquid = true;
                    cacheLayer = CacheLayer.water;
                    albedo = 0.95f;
                    supportsOverlay = true;
                }};
                //cromosand
                //liquid
                cromosandFloor = new Floor("cromosand-floor"){{
                    variants = 5;
                }};
                //floor
                cromosandLightlyHardenedFloor = new Floor("cromosand-lightly-hardened-floor"){{
                    variants = 5;
                }};
                cromosandHardenedFloor = new Floor("cromosand-hardened-floor"){{
                    variants = 5;
                }};
                //wall
                cromosandHardenedWall = new StaticTree("cromosand-hardened-wall"){{variants = 5;}};
                //prop
                cromosandHardenedBoulder = new Prop("cromosand-hardened-boulder"){{
                    variants = 2;
                    cromosandHardenedFloor.asFloor().decoration = this;
                    cromosandLightlyHardenedFloor.asFloor().decoration = this;
                }};
                //eonstone
                //floor
                eonstoneFloor = new Floor("eonstone-floor", 5);
                eonstoneLightlyErodedFloor = new Floor("eonstone-lightly-eroded-floor", 5);
                eonstoneErodedFloor = new Floor("eonstone-eroded-floor", 5);
                //wall
                eonstoneWall = new StaticTree("eonstone-wall"){{variants = 5;}};
                eonstoneErodedWall = new StaticWall("eonstone-eroded-wall"){{variants = 4;}};
                //liquid
                alyogelDeepFloor = new Floor("alyogel-deep-floor"){{
                    speedMultiplier = 0.2f;
                    variants = 3;
                    liquidDrop = Liquids.water;
                    isLiquid = true;
                    cacheLayer = CacheLayer.water;
                    albedo = 0.95f;
                    supportsOverlay = false;
                }};
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
                    eonstoneFloor.asFloor().decoration = this;
                }};
                eonstoneErodedBoulder = new Prop("eonstone-eroded-boulder"){{
                    variants = 2;
                    eonstoneErodedFloor.asFloor().decoration = this;
                }};
                //ranston wow very creative name omg
                //floor
                ranston = new Floor("ranston",4);
                platedRanston = new Floor("plated-ranston",4);
                //anything else
                sporfloreFern = new SeaBush("sporflore-fern"){{
                    lobesMin = 4;
                    lobesMax = 6;
                    magMin = 4;
                    magMax = 6;
                }};
                smallSporfloreFern = new SeaBush("small-sporflore-fern"){{
                    lobesMin = 4;
                    lobesMax = 5;
                    magMin = 5;
                    magMax = 7;
                }};
                sporfloreTree = new TallBlock("sporflore-tree"){{
                    variants = 2;
                }};
                largeSporfloreTree = new TallBlock("large-sporflore-tree"){{
                    variants = 2;
                }};
                eonstoneHugeVent = new SteamVent("eonstone-huge-vent"){{
                    variants = 0;
                }};
                //ore thing
                eonstoneQuartzCluster = new SteamVent("eonstone-quartz-cluster"){{
                    parent = blendGroup = eonstoneErodedFloor;
                    effect = Fx.none;
                    itemDrop = VerdaraItems.quartz;
                }};
                oreQuartz = new OreBlock("ore-quartz", VerdaraItems.quartz);
            }
        }
    }
}
