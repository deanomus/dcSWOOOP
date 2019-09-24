package de.deanomus.dc.cmd;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.net.URLEncoder;

public class CMD_GOOGLE implements Command {
    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        return false;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) {

        if(args.length > 0) {








        } else event.getChannel().sendMessage("-google <Suchbegriff>").queue();
    }

    @Override
    public void executed(boolean success, MessageReceivedEvent event) {

    }

    @Override
    public String help() {
        return null;
    }
}
