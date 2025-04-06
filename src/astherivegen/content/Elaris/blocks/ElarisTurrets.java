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
import astherivegen.graphics;
import astherivegen.content.*;
import mindustry.content.*;
import mindustry.world.blocks.defense.turrets.ItemTurret;
import mindustry.entities.effect.MultiEffect;
import mindustry.entities.part.DrawPart;
import mindustry.entities.part.RegionPart;
import mindustry.entities.pattern.*;
import mindustry.content.Fx;

import static mindustry.type.ItemStack.with;
import static mindustry.Vars.*;

public class ElarisTurrets {
    public static Block
            fracture;
    public static void load() {
        {
            {
                fracture = new ItemTurret("fracture"){{
                    requirements(Category.turret, with(ElarisItems.quartz, 50, ElarisItems.magnetite, 40));
                    researchCost = with(ElarisItems.quartz, 100, ElarisItems.magnetite, 75);
  
                    health = 700;
                    outlineColor = AGPal.elarisOutline;
                    reload = 80f;
                    inaccuracy = 2f;
                    size = 3;
                    recoil = 3f;
                    range = 18 * Vars.tilesize;
                    rotateSpeed = 3f;
                    squareSprite = false;
                    shootSound = Sounds.cannon;

                    ammo(
                        ElarisItems.quartz, new BasicBulletType(2.5f, 90) {{
                            width = 10f;
                            height = 16f;
                            lifetime = 60f;
                            weaveMag = 2;
                            hitEffect = despawnEffect = Fx.hitBulletColor;
                            hitColor = backColor = trailColor = Color.valueOf("d39169");
                            frontColor = Color.valueOf("eac1a8");
                        }}
                    );
                    drawer = new DrawTurret("elaris-"){{
                        parts.add(
                            new RegionPart("-side"){{
                                progress = PartProgress.warmup;
                                mirror = true;
                                under = false;
                                moveRot = -10;
                            }}
                        );
                    }};
                }};
            }
        }
    }
}
