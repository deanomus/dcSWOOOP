package de.deanomus.dc.listener;

import de.deanomus.dc.core.Core;
import de.deanomus.dc.core.StatsUpdate;
import de.deanomus.dc.storage.Data;
import net.dv8tion.jda.api.events.ReadyEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.awt.*;

public class onReadyLis extends ListenerAdapter {


    public void onReady (ReadyEvent e) {

        //Add Log-Channels to ArrayList logs
        Data.logs.add(Data.DC_BOT_LOG);
        Data.logs.add(Data.DC_USER_LOG);

        Data.log("Der Bot wurde erfolgreich gestartet !", Color.GREEN);




        e.getJDA().getTextChannelById(Data.DC_BOT_LOG).sendMessage(Data.StatsKey).queue();

        StatsUpdate.update(e.getJDA());




    }


}
