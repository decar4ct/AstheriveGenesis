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
    public TextureRegion dir1, di2, side, bore, boreEnd, rotator;
    public CliffDrill(String name){
         super(name);
    }
    @Override
    public void load(){
        super.load();
        dir1=Core.atlas.find(name+"-dir1");
        dir2=Core.atlas.find(name+"-dir2");
        side=Core.atlas.find(name+"-dir-side");
        bore=Core.atlas.find(name+"-bore");
        boreEnd=Core.atlas.find(name+"-bore-end");
        rotator=Core.atlas.find(name+"-bore-rotator");
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
        @Override
        public void draw(){
            Draw.rect(region, x, y);
            if (rotation<2){
                Draw.rect(dir1, x, y, rotation*90);
            } else {
                Draw.rect(dir2, x, y, rotation*90);
            }
            Draw.rect(side, x, y, rotation%2==0?0:270);

            if(isPayload()) return;

            var dir = Geometry.d4(rotation);
            int ddx = Geometry.d4x(rotation + 1), ddy = Geometry.d4y(rotation + 1);

            for(int i = 0; i < size; i++){
                Tile face = facing[i];
                if(face != null){
                    Point2 p = lasers[i];
                    float lx = face.worldx() - (dir.x/2f)*tilesize, ly = face.worldy() - (dir.y/2f)*tilesize;

                    float width = (laserWidth + Mathf.absin(Time.time + i*5 + (id % 9)*9, glowScl, pulseIntensity)) * warmup;

                    Draw.z(Layer.power - 1);
                    Draw.mixcol(glowColor, Mathf.absin(Time.time + i*5 + id*9, glowScl, glowIntensity));
                    if(Math.abs(p.x - face.x) + Math.abs(p.y - face.y) == 0){
                        Draw.scl(width);
                        Draw.rect(rotator, lx, ly);
                        Draw.scl();
                    }else{
                        float lsx = (p.x - dir.x/2f) * tilesize, lsy = (p.y - dir.y/2f) * tilesize;
                        Drawf.laser(bore, boreEnd, lsx, lsy, lx, ly, width);
                    }
                }
            }
        }
    }
}
