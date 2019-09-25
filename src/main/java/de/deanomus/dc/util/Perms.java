package de.deanomus.dc.util;

import de.deanomus.dc.storage.Data;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

import java.util.Arrays;

public class Perms {

    //Adminperms == 3
    //Modperms == 2
    //Userperms == 1
    //Guestperms == 0

    public static int check(MessageReceivedEvent e) {


        for(Role r : e.getGuild().getMember(e.getAuthor()).getRoles()) {


            if(Arrays.stream(Data.DC_ADMINPERMS_ROLES).parallel().anyMatch(r.getId()::contains)) {
                return 3;
            } else if(Arrays.stream(Data.DC_MODPERMS_ROLES).parallel().anyMatch(r.getId()::contains)) {
                return 2;
            } else if(true) {
                return 1;
            } else {
                return 0;
            }





        }
        return 0;
    }





}
