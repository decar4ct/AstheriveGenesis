package astherivegen;

import arc.*;
import arc.util.*;
import astherivegen.content.Elaris.blocks.*;
import astherivegen.content.Elaris.*;
import mindustry.*;
import mindustry.content.*;
import mindustry.game.EventType.*;
import mindustry.gen.*;
import mindustry.mod.*;
import mindustry.ui.dialogs.*;

public class AstheriveGenMod extends Mod{

    public AstheriveGenMod(){
        Log.info("Loaded AstheriveGenMod constructor.");

        //listen for game load event
        Events.on(ClientLoadEvent.class, e -> {
            //show dialog upon startup
            Time.runTask(10f, () -> {
                BaseDialog dialog = new BaseDialog("frog");
                dialog.cont.add("bruv i just told u this mod is unplayable").row();
                dialog.cont.button("get out", dialog::hide).size(100f, 50f);
                dialog.show();
            });
        });
    }

    @Override
    public void loadContent(){
        ElarisItems.load();
        ElarisUnitTypes.load();
        ElarisBlocks.load();
    }
}
