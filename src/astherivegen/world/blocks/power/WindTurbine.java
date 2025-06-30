package astherivegen.world.blocks.power;

import arc.graphics.*;
import arc.graphics.g2d.*;
import arc.math.*;
import arc.struct.*;
import arc.util.*;
import mindustry.content.*;
import mindustry.entities.*;
import mindustry.entities.units.*;
import mindustry.gen.*;
import mindustry.graphics.*;
import mindustry.world.*;
import mindustry.world.consumers.*;
import mindustry.world.draw.*;
import mindustry.world.meta.*;
import mindustry.world.blocks.power.*;

import static mindustry.Vars.*;

public class WindTurbine extends PowerGenerator{
    public int range = 14;
    public DrawBlock drawer = new DrawDefault();
    public Color baseColor = Pal.accent;
    public Color obstructionColor = Pal.redLight;

    public WindTurbine(String name){
        super(name);
        solid = true;
        update = true;
        hasPower = true;
        hasItems = false;
        emitLight = false;
        //...wind turbine dont work in space
        envEnabled ^= Env.space;
    }

    //screw it im making my own indexer
    public int eachTile(int range){
        int rcount = 0;
        for(int xm = x-range;xm<range+x;xm++){
            for(int ym = y-range;ym<range+y;ym++){
                Tile tile = world.tile(xm,ym);
                if(tile.block()==Blocks.air) rcount++;
            }
        }
        return rcount;
    }
    @Override
    public void drawPlace(int x, int y, int rotation, boolean valid){
        super.drawPlace(x, y, rotation, valid);

        x *= tilesize;
        y *= tilesize;
        x += offset;
        y += offset;

        Drawf.dashSquare(baseColor, x, y, range * tilesize);
        indexer.eachBlock(player.team(), Tmp.r1.setCentered(x, y, range * tilesize), b -> true, t -> {
            Drawf.selected(t, Tmp.c1.set(obstructionColor).a(Mathf.absin(4f, 1f)));
        });
    }

    @Override
    public void drawPlanRegion(BuildPlan plan, Eachable<BuildPlan> list){
        drawer.drawPlan(this, plan, list);
    }

    @Override
    public boolean outputsItems(){
        return false;
    }

    @Override
    public TextureRegion[] icons(){
        return drawer.finalIcons(this);
    }

    @Override
    public void load(){
        super.load();
        drawer.load(this);
    }

    @Override
    public void setStats(){
        super.setStats();
    }

    public class WindTurbineBuild extends GeneratorBuild{
        public Seq<Building> obstructions = new Seq<>();
        public int lastChange = -2;
        public int obstructionCount;

        public void updateObstructions(){
            obstructions.clear();
            obstructionCount = 0;
            indexer.eachBlock(team, Tmp.r1.setCentered(x, y, range * tilesize), b -> true, obstructions::add);
            obstructionCount = eachTile(range);
        }

        @Override
        public void updateTile(){
            if(lastChange != world.tileChanges){
                lastChange = world.tileChanges;
                updateObstructions();
            }
            Log.info(obstructionCount);
        }

        @Override
        public void drawSelect(){
            super.drawSelect();

            Drawf.dashSquare(baseColor, x, y, range * tilesize);
            for(var obstruction : obstructions){
                Drawf.selected(obstruction, Tmp.c1.set(obstructionColor).a(Mathf.absin(4f, 1f)));
            }
        }

        @Override
        public void draw(){
            drawer.draw(this);
        }

        @Override
        public void drawLight(){
            super.drawLight();
            drawer.drawLight(this);
        }
    }
}
