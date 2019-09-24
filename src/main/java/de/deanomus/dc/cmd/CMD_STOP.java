package de.deanomus.dc.cmd;

import de.deanomus.dc.core.Core;
import de.deanomus.dc.storage.Data;
import de.deanomus.dc.util.Embed;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

import java.awt.*;

public class CMD_STOP implements Command {
    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        return false;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) {
        if(Core.shardMan != null) {
            event.getChannel().sendMessage(Embed.warning.setDescription("Bot wird heruntergefahren...").build()).queue();
            Core.shardMan.setStatus(OnlineStatus.OFFLINE);
            Data.botUP = false;
            Data.log("Der Bot wurde erfolgreich heruntergefahren! (" + event.getAuthor().getName() + ")", Color.GREEN);
            Core.shardMan.shutdown();
        } else Data.log("Hier ist ein Fehler aufgetreten", Color.RED);
    }

    @Override
    public void executed(boolean success, MessageReceivedEvent event) {

    }

    @Override
    public String help() {
        return null;
    }
}
