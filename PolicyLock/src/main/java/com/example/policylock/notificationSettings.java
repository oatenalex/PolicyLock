package com.example.policylock;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class notificationSettings {
    private static notificationSettings instance;
    private static boolean[] notificationLevel = new boolean[4];
    private String emailAddress;
    private boolean emailNotifications;
    private boolean pushNotifications;

    private notificationSettings(){
       // notificationLevel = new boolean[]{true, true, true, false}; //Critical Notifications
        notificationLevel = new boolean[4];
    }

    public static synchronized notificationSettings getInstance()
    {
        if (instance == null)
            instance = new notificationSettings();
        return instance;
    }

    public boolean[] getNotificationLevel() { return notificationLevel; }

    //Setters
    public void setEmailAddress(String email){
        this.emailAddress = email;
    }

    public void setEmailOnlyNotifications() {
        this.emailNotifications = true;
        this.pushNotifications = false;
    }

    public void setEmailPushNotifications() {
        this.emailNotifications = true;
        this.pushNotifications = true;
    }

    public void setAllNotifications(){
        //notificationLevel = {true, true, true, true};
    }
}
