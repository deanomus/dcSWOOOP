package de.deanomus.dc.storage;

import de.deanomus.dc.core.Core;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageChannel;

import java.awt.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

public class Data {

    public static HashMap<String, String> messages = new HashMap<String, String>();
    public static HashMap<String, String> stats = new HashMap<String, String>();
    public static ArrayList<String> logs = new ArrayList<String>();
    public static boolean botUP = true;

    public static final String
            DC_TOKEN = "NjIxNjMyMjgyNTE5OTI4ODMz.XXoKrg._t1OBUCBFaTBoPD-AwQys-N7lGY",
            DC_GUILD = "621633248967131136",
            DC_BOT_LOG = "621640962271215636",
            DC_USER_LOG = "621671553847001088",
            DC_CMD_PREFIX = "-",
            StatsKey = "T^y2sWVksduH8^9o!tLrktH^PbL&bpA0@S2Eog7sVBwyxXrG04g^hya8TMb5rluj@l#7FrkN2Be2VeywK0JhoS*!yXwGuCSv@FlVZUcmBBLU%gLy3DYCp6%jsDD#3dX0VgJVVs8PQ#Qw9rkhiW5rFYWVF!im2^$JscHgMbDEGa%HnNsvfL5ZE46o3hW!utbDyffLk8#x8KJ782Ns9nKPqtjQwu2vSqEsc48xhavh&QePMLQllaioV@dL4JCYKbmTQ5EkaXd1YU%EqqJ#58Bttf1R6p3965S6U2S@WJmj!SqSTe&sU08zl3S5DA8xcB26U@6CFf@ijFQYpH^!G&IaM^KX$$Ny0!4hhhe7K51ej$UaFrYNPjK3*nZdMhiZVHqX2ypQ5oouyFhoV2rHyg0UC%73zaaPJTTGLCZysekgzdU5!1OzLnlV!nfmFrlzPT7xFM11YBSYVEJKA0mMMbxh35r*PQm9c&WjNme1MkT27uV0p2Ghi!CE";


    public static MessageChannel DC_LOG_CHANNEL = Core.shardMan.getGuildById(DC_GUILD).getTextChannelById(DC_BOT_LOG);



    public static void log(String text) {
        System.out.print(text + "\n");
        DC_LOG_CHANNEL.sendMessage(text).queue();
    }

    public static void log(String text, Color color) {
        System.out.print(text + "\n");
        DC_LOG_CHANNEL.sendMessage(new EmbedBuilder()
                .setColor(color)
                .setTitle("Developer-Log")
                .setDescription(text)

        .build()
        ).queue();
    }

}
