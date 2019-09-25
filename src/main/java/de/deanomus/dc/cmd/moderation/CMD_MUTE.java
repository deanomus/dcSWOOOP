package de.deanomus.dc.cmd.moderation;

import de.deanomus.dc.cmd.Command;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public class CMD_MUTE implements Command {
    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        return false;
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
