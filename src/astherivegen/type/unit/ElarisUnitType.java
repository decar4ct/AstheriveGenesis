package astherivegen.type.unit;

import mindustry.content.*;
import mindustry.graphics.*;
import mindustry.type.*;
import mindustry.type.ammo.*;
import mindustry.world.meta.*;
import astherivegen.content.Elaris.ElarisItems;
import astherivegen.graphics.*;

/** Config class for special Elaris unit properties. */
public class ElarisUnitType extends UnitType{

    public ElarisUnitType(String name){
        super(name);
        outlineColor = AGPal.elarisOutline;
        ammoType = new ItemAmmoType(ElarisItems.quartz);
        researchCostMultiplier = 8f;
    }
}
