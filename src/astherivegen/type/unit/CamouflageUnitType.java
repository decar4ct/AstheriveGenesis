package astherivegen.type.unit;

import arc.graphics.g2d.*;
import arc.util.*;
import mindustry.entities.*;
import mindustry.content.*;
import mindustry.graphics.*;
import mindustry.type.*;
import mindustry.type.ammo.*;
import mindustry.world.meta.*;
import astherivegen.content.Verdara.VerdaraItems;
import astherivegen.graphics.*;
import mindustry.entities.abilities.*;
//idk what to import bro 🙏
import arc.math.*;
import mindustry.gen.*;
import mindustry.type.*;
import mindustry.world.*;
import mindustry.world.blocks.*;
import mindustry.world.meta.*;

/** BioUnitType but camouflage, yay. */
public class CamouflageUnitType extends BioUnitType{
    public CamouflageUnitType(String name){
        super(name);
    }
    @Override
    public void draw(Unit unit){
        Draw.tint(Pal.remove, 1f);
        Log.info(unit.floorOn().mapColor);
        super.draw(unit);
        Draw.reset();
    }
}
