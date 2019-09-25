package de.deanomus.dc.storage;

import de.deanomus.dc.core.Core;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.MessageChannel;

import java.awt.*;
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
            StatsKey = "T^y2sWVksduH8^9o!tLrktH^PbL&bpA0@S2Eog7sVBwyxXrG04g^hya8TMb5rluj@l#7FrkN2Be2VeywK0JhoS*!yXwGuCSv@FlVZUcmBBLU%gLy3DYCp6%jsDD#3dX0VgJVVs8PQ#Qw9rkhiW5rFYWVF!im2^$JscHgMbDEGa%HnNsvfL5ZE46o3hW!utbDyffLk8#x8KJ782Ns9nKPqtjQwu2vSqEsc48xhavh&QePMLQllaioV@dL4JCYKbmTQ5EkaXd1YU%EqqJ#58Bttf1R6p3965S6U2S@WJmj!SqSTe&sU08zl3S5DA8xcB26U@6CFf@ijFQYpH^!G&IaM^KX$$Ny0!4hhhe7K51ej$UaFrYNPjK3*nZdMhiZVHqX2ypQ5oouyFhoV2rHyg0UC%73zaaPJTTGLCZysekgzdU5!1OzLnlV!nfmFrlzPT7xFM11YBSYVEJKA0mMMbxh35r*PQm9c&WjNme1MkT27uV0p2Ghi!CE",
            BroadcastKey = "1sM%Tm!eQtjC0wF#fELEgqBjRFD!@vP8&^Cw0zRKhX2EQBdkuSqZ$F&V4NT#n5%sg%M8JhdcQ5BsyPsJswI9*7j1L1g3G&c^ButgK8SAScergYU9L!!!w47Mw8xDfIgtpjr7NCwQjsuJYDOrc9IsA@*2pxPBimvucvJQnXA^hW7b39fTr3zlLyTIxlAIPQY9LdUTbCzpVrjx87#hJkeh5qC#nem9hqYeQmqpH5kjl6Mx$sdjRx3%l116HAq%!^acZEGge$6xYTUhxm!xtkhCCRdgB*@$4*mgfunUUmBRKZmt7lv3IedO5%^0&J1GBmzKFVH^QW1l@XEeIcKS$#fqi$Te9n!^*J^t6teXeuyqHoC9#kRv7Pd7Wsthi5SH&k%r80hslTi&JpHn!TN#WASs5Tnz9Zx%Biggr78d2HC8%M@*cSx7jdnLgJpEjW^MnAEhrK";


    public static final String
            DC_ADMIN    = "621640448808714241",
            DC_DEV      = "621640497898717204",
            DC_MOD      = "626061236936900629";


    public static final String[]
            DC_ADMINPERMS_ROLES = {DC_ADMIN, DC_DEV},
            DC_MODPERMS_ROLES   = {DC_MOD};



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
