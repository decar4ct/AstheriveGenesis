package astherivegen.content;

import arc.math.*;
import arc.graphics.*;
import mindustry.content.*;
import mindustry.type.*;

import static mindustry.content.StatusEffects.*;

public class AquaStatuses {
    public static StatusEffect seen;
    public static void load(){
        ionized = new StatusEffect("seen"){{
            color = Color.valueOf("ffab84");
            effect = Fx.none;
        }};
    }
}
