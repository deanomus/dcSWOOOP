package de.deanomus.dc.cmd;

import de.deanomus.dc.storage.Data;
import de.deanomus.dc.util.Embed;
import net.dv8tion.jda.api.MessageBuilder;
import net.dv8tion.jda.api.entities.*;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

public class CMD_BROADCAST implements Command {

    public static Message broadcastMSG;
    public static boolean updated = false;

    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        return false;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) {




        Thread broadT = new Thread(new Runnable() {
            public void run()
            {


                if(args.length > 0) {
                    int channels = 0;
                    String sendedTo = "";


                    event.getChannel().sendMessage("Bitte warte kurz.... : " + Data.BroadcastKey).queue();

                    while(!updated) {
                        try {
                            TimeUnit.MILLISECONDS.sleep(250);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    Data.log("Es geht weiter...", Color.GREEN);
                    updated = false;

                    Message msg = broadcastMSG;
                    msg.editMessage("Deine Nachricht wird gesendet...").queue();


                    for(Guild g : event.getJDA().getGuilds()) {
                        sendedTo += "\n\n" + g.getName() + " (" + g.getId() + "):\n";
                        for(GuildChannel c : g.getChannels()) {
                            if(c.getType().equals(ChannelType.TEXT)) {
                                channels++;
                                sendedTo += c.getName() + ", ";
                        event.getJDA().getGuildById(g.getId()).getTextChannelById(c.getId()).sendMessage(String.join(" ", args)).queue();
                            }
                        }
                    }
                    msg.editMessage("Deine Nachricht wurde an " + channels + " Channel gesendet.").queue();
                    msg.editMessage(Embed.success.setDescription(sendedTo).build()).queue();
//                    event.getChannel().sendMessage("Dein Rundruf wurde abgesendet! (" + channels + " Channel)" + sendedTo).queue();
                } else {
                    event.getChannel().sendMessage(Data.DC_CMD_PREFIX + "broadcast <Nachricht>").queue();
                }


            }});
        broadT.start();
    }

    @Override
    public void executed(boolean success, MessageReceivedEvent event) {

    }

    @Override
    public String help() {
        return null;
    }
}
