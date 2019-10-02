package de.deanomus.dc.cmd.moderation;

import de.deanomus.dc.cmd.Command;
import de.deanomus.dc.listener.onMessage;
import de.deanomus.dc.storage.Data;
import de.deanomus.dc.util.Embed;
import de.deanomus.dc.util.Perms;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public class CMD_CHANGENAME implements Command {
    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        int p = Perms.check(event);

        if(p == 3 || p == 2) {
            if(onMessage.checkMessage(event)) return false;
            return true;
        } else {


            event.getChannel().sendMessage(Embed.warning.setDescription(":warning: Oops, deine Rechte sind nicht ausreichend für diesen Befehl :warning:").build()).queue();
            return true;
        }
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) {
        if(args.length == 1) {
            int maxLength = 32;

            if(args[0].length() <= maxLength) {
                event.getGuild().getMember(event.getJDA().getUserById(event.getJDA().getSelfUser().getId())).modifyNickname(args[0]).queue();
                event.getChannel().sendMessage(Embed.success.setDescription("Ich habe meinen Namen zu " + args[0] + " geändert.").build()).queue();
            } else event.getChannel().sendMessage(Embed.warning.setDescription(":warning: Mein Neuer Name darf nicht länger als " + maxLength + " Zeichen sein").build()).queue();

        } else event.getChannel().sendMessage(Embed.warning.setDescription(":warning: Nutze " + Data.DC_CMD_PREFIX + " <Neuer-Name> um den Namen, des Bots zu ändern!").build()).queue();
    }

    @Override
    public void executed(boolean success, MessageReceivedEvent event) {

    }

    @Override
    public String help() {
        return null;
    }
}
