package de.deanomus.dc.cmd.administration;

import de.deanomus.dc.cmd.Command;
import de.deanomus.dc.core.Core;
import de.deanomus.dc.listener.onMessage;
import de.deanomus.dc.listener.onReaction;
import de.deanomus.dc.storage.Data;
import de.deanomus.dc.util.Embed;
import de.deanomus.dc.util.Perms;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

import java.awt.*;

public class CMD_STOP implements Command {
    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        int p = Perms.check(event);

        if(p == 3) {
            if(onMessage.checkMessage(event)) return false;
            return true;
        } else {
            event.getChannel().sendMessage(Embed.warning.setDescription(":warning: Oops, deine Rechte sind nicht ausreichend für diesen Befehl :warning:").build()).queue();
            return true;
        }
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) {
        if(Core.shardMan != null) {
            event.getChannel().sendMessage(Embed.warning.setDescription("Bot wird heruntergefahren...").build()).queue();

            for(Message msg : Data.delOnStop) {
                msg.delete().queue();
            }

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
