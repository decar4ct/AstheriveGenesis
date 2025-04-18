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
    ward;
    public static void load(){
        ward = new ElarisUnitType("ward"){{
            constructor = UnitEntity::create;
            coreUnitDock = true;
            controller = u -> new BuilderAI(true, 500f);
            flying = true;
            isEnemy = false;
            envDisabled = 0;

            range = 120f;
            faceTarget = true;
            mineWalls = true;
            mineFloor = false;
            mineHardnessScaling = false;
            mineSpeed = 6f;
            mineTier = 3;
            buildSpeed = 1.2f;
            drag = 0.08f;
            speed = 2.6f;
            rotateSpeed = 7f;
            accel = 0.09f;
            itemCapacity = 30;
            health = 300f;
            hitSize = 9f;
            fogRadius = 0f;

            weapons.add(new Weapon("astherive-gen-ward-weapon"){{
                reload = 20f;
                x = 14f / 8;
                y = 0f;
                rotate = false;
                shootY = 0f;
                shootCone = 15f;
                mirror = true;
                recoil = 3f;

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
                    speed = 6.5f;

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
