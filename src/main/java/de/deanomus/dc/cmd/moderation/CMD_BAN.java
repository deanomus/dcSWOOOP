package de.deanomus.dc.cmd.moderation;

import de.deanomus.dc.cmd.Command;
import de.deanomus.dc.listener.onMessage;
import de.deanomus.dc.util.Embed;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public class CMD_BAN implements Command {
    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {

        if(!onMessage.checkMessage(event)) return true;

        event.getChannel().sendMessage(Embed.warning.setDescription(":warning: In development").build()).queue();
        return true;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) {

    }

    @Override
    public void executed(boolean success, MessageReceivedEvent event) {

    }

    @Override
    public String help() {
        return null;
    }
}
