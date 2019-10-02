package de.deanomus.dc.listener;

import de.deanomus.dc.cmd.moderation.CMD_BROADCAST;
import de.deanomus.dc.core.Core;
import de.deanomus.dc.core.StatsUpdate;
import de.deanomus.dc.storage.Data;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.awt.*;


public class onMessage2 extends ListenerAdapter {



    public void onMessageReceived (MessageReceivedEvent e) {


        Data.messages.put(e.getMessageId(), e.getMessage().getContentDisplay());

        if(e.getAuthor().getId().equals(e.getJDA().getSelfUser().getId())) {
            Core.AmountSendMessages += 1;
            if(e.getChannel().getId().equals(Data.DC_BOT_LOG)) Data.delOnStop.add(e.getMessage());
            if(e.getMessage().getContentDisplay().contains(Data.StatsKey)) {
                StatsUpdate.StatsMessages.add(e.getMessageId());
                Data.stats.put(e.getMessageId(), e.getChannel().getId());
            } else if(e.getMessage().getContentDisplay().contains(Data.BroadcastKey)) {
                CMD_BROADCAST.broadcastMSG = e.getMessage();
                CMD_BROADCAST.updated = true;
            } else if(e.getMessage().getContentDisplay().contains(Data.notAllowedToSendMessageKey)) {
                Data.notAllowedToSendHereMessageUser.put(e.getMessage(), e.getAuthor().getId());

                e.getMessage().editMessage(new EmbedBuilder()
                        .setTitle("Nachricht entfernt!")
                        .setColor(Color.RED)
                        .setDescription(e.getJDA().getUserById(Data.notAllowedToSendHereMessageUser.get(e.getMessage())).getAsMention() + ", im " + e.getChannel().getName() + " darf nur ich schreiben!")
                        .build()
                ).queue();
                



            }
        } else {
            Core.AmountGetMessages += 1;
        }



    }
}
