package de.deanomus.dc.cmd;

import de.deanomus.dc.core.Core;
import de.deanomus.dc.listener.onMessage;
import de.deanomus.dc.storage.Data;
import de.deanomus.dc.util.Embed;
import de.deanomus.dc.util.Perms;
import net.dv8tion.jda.api.MessageBuilder;
import net.dv8tion.jda.api.OnlineStatus;
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
        int p = Perms.check(event);

        if(p == 3 || p == 2) {
            if(onMessage.checkMessage(event)) return false;
            return true;
        } else {


            event.getChannel().sendMessage(Embed.warning.setDescription(":warning: Oops, deine Rechte sind nicht ausreichend für diesen Befehl :warning:").build()).queue();
            return true;
        }
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) {




        Thread broadT = new Thread(new Runnable() {
            public void run()
            {


                if(args.length > 0) {
                    int channels = 0;
                    String sendedTo = "";
                    String sendedToFooter = "";


                    event.getChannel().sendMessage("Wir bereiten einen Broadcast vor, kurz Geduld bitte. Danke! " + Data.BroadcastKey).queue();

                    while(!updated) {
                        try {
                            TimeUnit.MILLISECONDS.sleep(250);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    updated = false;

                    Message msg = broadcastMSG;
                    msg.editMessage("Deine Nachricht wird gesendet...").queue();

                    Core.shardMan.setActivity(Activity.playing("sending broadcast"));
                    Core.shardMan.setStatus(OnlineStatus.DO_NOT_DISTURB);
                    for(Guild g : event.getJDA().getGuilds()) {
                        if(sendedTo.length() < 2000) {
                            sendedTo += "\n\n" + g.getName() + " (" + g.getId() + "):\n";
                        } else sendedToFooter += "\n\n" + g.getName() + " (" + g.getId() + "):\n";
                        for(GuildChannel c : g.getChannels()) {
                            if(c.getType().equals(ChannelType.TEXT)) {
                                channels++;


                                if(sendedTo.length() < 2000) {
                                    sendedTo += c.getName() + ", ";
                                } else sendedToFooter += c.getName() + ", ";
                        event.getJDA().getGuildById(g.getId()).getTextChannelById(c.getId()).sendMessage(String.join(" ", args)).queue();
                            }
                        }
                    }
                    msg.editMessage("Deine Nachricht wurde an " + channels + " Channel gesendet.").queue();
                    msg.editMessage(Embed.success.setDescription(sendedTo).setFooter(sendedToFooter).build()).queue();
                    Embed.success.setFooter("");
                    Core.shardMan.setActivity(Activity.watching("mySWOOOP"));
                    Core.shardMan.setStatus(OnlineStatus.ONLINE);
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
