package de.deanomus.dc.listener;

import de.deanomus.dc.storage.Data;
import de.deanomus.dc.util.Embed;
import net.dv8tion.jda.api.events.channel.text.TextChannelDeleteEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class TextChannelDelete extends ListenerAdapter {



    public void onTextChannelDelete(TextChannelDeleteEvent e) {
        e.getJDA().getGuildById(Data.DC_GUILD).getTextChannelById(Data.DC_MOD_LOG).sendMessage(
                Embed.error.setDescription("Ohh Nein :/ #" + e.getChannel().getName() + " wurde gelöscht").build()
        ).queue();
    }




}
