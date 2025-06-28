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

public class ProtusPlanetGenerator extends PlanetGenerator {
    public float heightScl = 1f, octaves = 4, persistence = 1.5f, heightPow = 2.2f, heightMult = 1.3f;

    Color out = new Color();

    @Override
    public float getHeight(Vec3 position){
        return Mathf.pow(rawHeight(position), heightPow) * heightMult;
    }

    float rawHeight(Vec3 position){
        float poles = Math.abs(position.y);
        float height = Simplex.noise3d(seed, octaves, persistence, 1f/heightScl, position.x, position.y, position.z);
        return height+poles*0.2f;
    }
    @Override
    public Color getColor(Vec3 position){
        float height = rawHeight(position);
        Block block = Blocks.water;
        return (block.mapColor).write(out).a(1f - block.albedo);
    }
}
