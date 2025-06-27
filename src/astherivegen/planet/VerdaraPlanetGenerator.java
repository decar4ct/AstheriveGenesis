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
    public float heightScl = 1.2f, octaves = 4, persistence = 0.7f, heightPow = 2.2f, heightMult = 1.1f;

    @Override
    public float getHeight(Vec3 position){
        return Mathf.pow(rawHeight(position), heightPow) * heightMult;
    }

    float rawHeight(Vec3 position){
        return Simplex.noise3d(seed, octaves, persistence, 1f/heightScl, 10f + position.x, 10f + position.y, 10f + position.z);
    }

    @Override
    public Color getColor(Vec3 position){
        Block block = rawHeight(position) < 0.35f ? VerdaraEnv.deepWatergel : rawHeight(position) < 0.4f ? VerdaraEnv.shallowWatergel : rawHeight(position) < 0.45f ? VerdaraEnv.alyogelFloor : rawHeight(position) < 0.55f ? VerdaraEnv.eonstoneFloor : rawHeight(position) < 0.6f ? VerdaraEnv.eonstoneErodedFloor : Blocks.ferricStone;
        return Tmp.c1.set(block.mapColor).a(1f - block.albedo);
    }
}
