package de.deanomus.dc.listener;

import de.deanomus.dc.core.cmdHandler;
import de.deanomus.dc.storage.Data;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class cmdListener extends ListenerAdapter {

    public void onMessageReceived(MessageReceivedEvent e) {


        if(e.getAuthor().getId().equals(e.getJDA().getSelfUser().getId())) return;

        if(e.getMessage().getContentDisplay().startsWith(Data.DC_CMD_PREFIX)) {
            cmdHandler.handleCommand(cmdHandler.parser.parse(e.getMessage().getContentDisplay(), e));
        } else onMessage.checkMessage(e);


    }


}
