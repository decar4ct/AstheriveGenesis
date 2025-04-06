package astherivegen.content.Elaris.items;

import arc.graphics.*;
import arc.struct.*;
import mindustry.type.Item;

public class ElarisItems {
    public static Item
    quartz
    public static final Seq<Item> ElarisItems = new Seq<>();
    public static void load(){
        quartz = new Item("quartz", Color.valueOf("#e675ab")){{
            hardness=1;
        }};
        ElarisItems.addAll(quartz);
    }
}
