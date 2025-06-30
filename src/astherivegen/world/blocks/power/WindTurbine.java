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
import mindustry.content.Blocks;

import static mindustry.Vars.*;

public class WindTurbine extends PowerGenerator{
    public int range = 10;
    public DrawBlock drawer = new DrawDefault();
    public Color baseColor = Pal.accent;
    public Color obstructionColor = Pal.remove;

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

    @Override
    public void drawPlace(int x, int y, int rotation, boolean valid){
        super.drawPlace(x, y, rotation, valid);
        int ox = x;
        int oy = y;

        x *= tilesize;
        y *= tilesize;
        x += offset;
        y += offset;

        Drawf.dashSquare(baseColor, x, y, range * tilesize);
        int frange = (int) Math.floor(range/2);
        for(int xm = -frange+1;xm<=frange;xm++){
            for(int ym = -frange+1;ym<=frange;ym++){
                Tile other = world.tile(ox+xm,oy+ym);
                if(other.solid()&&other.build!=world.tile(ox,oy).build) {
                    Drawf.selected(other.x, other.y, Blocks.router, obstructionColor);
                }
            }
        }
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
        public int lastChange = -2;
        public int obstructionCount = 0;

        //screw it im making my own indexer
        public int eachTile(int range){
            int rcount = 0;
            int frange = (int) Math.floor(range/2);
            for(int xm = -frange+1;xm<=frange;xm++){
                for(int ym = -frange+1;ym<=frange;ym++){
                    Tile other = tile.nearby(xm,ym);
                    if(other.solid()) {
                        rcount++;
                    }
                }
            }
            //subtract with the block itself
            return rcount-size*size;
        }

        @Override
        public void updateTile(){
            if(lastChange != world.tileChanges){
                lastChange = world.tileChanges;
                obstructionCount = eachTile(range);
            }
            Log.info(obstructionCount);
        }

        @Override
        public void drawSelect(){
            super.drawSelect();

            Drawf.dashSquare(baseColor, x, y, range * tilesize);
            int frange = (int) Math.floor(range/2);
            for(int xm = -frange+1;xm<=frange;xm++){
                for(int ym = -frange+1;ym<=frange;ym++){
                    Tile other = tile.nearby(xm,ym);
                    if(other.solid()&&other.build!=world.tile(x,y).build) {
                        Drawf.selected(other.x, other.y, Blocks.router, obstructionColor);
                    }
                }
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
