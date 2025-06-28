package astherivegen.planet;

import arc.graphics.*;
import arc.math.*;
import arc.math.geom.*;
import arc.util.*;
import arc.util.noise.*;
import mindustry.ai.*;
import mindustry.content.*;
import mindustry.game.*;
import mindustry.maps.generators.*;
import mindustry.world.*;
import mindustry.world.blocks.environment.*;
import mindustry.world.meta.*;

import static mindustry.Vars.*;

public class ProtusPlanedGenerator extends PlanetGenerator{
    public float heightScl = 0.9f, octaves = 8, persistence = 0.7f, heightPow = 3f, heightMult = 1.6f;

    //TODO inline/remove
    public static float arkThresh = 0.28f, arkScl = 0.83f;
    public static int arkSeed = 7, arkOct = 2;
    public static float liqThresh = 0.64f, liqScl = 87f, redThresh = 3.1f, noArkThresh = 0.3f;
    public static int crystalSeed = 8, crystalOct = 2;
    public static float crystalScl = 0.9f, crystalMag = 0.3f;
    public static float airThresh = 0.13f, airScl = 14;

    Block[] terrain = {Blocks.regolith, Blocks.regolith, Blocks.regolith, Blocks.regolith, Blocks.yellowStone, Blocks.rhyolite, Blocks.rhyolite, Blocks.carbonStone};

    @Override
    public float getHeight(Vec3 position){
        return Mathf.pow(rawHeight(position), heightPow) * heightMult;
    }

    @Override
    public void getColor(Vec3 position, Color out){
        Block block = getBlock(position);

        //more obvious color
        if(block == Blocks.crystallineStone) block = Blocks.crystalFloor;

        out.set(block.mapColor).a(1f - block.albedo);
    }

    @Override
    public float getSizeScl(){
        return 2000 * 1.07f * 6f / 5f;
    }

    float rawHeight(Vec3 position){
        return Simplex.noise3d(seed, octaves, persistence, 1f/heightScl, 10f + position.x, 10f + position.y, 10f + position.z);
    }

    float rawTemp(Vec3 position){
        return position.dst(0, 0, 1)*2.2f - Simplex.noise3d(seed, 8, 0.54f, 1.4f, 10f + position.x, 10f + position.y, 10f + position.z) * 2.9f;
    }

    Block getBlock(Vec3 position){
        float px = position.x, py = position.y, pz = position.z;

        float ice = rawTemp(position);
        float height = rawHeight(position);

        height *= 1.2f;
        height = Mathf.clamp(height);

        Block result = terrain[Mathf.clamp((int)(height * terrain.length), 0, terrain.length - 1)];

        if(ice < 0.3 + Math.abs(Ridged.noise3d(seed + crystalSeed, px + 4f, py + 8f, pz + 1f, crystalOct, crystalScl)) * crystalMag){
            return Blocks.crystallineStone;
        }

        if(ice < 0.6){
            if(result == Blocks.rhyolite || result == Blocks.yellowStone || result == Blocks.regolith){
                //TODO bio(?) luminescent stuff? ice?
                return Blocks.carbonStone; //TODO perhaps something else.
            }
        }

        //TODO tweak this to make it more natural
        //TODO edge distortion?
        if(ice < redThresh - noArkThresh && Ridged.noise3d(seed + arkSeed, px + 2f, py + 8f, pz + 1f, arkOct, arkScl) > arkThresh){
            //TODO arkyic in middle
            result = Blocks.beryllicStone;
        }

        if(ice > redThresh){
            result = Blocks.redStone;
        }else if(ice > redThresh - 0.4f){
            //TODO this may increase the amount of regolith, but it's too obvious a transition.
            result = Blocks.regolith;
        }

        return result;
    }
}
