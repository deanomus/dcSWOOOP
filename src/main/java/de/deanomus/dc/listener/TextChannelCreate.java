package de.deanomus.dc.listener;

import de.deanomus.dc.storage.Data;
import de.deanomus.dc.util.Embed;
import net.dv8tion.jda.api.events.channel.text.TextChannelCreateEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TextChannelCreate extends ListenerAdapter {


    public void onTextChannelCreate(TextChannelCreateEvent e) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        e.getChannel().sendMessage(Embed.success.setDescription("Dieser Channel sieht aber sehr toll aus :smile: " + e.getChannel().getAsMention()).setFooter("Created at: " + formatter.format(date)).build()).queue();
        e.getJDA().getGuildById(Data.DC_GUILD).getTextChannelById(Data.DC_MOD_LOG).sendMessage(Embed.success.setDescription("Ein neuer Channel wurde erstellt :white_check_mark: " + e.getChannel().getAsMention()).build()).queue();
        Embed.success.setFooter(null);
    }


}
