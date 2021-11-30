package com.example.policylock;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class NotificationSettings {
    private static NotificationSettings instance;
    private List<Boolean> notificationLevel = Arrays.asList(true, true, true, false); //Critical, warning, notice, info
    private List<Boolean> notificationType = Arrays.asList(false, true); //Email only, Email and push
    private String emailAddress = "";

    private NotificationSettings(){
    }

    public static synchronized NotificationSettings getInstance()
    {
        if (instance == null)
            instance = new NotificationSettings();
        return instance;
    }

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
