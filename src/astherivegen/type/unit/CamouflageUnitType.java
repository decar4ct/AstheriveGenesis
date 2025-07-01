package astherivegen.type.unit;

import arc.graphics.g2d.*;
import arc.util.*;
import arc.graphics.*;
import mindustry.entities.*;
import mindustry.content.*;
import mindustry.graphics.*;
import mindustry.type.*;
import mindustry.type.ammo.*;
import mindustry.world.meta.*;
import astherivegen.content.Verdara.VerdaraItems;
import astherivegen.graphics.*;
import mindustry.entities.abilities.*;
import mindustry.core.*;
//idk what to import bro 🙏
import arc.math.*;
import mindustry.gen.*;
import mindustry.type.*;
import mindustry.world.*;
import mindustry.world.blocks.*;
import mindustry.world.meta.*;

import static mindustry.Vars.*;

/** BioUnitType but camouflage, yay. */
public class CamouflageUnitType extends BioUnitType{
    public CamouflageUnitType(String name){
        super(name);
    }
    @Override
    public void update(Unit unit){
        targetable = !(unit.health>=unit.maxHealth);
    }
    @Override
    public void applyColor(Unit unit){
        Draw.color();
        if(healFlash){
            Tmp.c1.set(Color.white).lerp(healColor, Mathf.clamp(unit.healTime - unit.hitTime));
        }
        Draw.mixcol(Tmp.c1, Math.max(unit.hitTime, !healFlash ? 0f : Mathf.clamp(unit.healTime)));

        if(unit.drownTime > 0 && unit.lastDrownFloor != null){
            Draw.mixcol(Tmp.c1.set(unit.lastDrownFloor.mapColor).mul(0.83f), unit.drownTime * 0.9f);
        }
        if(unit.health>=unit.maxHealth){
            Draw.mixcol(Tmp.c1.set(unit.tileOn().floor().mapColor).mul(0.8f),0.65f);
        }
        //this is horribly scuffed.
        //i know, anuke.
        if(renderer != null && renderer.overlays != null){
            renderer.overlays.checkApplySelection(unit);
        }
    }
}
