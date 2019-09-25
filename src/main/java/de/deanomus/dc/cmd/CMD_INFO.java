package de.deanomus.dc.cmd;

import de.deanomus.dc.core.Core;
import de.deanomus.dc.util.Embed;
import net.dv8tion.jda.api.entities.*;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;

public class CMD_INFO implements Command {
    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        return false;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) {

        //Start User Info

        String infoUser =
                "Name: " + event.getAuthor().getName() + "\n" +
                "Gruppen: ";

        int ir = event.getGuild().getMember(event.getAuthor()).getRoles().size();
        if(ir == 0) infoUser += "404, Keine Gruppen gefunden";
        for(Role r : event.getGuild().getMember(event.getAuthor()).getRoles()) {
            infoUser += r.getName();
            if(ir != 1) {
                ir--;
                infoUser += ", ";
            }
        }

        event.getChannel().sendMessage(Embed.success.setTitle("Informationen über dich:").setDescription(infoUser).build()).queue();

        //Ende User Info
        //Start Guild Info

        int text = 0;
        int voice = 0;
        int other = 0;
        for(GuildChannel c : event.getGuild().getChannels()) {
            if(c.getType().equals(ChannelType.TEXT)) {
                text ++;
            } else if(c.getType().equals(ChannelType.VOICE)) {
                voice++;
            } else if(c.getType().equals(ChannelType.CATEGORY)) {
                //Kein Counter
            }else {
                event.getChannel().sendMessage(c.getName()).queue();
                other++;
            }
        }


        String infoGuild =
                "Name: " + event.getGuild().getName() + "\n" +
                "Erstellt: " + event.getGuild().getTimeCreated() + "\n" +
                "Mitglieder: " + event.getGuild().getMembers().size() + "\n" +
                "Channel: " + (text+voice+other) + " ";
        infoGuild += "(Text: " + text + ", Voice: " + voice;
        if(other != 0) {
            infoGuild += ", Other: " + other;
        }
        infoGuild += ")";

        event.getChannel().sendMessage(Embed.success.setTitle("Informationen über den Guild:").setDescription(infoGuild).build()).queue();

        //Ende Info Guild
        //Start Info Bot

        RuntimeMXBean rb = ManagementFactory.getRuntimeMXBean();
        long uptime = rb.getUptime();

        int members = 0;
        for(Guild g : event.getJDA().getGuilds()) {
            for(Member m : g.getMembers()) {
                members++;
            }
        }
        String infoBot = "Name: " + event.getJDA().getSelfUser().getName() + "\n" +
                "Uptime: " + uptime / 1000 / 60 + "Minuten\n" +
                "Empfangende Nachrichten: " + Core.AmountGetMessages + "\n" +
                "Gesendete Nachrichten: " + Core.AmountSendMessages + "\n" +
                "Guilds: " + event.getJDA().getGuilds().size() + ", Channel: " + (event.getJDA().getTextChannels().size() + event.getJDA().getVoiceChannels().size()) + "\n" +
                "Unterschiedliche Member: " + members;

        event.getChannel().sendMessage(Embed.success.setTitle("Informationen über den Bot:").setDescription(infoBot).build()).queue();
        Embed.success.setTitle(null);
    }

    @Override
    public void executed(boolean success, MessageReceivedEvent event) {

    }

    @Override
    public String help() {
        return null;
    }
}
