package astherivegen.type.unit;

import mindustry.content.*;
import mindustry.graphics.*;
import mindustry.type.*;
import mindustry.type.ammo.*;
import mindustry.world.meta.*;
import astherivegen.content.Verdara.VerdaraItems;
import astherivegen.graphics.*;
import astherivegen.content.*;
import mindustry.entities.abilities.*;

/** Config class for special uwu unit properties. */
public class BioUnitType extends UnitType{

    public BioUnitType(String name){
        super(name);
        outlineColor = GenesisPal.bioEonstoneOutline;
        envDisabled = Env.none;
        drawCell = false;
        useUnitCap = false; //i will regret this
        lightRadius = 0;

        abilities.add(new RegenAbility(){{
            percentAmount = 1f / (80f * 60f) * 100f;
        }});

        abilities.add(new LiquidExplodeAbility(){{
            liquid = GenesisLiquids.biomass;
        }});

        healFlash = false;
    }
}
