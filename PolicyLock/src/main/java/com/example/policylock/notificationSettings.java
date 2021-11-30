package com.example.policylock;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class notificationSettings {
    private static notificationSettings instance;
    private static List<Boolean> notificationLevel = new ArrayList<>();
    private static List<Boolean> notificationType = new ArrayList<>();
    private String emailAddress;

    private notificationSettings(){
        notificationLevel = Arrays.asList(true, true, true, false); //Critical, warning, notice, info
        notificationType = Arrays.asList(false, true); //Email only, Email and push
        emailAddress = "";
    }

    public static synchronized notificationSettings getInstance()
    {
        if (instance == null)
            instance = new notificationSettings();
        return instance;
    }

    public List<Boolean> getNotificationLevel() { return notificationLevel; }

    //Email Address Methods
    public void setEmailAddress(String email){
        this.emailAddress = email;
    }

    public String getEmailAddress(){return this.emailAddress;}

    //Notification Types Methods
    public void setEmailOnlyNotifications() {
        notificationType = Arrays.asList(true, false);
    }

    public void setEmailPushNotifications() {
        notificationType = Arrays.asList(false, true);
    }

    public List<Boolean> getNotificationTypeSettings(){
        return notificationType;
    }

    //Notification Level Settings
    public List<Boolean> getNotificationLevelSettings(){
        return notificationLevel;
    }

    public void setAllNotifications(boolean critical, boolean warning, boolean notice, boolean info){
        notificationLevel = Arrays.asList(critical, warning, notice, info);
    }
}
