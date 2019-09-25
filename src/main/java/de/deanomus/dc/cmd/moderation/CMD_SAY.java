package de.deanomus.dc.cmd.moderation;

import de.deanomus.dc.cmd.Command;
import de.deanomus.dc.storage.Data;
import de.deanomus.dc.util.Embed;
import de.deanomus.dc.util.Perms;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;


public class CMD_SAY implements Command {
    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {


        int p = Perms.check(event);

        if(p == 3 || p == 2) return false;


        event.getChannel().sendMessage(Embed.warning.setDescription(":warning: Oops, deine Rechte sind nicht ausreichend für diesen Befehl :warning:").build()).queue();
        return true;
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
