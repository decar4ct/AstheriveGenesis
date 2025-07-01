package astherivegen.type.unit;

import mindustry.content.*;
import mindustry.graphics.*;
import mindustry.type.*;
import mindustry.type.ammo.*;
import mindustry.world.meta.*;
import astherivegen.content.Verdara.VerdaraItems;
import astherivegen.graphics.*;
import mindustry.entities.abilities.*;

/** BioUnitType but camouflage, yay. */
public class CamouflageUnitType extends BioUnitType{
    public CamouflageUnitType(String name){
        super(name);
    }
    @Override
    public void draw(Unit unit){
        Draw.mixcol(unit.floorOn().mapColor.write(Tmp.c1).mul(0.8f), 1f);
        super.draw();
        Draw.reset();
    }
}
