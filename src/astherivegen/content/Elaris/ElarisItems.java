package astherivegen.content.Elaris.blocks;

import arc.graphics.*;
import arc.struct.*;
import mindustry.type.Item;

public class ElarisItems {
    public static Item
    gelionyte, calcite, quartz, fylion, redSand, magnetite, tantalum, anveiur;
    public static final Seq<Item> ElarisItems = new Seq<>();
    public static void load(){
        quartz = new Item("item-gelionyte", Color.valueOf("#e675ab")){{
            hardness=1;
        }};
        ElarisItems.addAll(quartz);
    }
}
