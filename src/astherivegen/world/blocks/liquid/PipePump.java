package astherivegen.world.blocks.liquid;

import arc.Core;
import arc.math.geom.*;
import arc.graphics.g2d.*;
import arc.util.*;
import mindustry.gen.*;
import mindustry.type.*;
import mindustry.graphics.*;
import mindustry.world.blocks.liquid.*;
import mindustry.core.*;
import mindustry.world.*;
import mindustry.entities.*;
import mindustry.entities.units.*;

import static mindustry.Vars.*;

public class PipePump extends LiquidBlock{
    public TextureRegion topRegion;
    public final int timerFlow = timers++;

    public PipePump(String name){
        super(name);
        solid = true;
        rotate = true;
        noUpdateDisabled = true;
        floating = true;
        underBullets = false;
        canOverdrive = false;
        priority = TargetPriority.transport;
    }

    @Override
    public void load(){
        super.load();
        topRegion = new TextureRegion(Core.atlas.find(name+"-top"))
    }
    
    @Override
    public void drawPlanRegion(BuildPlan plan, Eachable<BuildPlan> list){
        Draw.rect(region, plan.drawx(), plan.drawy());
        Draw.rect(topRegion, plan.drawx(), plan.drawy(), plan.rotation * 90);
    }
    @Override
    public TextureRegion[] icons(){
        return new TextureRegion[]{region, topRegion, arrowRegion};
    }

    public class PipePumpBuild extends LiquidBuild{

        @Override
        public void updateTile(){
            Building front = front(), back = back();

            if(front != null && back != null && back.hasLiquids && back.liquids != null && front.team == team && back.team == team && back.canUnload()){
                if(liquids.currentAmount() > 0.0001f && timer(timerFlow, 1)){
                    moveLiquidForward(leaks, liquids.current());
                    noSleep();
                }else{
                    sleep();
                }
            }
        }

        boolean blends(Tile other){
            if(other != null && other.build != null){
                if(other.build.block.hasLiquids){
                    return true;
                }
            }
            return false;
        }

        @Override
        public void draw(){
            Draw.rect(bottomAtlasRegion[horBitmask[blending]][verBitmask[blending]], x, y);
            if(liquids.currentAmount() > 0.001f){
                drawTiledFrames(size, x, y, 0, liquids.current(), liquids.currentAmount() / liquidCapacity);
            }
            Draw.rect(atlasRegion[horBitmask[blending]][verBitmask[blending]], x, y);
        }

        @Override
        public boolean acceptLiquid(Building source, Liquid liquid){
            return (liquids.current() == liquid || liquids.currentAmount() < 0.2f) && source == back();
        }
    }
}
