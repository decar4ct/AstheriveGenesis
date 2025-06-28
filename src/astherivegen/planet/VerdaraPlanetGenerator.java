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
    public float heightScl = 1.8f, octaves = 4, persistence = 0.9f, heightPow = 2.2f, heightMult = 1.3f;

    @Override
    public float getHeight(Vec3 position){
        return Mathf.pow(rawHeight(position), heightPow) * heightMult;
    }

    float rawHeight(Vec3 position){
        float poles = Math.abs(position.y);
        float height = Simplex.noise3d(seed, octaves, persistence, 1f/heightScl, position.x, position.y, position.z)*1.2f;
        if (poles<0.1f||height<0.4f) {return 0+height*0.2f;} else return height;
    }

    @Override
    public Color getColor(Vec3 position){
        Block block = getHeight(position) < 0.4f ? VerdaraEnv.deepWatergel : getHeight(position) < 0.5f ? VerdaraEnv.shallowWatergel : getHeight(position) < 0.55f ? VerdaraEnv.alyogelFloor : getHeight(position) < 0.65f ? VerdaraEnv.eonstoneFloor : getHeight(position) < 0.8f ? VerdaraEnv.eonstoneErodedFloor : Blocks.ferricStone;
        return Tmp.c1.set(block.mapColor).a(1f - block.albedo);
    }
}
