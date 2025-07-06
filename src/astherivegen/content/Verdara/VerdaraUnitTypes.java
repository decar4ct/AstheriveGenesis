package astherivegen.content.Verdara;

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
import mindustry.type.weapons.*;

import static arc.graphics.g2d.Draw.*;
import static arc.graphics.g2d.Lines.*;

public class VerdaraUnitTypes{
    public static UnitType
    saber,
    
    ward;
    public static void load(){
        //region ground
        saber = new UnitType("saber"){{
            constructor = MechUnit::create;
            researchCostMultiplier = 0.5f;
            speed = 0.65f;
            hitSize = 8f;
            health = 140;
            weapons.add(new Weapon("large-weapon"){{
                reload = 18f;
                x = 4f;
                y = 2f;
                top = false;
                ejectEffect = Fx.casing1;
                bullet = new BasicBulletType(2.5f, 9){{
                    width = 7f;
                    height = 9f;
                    lifetime = 60f;
                }};
            }});
        }};

        //region core
        ward = new VerdaraUnitType("ward"){{
            constructor = UnitEntity::create;
            coreUnitDock = true;
            controller = u -> new BuilderAI(true, 500f);
            flying = true;
            isEnemy = false;
            envDisabled = 0;

            range = 120f;
            faceTarget = true;
            mineWalls = true;
            mineFloor = true;
            mineHardnessScaling = false;
            mineSpeed = 6f;
            mineTier = 3;
            buildSpeed = 1.2f;
            drag = 0.03f;
            speed = 3.2f;
            rotateSpeed = 7f;
            accel = 0.15f;
            itemCapacity = 30;
            health = 300f;
            hitSize = 9f;
            fogRadius = -1;
            engineOffset = 6f;

            weapons.add(new RepairBeamWeapon(){{
                widthSinMag = 0.11f;
                reload = 20f;
                x = 0f;
                y = 1f;
                rotate = false;
                shootY = 0f;
                beamWidth = 0.7f;
                repairSpeed = 3.1f;
                fractionRepairSpeed = 0.06f;
                aimDst = 0f;
                shootCone = 15f;
                mirror = false;

                targetUnits = false;
                targetBuildings = true;
                autoTarget = false;
                controllable = true;
                laserColor = Pal.accent;
                healColor = Pal.accent;

                bullet = new BulletType(){{
                    maxRange = 60f;
                }};
            }});
        }};
    }
}
