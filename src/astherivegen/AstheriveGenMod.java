package astherivegen;

import arc.*;
import arc.util.*;
import astherivegen.content.Elaris.blocks.*;
import astherivegen.content.Elaris.items.*;
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
                dialog.cont.add("behold").row();
                //mod sprites are prefixed with the mod name (this mod is called 'example-java-mod' in its config)
                dialog.cont.image(Core.atlas.find("astherive-gen-frog")).pad(20f).row();
                dialog.cont.add("yes i still keep this from the java mod template its funny").row();
                dialog.cont.button("I see", dialog::hide).size(100f, 50f);
                dialog.show();
            });
        });
    }

    @Override
    public void loadContent(){
        ElarisItems.load();
        ElarisBlocks.load();
    }

}
