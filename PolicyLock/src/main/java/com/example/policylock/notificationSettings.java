package com.example.policylock;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class notificationSettings {
    private static notificationSettings instance;
    private static List<Boolean> notificationLevel = new ArrayList<>();
    private String emailAddress;
    private boolean emailNotifications;
    private boolean pushNotifications;

    private notificationSettings(){
        notificationLevel = Arrays.asList(true, true, true, false); //Critical, warning, notice, info
    }

    public static synchronized notificationSettings getInstance()
    {
        if (instance == null)
            instance = new notificationSettings();
        return instance;
    }

    public List<Boolean> getNotificationLevel() { return notificationLevel; }

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
        notificationLevel = Arrays.asList(true, true, true, true);
    }
}
