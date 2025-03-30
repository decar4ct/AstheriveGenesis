package astherivegen.world.blocks.environment;

import arc.Core;
import arc.graphics.*;
import arc.graphics.g2d.*;
import arc.graphics.g2d.TextureRegion;
import arc.math.*;
import arc.util.*;
import arc.math.geom.*;
import mindustry.world.blocks.environment.*;
import mindustry.gen.Building;
import mindustry.graphics.*;
import mindustry.ui.*;
import mindustry.world.*;
import mindustry.content.*;

import static mindustry.Vars.*;

public class DustyFloor extends Floor {
    public TextureRegion dustRegion;
    public boolean blockAbove;
    public DustyFloor(String name){
         super(name);
    }
    @Override
    public void load(){
        super.load();
         dustRegion=Core.atlas.find(name+"-dust");
    }
    @Override
    public boolean updateRender(Tile tile){
        return true;
    }
    @Override
    public void renderUpdate(UpdateRenderState state){
        blockAbove=state.tile.block()!=Blocks.air;
    }
    @Override
    public void drawBase(Tile tile){
        Draw.rect(
            variants == 0 ? region :
            variantRegions[Mathf.randomSeed(tile.pos(), 0, Math.max(0, variantRegions.length - 1))],
        tile.drawx(), tile.drawy());
        if (blockAbove) Draw.rect(dustRegion,tile.drawx(),tile.drawy());
    }
}
