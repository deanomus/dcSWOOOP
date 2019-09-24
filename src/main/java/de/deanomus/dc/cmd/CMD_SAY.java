package de.deanomus.dc.cmd;

import de.deanomus.dc.storage.Data;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

import java.util.Arrays;

public class CMD_SAY implements Command {
    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        return false;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) {
        if(args.length > 0) {
            event.getChannel().sendMessage(String.join(" ", args)).queue();
        } else {
            event.getChannel().sendMessage(Data.DC_CMD_PREFIX + "say <Nachricht>").queue();
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
