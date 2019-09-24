package de.deanomus.dc.listener;

import de.deanomus.dc.core.Core;
import de.deanomus.dc.core.StatsUpdate;
import de.deanomus.dc.storage.Data;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;


public class onMessage2 extends ListenerAdapter {



    public void onMessageReceived (MessageReceivedEvent e) {


        Data.messages.put(e.getMessageId(), e.getMessage().getContentDisplay());

        if(e.getAuthor().getId().equals(e.getJDA().getSelfUser().getId())) {
            Core.AmountSendMessages += 1;
            if(e.getMessage().getContentDisplay().contains(Data.StatsKey)) {
                StatsUpdate.StatsMessages.add(e.getMessageId());
                Data.stats.put(e.getMessageId(), e.getChannel().getId());
            }
        } else {
            Core.AmountGetMessages += 1;
        }



    }
}
