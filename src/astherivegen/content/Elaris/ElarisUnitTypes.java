package astherivegen.content.Elaris;

import arc.graphics.*;
import arc.math.Interp;
import arc.graphics.g2d.*;
import arc.util.*;
import mindustry.ai.types.BuilderAI;
import mindustry.content.Fx;
import mindustry.entities.bullet.*;
import mindustry.entities.effect.*;
import mindustry.entities.*;
import mindustry.graphics.Layer;
import mindustry.graphics.Pal;
import mindustry.graphics.*;
import mindustry.gen.*;
import mindustry.type.*;
import astherivegen.type.unit.*;

import static arc.graphics.g2d.Draw.*;
import static arc.graphics.g2d.Lines.*;

public class ElarisUnitTypes{
    public static UnitType
    sentry;
    public static void load(){
        sentry = new ElarisUnitType("sentry"){{
            coreUnitDock = true;
            controller = u -> new BuilderAI(true, 500f);
            isEnemy = false;
            envDisabled = 0;

            range = 60f;
            faceTarget = true;
            mineWalls = true;
            mineFloor = false;
            mineHardnessScaling = false;
            mineSpeed = 6f;
            mineTier = 3;
            buildSpeed = 1.2f;
            drag = 0.08f;
            speed = 5.6f;
            rotateSpeed = 7f;
            accel = 0.09f;
            itemCapacity = 30;
            health = 300f;
            armor = 1f;
            hitSize = 9f;
            engineSize = 0;
            fogRadius = 0f;

            legStraightness = 0.4f;
            stepShake = 0f;
            shadowElevation = 0.1f;
            groundLayer = Layer.legUnit - 1f;
            targetAir = false;

            legCount = 4;
            legLength = 8f;
            lockLegBase = true;
            legContinuousMove = true;
            legExtension = -2f;
            legBaseOffset = 3f;
            legMaxLength = 1.1f;
            legMinLength = 0.2f;
            legLengthScl = 0.96f;
            legForwardScl = 1.1f;
            legGroupSize = 2;
            rippleScale = 0.2f;

            legMoveSpace = 1f;
            allowLegStep = true;
            hovering = true;
            legPhysicsLayer = false;
          
            setEnginesMirror(
                new UnitEngine(21 / 4f, 19 / 4f, 2.2f, 45f),
                new UnitEngine(23 / 4f, -22 / 4f, 2.2f, 315f)
            );

            weapons.add(new Weapon("sentry-weapon"){{
                reload = 20f;
                x = 0f;
                y = 7f;
                rotate = false;
                shootY = 0f;
                shootCone = 15f;
                mirror = true;

                bullet = new ArtilleryBulletType(){{
                    shootEffect = new MultiEffect(Fx.shootSmallColor, new Effect(9, e -> {
                        color(Color.white, e.color, e.fin());
                        stroke(0.8f + e.fout());
                        Lines.square(e.x, e.y, e.fin() * 5f, e.rotation + 90f);

                        Drawf.light(e.x, e.y, 23f, e.color, e.fout() * 0.7f);
                    }));
                    collidesTiles = true;
                    backColor = hitColor = Pal.accent;
                    frontColor = Color.white;

                    knockback = 0.8f;
                    lifetime = 50f;
                    width = height = 9f;
                    splashDamageRadius = 19f;
                    splashDamage = 30f;

                    trailLength = 27;
                    trailWidth = 2.5f;
                    trailEffect = Fx.none;
                    trailColor = backColor;

                    trailInterp = Interp.slope;

                    shrinkX = 0.6f;
                    shrinkY = 0.2f;

                    hitEffect = despawnEffect = Fx.hitSquaresColor;
                }};
            }});
        }};
    }
}
