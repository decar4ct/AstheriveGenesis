package astherivegen.content;

import arc.graphics.*;
import arc.struct.*;
import mindustry.type.*;

public class Items{
    public static Item
    quartz, magnetite, polterite;
    public static final Seq<Item> serpuloItems = new Seq<>()

    public static void load(){
        quartz = new Item("quartz", Color.valueOf("d99d73")){{
            hardness = 1;
            cost = 0.5f;
            alwaysUnlocked = true;
        }};

        magnetite = new Item("magnetite", Color.valueOf("8c7fa9")){{
            hardness = 2;
            cost = 0.7f;
        }};
      
        polterite = new Item("polterite", Color.valueOf("53565c")){{
            hardness = 3;
            cost = 0.8f;
        }};
        
        elarisItems.addAll(
        quartz, magnetite, polterite
        );
    }
}
