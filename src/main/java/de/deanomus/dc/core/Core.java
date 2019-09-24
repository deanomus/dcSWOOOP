package de.deanomus.dc.core;

import de.deanomus.dc.cmd.*;
import de.deanomus.dc.listener.*;
import de.deanomus.dc.storage.Data;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.sharding.DefaultShardManagerBuilder;
import net.dv8tion.jda.api.sharding.ShardManager;

import javax.security.auth.login.LoginException;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;

public class Core {

    public static ShardManager shardMan;
    public static int
            AmountGetMessages = 0,
            AmountSendMessages = 0;

    public static void main(String[] args) {

        DefaultShardManagerBuilder builder = new DefaultShardManagerBuilder();
        builder.setToken(Data.DC_TOKEN);

        builder.setActivity(Activity.watching("mySWOOOP"));
        builder.setStatus(OnlineStatus.ONLINE);
        builder.setAutoReconnect(true);




        //Add Event Listeners
        System.out.print("Register Listeners...\n");

        builder.addEventListeners(new onMessageEdit());
        builder.addEventListeners(new UserUpdateName());
        builder.addEventListeners(new onMessage2());
        builder.addEventListeners(new onReadyLis());
        builder.addEventListeners(new cmdListener());


        //Add Commands
        cmdHandler.commands.put("ping", new CMD_Ping());
        cmdHandler.commands.put("say", new CMD_SAY());
        cmdHandler.commands.put("broadcast", new CMD_BROADCAST());
        cmdHandler.commands.put("clear", new CMD_CLEAR());
        cmdHandler.commands.put("stop", new CMD_STOP());



        try {
            shardMan = builder.build();
        } catch (LoginException e) {
            e.printStackTrace();
        }


    }





}
