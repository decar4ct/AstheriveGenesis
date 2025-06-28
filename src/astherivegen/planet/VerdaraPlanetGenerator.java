package astherivegen.planet;

import arc.graphics.*;
import arc.math.*;
import arc.math.geom.*;
import arc.util.Tmp;
import arc.util.noise.*;
import astherivegen.content.Verdara.blocks.VerdaraEnv;
import mindustry.content.Blocks;
import mindustry.maps.generators.PlanetGenerator;
import mindustry.world.Block;

public class VerdaraPlanetGenerator extends PlanetGenerator {
    public float heightScl = 2f, octaves = 4, persistence = 0.9f, heightPow = 2.2f, heightMult = 1.3f;

    @Override
    public float getHeight(Vec3 position){
        return Mathf.pow(rawHeight(position), heightPow) * heightMult;
    }

    float rawHeight(Vec3 position){
        float poles = Math.abs(position.y);
        float height = Simplex.noise3d(seed, octaves, persistence, 1f/heightScl, position.x, position.y, position.z);
        if (poles<0.1f||height<0.6f) {return 0+height*0.2f;} else return height;
    }

    public void getColor(Vec3 position, Color out){
        Block block = getBlock(position);
        out.set(block.mapColor).a(1f - block.albedo);
    }
    Block getBlock(Vec3 position){
        Block result = rawHeight(position) < 0.5f ? VerdaraEnv.deepWatergel : rawHeight(position) < 0.55f ? VerdaraEnv.shallowWatergel : rawHeight(position) < 0.6f ? VerdaraEnv.alyogelFloor : rawHeight(position) < 0.7f ? VerdaraEnv.eonstoneFloor : rawHeight(position) < 0.8f ? VerdaraEnv.eonstoneErodedFloor : Blocks.ferricStone;
        return result;
    }
}
