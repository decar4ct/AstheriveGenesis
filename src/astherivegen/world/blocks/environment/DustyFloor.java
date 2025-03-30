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

import static mindustry.Vars.*;

public class DustyFloor extends Floor {
    public TextureRegion dustRegion;
    public ConnectedWall(String name){
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
    public void renderUpdate(UpdateRenderState tile){
        if(tile.block()!=Blocks.air) {
            Draw.rect(dustRegion,tile.x,tile.y);
        }
    }
}
