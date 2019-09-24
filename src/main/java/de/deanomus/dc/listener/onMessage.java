package de.deanomus.dc.listener;

import de.deanomus.dc.storage.Data;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

import java.awt.*;
import java.util.HashMap;


public class onMessage {

    public static HashMap<String, String> Deleted = new HashMap<String, String>();

    public static boolean checkMessage (MessageReceivedEvent e) {

        //Prüfe ob Nachricht von Bot kommt
        if(e.getAuthor().getId().equals(e.getJDA().getSelfUser().getId())) return false;
        //Prüfe ob Nachricht in einem Log Channel gesendet wurde
        if(Data.logs.contains(e.getChannel().getId())) {



            if(Deleted.containsKey(e.getAuthor().getId())) {
                if(Deleted.get(e.getAuthor().getId()).equals(e.getChannel().getId())) {
                    e.getMessage().delete().queue();
                    return false;
                }
            }
            Deleted.put(e.getAuthor().getId(), e.getChannel().getId());

            e.getChannel().sendMessage(new EmbedBuilder()
                    .setTitle("Nachricht entfernt!")
                    .setColor(Color.RED)
                    .setDescription(e.getAuthor().getAsMention() + ", im " + e.getChannel().getName() + " darf nur ich schreiben!")
                    .build()
            ).queue();
            e.getMessage().delete().queue();
            return false;
        }


        return true;
    }
}
