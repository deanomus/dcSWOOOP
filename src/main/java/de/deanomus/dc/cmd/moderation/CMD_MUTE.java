package de.deanomus.dc.cmd.moderation;

import de.deanomus.dc.cmd.Command;
import de.deanomus.dc.listener.onMessage;
import de.deanomus.dc.storage.Data;
import de.deanomus.dc.util.Embed;
import de.deanomus.dc.util.Perms;
import de.deanomus.dc.util.check;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public class CMD_MUTE implements Command {
    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {


        if(!event.getGuild().getId().equals(Data.DC_GUILD)) {
            event.getChannel().sendMessage(Embed.warning.setDescription(":warning: Dieser Command ist für diesen Server nicht freigeschaltet").build()).queue();
            return true;
        }

        if(!onMessage.checkMessage(event)) {
            return true;
        }



        int r = Perms.check(event);
        if(!(r == 2) || !(r == 3)) {
            event.getChannel().sendMessage(Embed.warning.setDescription(":warning: Oops, deine Rechte sind nicht ausreichend für diesen Befehl :warning:").build()).queue();
            return true;
        }

        return false;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) {
        event.getChannel().sendMessage("Erfolgreich").queue();

    }

    @Override
    public void executed(boolean success, MessageReceivedEvent event) {

    }

    @Override
    public String help() {
        return null;
    }
}
