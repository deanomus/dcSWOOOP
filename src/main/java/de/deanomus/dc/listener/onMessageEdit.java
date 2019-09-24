package de.deanomus.dc.listener;

import de.deanomus.dc.storage.Data;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.MessageUpdateEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.awt.*;


public class onMessageEdit extends ListenerAdapter {


    public void onMessageUpdate(MessageUpdateEvent e) {
        if(e.getMessage().getContentDisplay().equals("")) return;
        if(e.getAuthor().getId().equals(e.getJDA().getSelfUser().getId())) return;

        String msg = "";
        if(Data.messages.containsKey(e.getMessageId())) {
            msg += "Alte Nachircht: " + Data.messages.get(e.getMessageId()) + "\n";
        }
        msg += "Neue Nachricht: " + e.getMessage().getContentDisplay();


        Data.messages.put(e.getMessageId(), e.getMessage().getContentDisplay());



        if(!e.getGuild().getId().equals(Data.DC_GUILD)) return;
        if(e.getAuthor().equals(e.getJDA().getSelfUser().getId())) return;


        e.getJDA().getTextChannelById(Data.DC_USER_LOG).sendMessage(new EmbedBuilder()
            .setTitle("Nachricht Editiert")
            .setColor(Color.YELLOW)
            .setFooter("User: " + e.getAuthor().getAsTag() + ", Channel: " + e.getChannel().getName())
            .setDescription(msg)
            .build()).queue();


    }
}
