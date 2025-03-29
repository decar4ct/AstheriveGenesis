package astherivegen.world.blocks.defense;

import arc.Core;
import arc.graphics.*;
import arc.graphics.g2d.*;
import arc.graphics.g2d.TextureRegion;
import arc.math.*;
import arc.util.*;
import arc.math.geom.*;
import mindustry.world.blocks.defense.*;
import mindustry.gen.Building;
import mindustry.graphics.*;
import mindustry.ui.*;
import mindustry.world.*;
import mindustry.world.Tile;

import static mindustry.Vars.*;

public class ConnectedWall extends Wall {
    //AWFUL
    public TextureRegion none
    public TextureRegion r;
    public TextureRegion d;
    public TextureRegion l;
    public TextureRegion u;
    public TextureRegion ru;
    public TextureRegion dr;
    public TextureRegion ld;
    public TextureRegion ul;
    public TextureRegion rl;
    public TextureRegion du;
    public TextureRegion rud;
    public TextureRegion drl;
    public TextureRegion lud;
    public TextureRegion url;
    public TextureRegion rdlu;
    public ConnectedWall(String name){
         super(name);
    }
    @Override
    public void load(){
        super.load();
        none = Core.atlas.find(name+"1");
        r = Core.atlas.find(name+"2");
        d = Core.atlas.find(name+"3");
        l = Core.atlas.find(name+"4");
        u = Core.atlas.find(name+"5");
        ru = Core.atlas.find(name+"6");
        dr = Core.atlas.find(name+"7");
        ld = Core.atlas.find(name+"8");
        ul = Core.atlas.find(name+"9");
        rl = Core.atlas.find(name+"10");
        du = Core.atlas.find(name+"11");
        rud = Core.atlas.find(name+"12");
        drl = Core.atlas.find(name+"13");
        lud = Core.atlas.find(name+"14");
        url = Core.atlas.find(name+"15");
        rdlu = Core.atlas.find(name+"16");
    }
    //permanently borrowed from canvasblock.java :troll:
    public class ConnectedWallBuild extends WallBuild {
        public int blending;
        @Override
        public void onProximityUpdate(){
            super.onProximityUpdate();
            blending = 0;
            for(int i = 0; i < 4; i++){
                if(blends(world.tile(tile.x + Geometry.d4[i].x, tile.y + Geometry.d4[i].y))){
                    blending |= (1 << i);
                }
            }
        }
        boolean blends(Tile other){
            return other != null && other.build != null && other.build.block == block && other.build.tileX() == other.x && other.build.tileY() == other.y;
        }
        @Override
        public void draw(){
            super.draw();
            Draw.rect(region, x, y, 0);
            for(int i = 0; i < 4; i ++){
                if((blending & (1 << i)) == 0){
                    Draw.rect(i >= 2 ? sideRegion2 : sideRegion1, x, y, i * 90);

                    if((blending & (1 << ((i + 1) % 4))) != 0){
                        Draw.rect(i >= 2 ? cornerRegion2 : cornerRegion1, x, y, i * 90);
                    }

                    if((blending & (1 << (Mathf.mod(i - 1, 4)))) != 0){
                        Draw.yscl = -1f;
                        Draw.rect(i >= 2 ? cornerRegion2 : cornerRegion1, x, y, i * 90);
                        Draw.yscl = 1f;
                    }
                }
            }
        }
    }
}
