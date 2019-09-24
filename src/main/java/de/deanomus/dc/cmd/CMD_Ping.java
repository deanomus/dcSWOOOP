package de.deanomus.dc.cmd;

import de.deanomus.dc.listener.onMessage;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public class CMD_Ping implements  Command {


    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        if(onMessage.checkMessage(event)) return false;
        return true;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) {
        event.getChannel().sendMessage("Pong!").queue();
        if(args.length == 1) {
            event.getChannel().sendMessage(args[0]).queue();
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
