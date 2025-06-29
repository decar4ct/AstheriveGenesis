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
    ward;
    public static void load(){
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
            drag = 0.04f;
            speed = 2.6f;
            rotateSpeed = 7f;
            accel = 0.09f;
            itemCapacity = 30;
            health = 300f;
            hitSize = 9f;
            fogRadius = 0f;            

            weapons.add(new RepairBeamWeapon(){{
                widthSinMag = 0.11f;
                reload = 20f;
                x = 0f;
                y = 6.5f;
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
