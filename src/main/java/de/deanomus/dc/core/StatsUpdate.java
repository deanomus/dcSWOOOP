package de.deanomus.dc.core;

import de.deanomus.dc.storage.Data;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.JDA;

import java.awt.*;
import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class StatsUpdate {

    public static ArrayList<String> StatsMessages = new ArrayList<String>();

    public static void update(JDA jda) {



        Thread t1 = new Thread(new Runnable() {
            public void run()
            {
                Color color = Color.YELLOW;
                while(Data.botUP) {



                    RuntimeMXBean rb = ManagementFactory.getRuntimeMXBean();
                    long uptime = rb.getUptime();
                    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                    Date date = new Date();
                    for (String mesID : StatsMessages) {
                        jda.getTextChannelById(Data.stats.get(mesID)).editMessageById(mesID, "Du willst Content? Ich gebe dir Content! Hier!").queue();
                        jda.getTextChannelById(Data.stats.get(mesID)).editMessageById(mesID, new EmbedBuilder()
                                .setTitle("Statistiken (Diese Session)")
                                .setColor(color)
                                .setDescription("" +
                                        "- Uptime: " + uptime / 1000 / 60 + " Minuten" +
                                        "\n- Empfangende Nachrichten: " + Core.AmountGetMessages +
                                        "\n- Gesendete Nachrichten: " + Core.AmountSendMessages)
                                .setFooter("Last Updated: " + formatter.format(date))
                                .build()
                        ).queue();
                    }
                    if(color.equals(Color.YELLOW)) {
                        color = Color.RED;
                    } else {
                        color = Color.YELLOW;
                    }



                        try {
                            TimeUnit.SECONDS.sleep(10);
                        } catch (InterruptedException e) {
//                            e.printStackTrace();
                            System.out.print("Oops, ein Fehler ist aufgetreten");
                        }



                }



            }});
        t1.start();




    }
}
