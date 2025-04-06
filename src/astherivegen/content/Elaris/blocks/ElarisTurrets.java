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
import mindustry.content.*;

import static mindustry.type.ItemStack.with;

fracture = new ItemTurret("fracture"){{
            requirements(Category.turret, with(ElarisItems.quartz, 50, ElarisItems.magnetite, 40));
            researchCost = with(ElarisItems.quartz, 100, ElarisItems.magnetite, 75);
  
            health = 700;
            outlineColor = AGPal.outline;
            reload = 80f;
            inaccuracy = 2f;
            size = 3;
            recoil = 3f;
            range = 18 * Vars.tilesize;
            rotateSpeed = 3f;
            squareSprite = false;
            shootSound = Sounds.cannon;
  
            drawer = new DrawTurret("elaris-"){{
                parts.add(
                        new RegionPart("-side"){{
                            progress = PartProgress.warmup;
                            mirror = true;
                            under = false;
                            moveRot = -10;
                        }},
            }};
        }};
