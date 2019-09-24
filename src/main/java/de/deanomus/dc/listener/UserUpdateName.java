package de.deanomus.dc.listener;

import de.deanomus.dc.storage.Data;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.user.update.UserUpdateNameEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

import java.awt.*;

public class UserUpdateName extends ListenerAdapter {

    public void onUserUpdateName(@NotNull UserUpdateNameEvent e) {

        Data.log("Debug: Namen erkannt");
        e.getJDA().getTextChannelById(Data.DC_USER_LOG).sendMessage(new EmbedBuilder()
                .setColor(Color.YELLOW)
                .setDescription(e.getUser().getAsTag() + " hat seinen Namen zu " + e.getUser().getName() + " geändert.")
                .build()
        ).queue();

    }
}
