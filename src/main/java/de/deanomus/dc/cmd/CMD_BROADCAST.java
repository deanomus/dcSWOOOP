package de.deanomus.dc.cmd;

import de.deanomus.dc.storage.Data;
import net.dv8tion.jda.api.entities.ChannelType;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.GuildChannel;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public class CMD_BROADCAST implements Command {
    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        return false;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) {
        if(args.length > 0) {
            int channels = 0;
            String sendedTo = "";
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
            event.getChannel().sendMessage("Dein Rundruf wurde abgesendet! (" + channels + " Channel)" + sendedTo).queue();
        } else {
            event.getChannel().sendMessage(Data.DC_CMD_PREFIX + "broadcast <Nachricht>").queue();
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
