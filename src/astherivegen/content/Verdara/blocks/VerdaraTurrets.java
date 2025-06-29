package astherivegen.content.Verdara.blocks;

import arc.graphics.Color;
import mindustry.world.Block;
import mindustry.world.blocks.defense.*;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.content.*;
import mindustry.graphics.*;
import mindustry.gen.Sounds;
import astherivegen.world.blocks.defense.*;
import astherivegen.graphics.*;
import astherivegen.content.Verdara.*;
import mindustry.content.*;
import mindustry.entities.effect.MultiEffect.*;
import mindustry.entities.part.DrawPart.*;
import mindustry.entities.part.RegionPart.*;
import mindustry.entities.bullet.BasicBulletType;
import mindustry.entities.pattern.*;
import mindustry.content.Fx.*;
import mindustry.Vars;
import mindustry.content.Liquids;
import mindustry.entities.part.RegionPart;
import mindustry.entities.pattern.ShootSpread;
import mindustry.gen.Sounds;
import mindustry.type.Category;
import mindustry.world.blocks.defense.turrets.ItemTurret;
import mindustry.world.blocks.defense.turrets.PowerTurret;
import mindustry.world.consumers.ConsumeLiquid;
import mindustry.world.consumers.ConsumeLiquids;
import mindustry.world.draw.DrawTurret;
import mindustry.entities.effect.*;

import static mindustry.type.ItemStack.with;
import static mindustry.Vars.*;

public class VerdaraTurrets {
    public static Block
            fracture;
    public static void load() {
        {
            {
                fracture = new ItemTurret("fracture"){{
                    requirements(Category.turret, with(VerdaraItems.quartz, 50, VerdaraItems.magnetite, 40));
                    researchCost = with(VerdaraItems.quartz, 100, VerdaraItems.magnetite, 75);
  
                    health = 700;
                    outlineColor = GenesisPal.verdaraOutline;
                    reload = 80f;
                    inaccuracy = 2f;
                    size = 3;
                    recoil = 3f;
                    range = 18 * Vars.tilesize;
                    rotateSpeed = 3f;
                    squareSprite = false;
                    shootSound = Sounds.cannon;
                    minWarmup = 0.8f;
                    shootWarmupSpeed = 0.07f;
                    shootY = 5;

                    ammo(
                        VerdaraItems.quartz, new BasicBulletType(2.5f, 90) {{
                            lifetime = 60f;
                            
                            width = 10f;
                            height = 16f;
                            weaveMag = 2;
                            hitEffect = despawnEffect = Fx.hitBulletColor;
                            hitColor = backColor = trailColor = Color.valueOf("d39169");
                            frontColor = Color.valueOf("eac1a8");
                            trailWidth = 2.1f;
                            trailLength = 7;
                            shootEffect = new MultiEffect(Fx.shootBigColor, Fx.colorSparkBig);
                            smokeEffect = Fx.shootBigSmoke;
                        }}
                    );
                    drawer = new DrawTurret("verdara-"){{
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
