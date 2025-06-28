package astherivegen.content;

import arc.func.Cons;
import arc.graphics.Color;
import arc.math.Rand;
import arc.math.geom.Mat3D;
import arc.util.Tmp;
import arc.struct.Seq;
import astherivegen.content.Verdara.blocks.VerdaraEnv;
import astherivegen.content.Verdara.blocks.VerdaraStorage;
import astherivegen.planet.*;
import mindustry.content.Blocks;
import mindustry.graphics.g3d.*;
import mindustry.maps.planet.AsteroidGenerator;
import mindustry.maps.planet.ErekirPlanetGenerator;
import mindustry.type.*;
import mindustry.world.Block;
import mindustry.world.meta.Env;

public class GenesisPlanets{
    public static Planet
            //star
            orrin, thessar,

    // planets
    verdara;

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
        }};
        thessar = new Planet("thessar", orrin, 2f, 0){{
            accessible = true;
            hasAtmosphere = true;
            solarSystem = orrin;
            orbitRadius = 35f;

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
            orbitRadius = 10f;
            iconColor = Color.valueOf("9AC0DB");
            solarSystem = orrin;
            alwaysUnlocked = clearSectorOnLose = true;
            allowLaunchLoadout = allowLaunchSchematics = false;
            defaultCore = VerdaraStorage.coreProtocol;
            ruleSetter = r -> {
              r.fog = true;
              r.staticFog = false;
              r.ambientLight = Color.valueOf("E3EB54");
              r.onlyDepositCore = true;
            };
            allowLaunchToNumbered = false;
            updateLighting = true;
            campaignRuleDefaults.fog = true;
            startSector = 100;
            minZoom = 0.75f;
            generator = new VerdaraPlanetGenerator();
            meshLoader = () -> new MultiMesh(
                    new HexMesh(this, 5)
            );
            cloudMeshLoader = () -> new MultiMesh(
                    new HexSkyMesh(this, 11, 2.7f, 0.1f, 5, Color.valueOf("EEF3FF").a(0.88f), 3, 0.42f, 1f, 0.43f)             
            );
        }};
    }
}
