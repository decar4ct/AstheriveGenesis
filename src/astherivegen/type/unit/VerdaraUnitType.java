package astherivegen.type.unit;

import mindustry.content.*;
import mindustry.graphics.*;
import mindustry.type.*;
import mindustry.type.ammo.*;
import mindustry.world.meta.*;
import astherivegen.content.Verdara.VerdaraItems;
import astherivegen.graphics.*;

/** Config class for special uwu unit properties. */
public class VerdaraUnitType extends UnitType{

    public VerdaraUnitType(String name){
        super(name);
        outlineColor = AGPal.verdaraOutline;
        ammoType = new ItemAmmoType(VerdaraItems.quartz);
        researchCostMultiplier = 8f;
    }
}
