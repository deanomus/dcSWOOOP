package de.deanomus.dc.cmd;

import de.deanomus.dc.storage.Data;
import de.deanomus.dc.util.Embed;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageHistory;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

import java.util.List;

public class CMD_CLEAR implements Command {


    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        return false;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) {
        //Legt die minimalen und maximalen Werte an, die mit einem Command gelöscht werden können
        //Achtung! Discord API Limit beträgt max. 100 deletes, max-Wert wird nochmal um 1 addiert
        int minDelete = 2;
        int maxDelete = 99;

        if(args.length != 1) {
            event.getChannel().sendMessage(Embed.error.setDescription
                    ("Oops, da hat etwas nicht funktioniert, nutze bitte " + Data.DC_CMD_PREFIX + "clear <Anzahl>")
                    .build()).queue();
        } else {
            int numb;
            try {
                numb = Integer.parseInt(args[0]);
            } catch (Exception e) {
                event.getChannel().sendMessage(Embed.error.setDescription
                        ("Oops, da hat etwas nicht funktioniert, nutze bitte " + Data.DC_CMD_PREFIX + "clear <Anzahl>")
                        .build()).queue();
                numb = 0;
            }
            if(numb == 0) return;


            if (numb > minDelete && numb <= maxDelete) {


                MessageHistory history = new MessageHistory(event.getChannel());
                List<Message> msgs;

                msgs = history.retrievePast(numb+1).complete();
                numb = msgs.size();
                event.getTextChannel().deleteMessages(msgs).queue();

                event.getChannel().sendMessage(Embed.success.setDescription(event.getAuthor().getAsTag() + ", Erfolgreich " + numb + " Nachrichten gelöscht!").build()).queue();






            } else event.getChannel().sendMessage(Embed.error.setDescription(
                    "Oops, du kannst nicht weniger als " + minDelete + " Nachrichten und nicht mehr als " + maxDelete + " Nachrichten löschen"
            ).build()).queue();
        }
    }

    @Override
    public void executed(boolean success, MessageReceivedEvent event) {

    }

    @Override
    public String help() {
        return null;
    }
}
