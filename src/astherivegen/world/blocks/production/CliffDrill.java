package astherivegen.world.blocks.production;

import arc.Core;
import arc.graphics.*;
import arc.graphics.g2d.*;
import arc.graphics.g2d.TextureRegion;
import arc.math.*;
import arc.util.*;
import arc.math.geom.*;
import mindustry.world.blocks.production.*;
import mindustry.gen.Building;
import mindustry.graphics.*;
import mindustry.ui.*;
import mindustry.world.*;
import mindustry.world.Tile;
import mindustry.core.*;
import mindustry.entities.units.*;

import static mindustry.Vars.*;

public class CliffDrill extends BeamDrill {
    public TextureRegion dir1;
    public TextureRegion dir2;
    public TextureRegion side;
    public ItemOverpass(String name){
         super(name);
    }
    @Override
    public void load(){
        super.load();
        dir1=Core.atlas.find(name+"-dir1");
        dir2=Core.atlas.find(name+"-dir2");
        side=Core.atlas.find(name+"-dir-side");
    }
    @Override
    public void drawPlanRegion(BuildPlan plan, Eachable<BuildPlan> list){
        Draw.rect(region, plan.drawx(), plan.drawy());
        Draw.rect(dir1, plan.drawx(), plan.drawy(), plan.rotation * 90);
        Draw.rect(side, plan.drawx(), plan.drawy(), plan.rotation * 90);
    }
    @Override
    public TextureRegion[] icons(){
        return new TextureRegion[]{region, dir1, side};
    }
    public class CliffDrillBuild extends BeamDrillBuild {
    }
}
