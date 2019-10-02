package de.deanomus.dc.util;

import de.deanomus.dc.storage.Data;
import net.dv8tion.jda.api.entities.GuildChannel;

public class check {


    public static boolean isLog(GuildChannel channel) {


        
        if(channel.getId().equals(Data.DC_BOT_LOG)) return true;
        if(channel.getId().equals(Data.DC_MOD_LOG)) return true;
        if(channel.getId().equals(Data.DC_USER_LOG)) return true;


        return false;
    }








}
