package astherivegen.content.Verdara;

import arc.graphics.*;
import arc.struct.*;
import mindustry.type.*;

public class VerdaraItems{
    public static Item
    quartz, magnetite, polterite;
    public static final Seq<Item> verdaraItems = new Seq<>();

    public static void load(){
        quartz = new Item("quartz", Color.valueOf("BCC3BF")){{
            hardness = 1;
            cost = 0.5f;
            alwaysUnlocked = true;
        }};

        magnetite = new Item("magnetite", Color.valueOf("6C6E75")){{
            hardness = 2;
            cost = 0.7f;
        }};
      
        polterite = new Item("polterite", Color.valueOf("888283")){{
            hardness = 3;
            cost = 0.8f;
        }};
        
        verdaraItems.addAll(
        quartz, magnetite, polterite
        );
    }
}
