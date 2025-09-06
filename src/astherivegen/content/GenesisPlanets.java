package astherivegen.content;

import arc.func.Cons;
import arc.graphics.Color;
import arc.math.Rand;
import arc.math.geom.Mat3D;
import arc.util.Tmp;
import arc.struct.Seq;
import astherivegen.content.Verdara.blocks.VerdaraEnv;
import astherivegen.content.Verdara.blocks.VerdaraStorage;
import mindustry.content.Blocks;
import mindustry.graphics.g3d.*;
import mindustry.maps.planet.AsteroidGenerator;
import mindustry.maps.planet.ErekirPlanetGenerator;
import mindustry.type.*;
import mindustry.world.Block;
import mindustry.world.meta.Env;
import mindustry.maps.planet.*;

public class GenesisPlanets{
    public static Planet
            //star
            orrin, thessar,

    // planets
    verdara,

    // muns
    protus;

    public static void load(){
        // regions stars
        orrin = new Planet("orrin", null, 6f, 0){{
            accessible = true;
            hasAtmosphere = true;
            solarSystem = this;

            meshLoader = () -> new SunMesh(
                    this, 5, 8, 0.4f, 0.7f, 1.4f, 1.6f, 1.2f,

                    Color.valueOf("8EAFC3"),
                    Color.valueOf("A1C6CF"),
                    Color.valueOf("B8D9DD"),
                    Color.valueOf("D4EDEF"),
                    Color.valueOf("FFFFFF")
            );
            cloudMeshLoader = () -> new MultiMesh(
                    new HexSkyMesh(this, 6, 2.7f, 0.1f, 5, Color.valueOf("EEF3FF").a(0.95f), 3, 0.42f, 1f, 0.43f)             
            );
        }};
        thessar = new Planet("thessar", orrin, 2f, 0){{
            accessible = true;
            hasAtmosphere = true;
            solarSystem = orrin;
            orbitRadius = 55f;

            meshLoader = () -> new SunMesh(
                    this, 5, 8, 0.4f, 0.7f, 1.4f, 1.6f, 1.2f,

                    Color.valueOf("A2615D"),
                    Color.valueOf("BD7771"),
                    Color.valueOf("D09287"),
                    Color.valueOf("EFC4B1"),
                    Color.valueOf("FFDFCB")
            );
        }};

        // region planets
        verdara = new Planet("verdara", thessar, 1f, 3){{
            accessible = true;
            hasAtmosphere = true;
            landCloudColor = Color.valueOf("DBF3FF");
            atmosphereColor = Color.valueOf("9AC0DB");
            atmosphereRadIn = 0.01f;
            atmosphereRadOut = 0.3f;
            orbitTime = 60f*20f;
            rotateTime = 60f*12.3f;
            orbitSpacing = 1;
            orbitRadius = 15f;
            iconColor = Color.valueOf("9AC0DB");
            solarSystem = orrin;
            alwaysUnlocked = clearSectorOnLose = true;
            allowLaunchLoadout = allowLaunchSchematics = false;
            defaultCore = VerdaraStorage.coreProtocol;
            ruleSetter = r -> {
              r.fog = true;
              r.staticFog = false;
              r.ambientLight = Color.valueOf("BDE0EA34");
              r.onlyDepositCore = true;
            };
            allowLaunchToNumbered = false;
            updateLighting = true;
            campaignRuleDefaults.fog = true;
            startSector = 150;
            minZoom = 0.75f;
            generator = new SerpuloPlanetGenerator();
            meshLoader = () -> new MultiMesh(
                new NoiseMesh(this,7,5,Color.valueOf("313439"),1f,4,1,1,0.1f),
                new NoiseMesh(this,7,5,Color.valueOf("5A5541"),0.96f,7,3,2.5f,0.5f)
            );
            cloudMeshLoader = () -> new MultiMesh(
                    new HexSkyMesh(this, 11, 2.7f, 0.1f, 5, Color.valueOf("EEF3FF").a(0.88f), 3, 0.42f, 1f, 0.43f)             
            );
        }};
        protus = new Planet("protus", verdara, 0.5f, 3){{
            accessible = true;
            hasAtmosphere = false;
            landCloudColor = Color.valueOf("535D64");
            orbitTime = 60f*5f;
            rotateTime = 60f*6f;
            orbitSpacing = 1;
            orbitRadius = 4f;
            iconColor = Color.valueOf("535D64");
            solarSystem = orrin;
            alwaysUnlocked = true;
            generator = new SerpuloPlanetGenerator();
            meshLoader = () -> new MultiMesh(
                new NoiseMesh(this,13,5,Color.valueOf("535D64"),0.5f,4,1,1,0.1f),
                new NoiseMesh(this,13,5,Color.valueOf("535D64"),0.5f,7,3,2f,1f)
            );
        }};
    }
}
