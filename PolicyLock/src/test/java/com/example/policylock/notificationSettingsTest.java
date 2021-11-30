package com.example.policylock;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class notificationSettingsTest {

    private static notificationSettings settings;

    @Test
    void createInstance() {assertNotNull(notificationSettings.getInstance()); }

    @Test
    void getInstance() { assertNotNull(settings.getInstance()); }

    @Test
    void setEmailAddress() {
        settings.getInstance().setEmailAddress("email@gmail.com");
        assertEquals("email@gmail.com", settings.getInstance().getEmailAddress());
    }

    @Test
    void setEmailOnlyNotifications() {
        settings.getInstance().setEmailOnlyNotifications();
        List<Boolean> emailOnlySettings = Arrays.asList(true, false);
        assertEquals(emailOnlySettings, settings.getInstance().getNotificationTypeSettings());
    }

    @Test
    void setEmailPushNotifications() {
        settings.getInstance().setEmailPushNotifications();
        List<Boolean> emailPushSettings = Arrays.asList(false, true);
        assertEquals(emailPushSettings, settings.getInstance().getNotificationTypeSettings());
    }

    @Test
    void setAllNotifications() {
        settings.getInstance().setAllNotifications(true, true, false, false);
        List<Boolean> changedSettings = Arrays.asList(true, true, false, false);
        assertEquals(changedSettings, settings.getInstance().getNotificationLevelSettings());
    }

    @Test
    void setAllNotifications2() {
        settings.getInstance().setAllNotifications(true, true, true, true);
        List<Boolean> changedSettings = Arrays.asList(true, true, true, true);
        assertEquals(changedSettings, settings.getInstance().getNotificationLevelSettings());
    }
}