package astherivegen.content.bioplasm;

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
import mindustry.content.*;

import static arc.graphics.g2d.Draw.*;
import static arc.graphics.g2d.Lines.*;

public class BioUnitTypes{
    public static UnitType
    canopy;
    public static void load(){
        canopy = new VerdaraUnitType("canopy"){{
            constructor = LegsUnit::create;
            speed = 0.8f;
            drag = 0.3f;
            hitSize = 11f;
            rotateSpeed = 3f;
            targetAir = false;
            health = 140;
            
            legCount = 3;
            legLength = 18f;
            legForwardScl = 0.6f;
            legMoveSpace = 1.4f;
            hovering = true;

            shadowElevation = 0.2f;
            groundLayer = Layer.legUnit - 1f;

            weapons.add(new Weapon("canopy-weapon"){{
                top = false;
                shootY = 3f;
                reload = 23f;
                ejectEffect = Fx.none;
                recoil = 1f;
                x = 6f;
                shootSound = Sounds.flame;

                bullet = new LiquidBulletType(Liquids.water){{
                    damage = 18;
                    speed = 2.8f;
                    drag = 0.004f;
                    shootEffect = Fx.shootSmall;
                    lifetime = 73f;
                    collidesAir = false;
                }};
            }});
        }};
    }
}
