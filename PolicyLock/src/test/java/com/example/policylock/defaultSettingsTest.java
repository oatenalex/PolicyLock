package com.example.policylock;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class defaultSettingsTest {

    private static notificationSettings settings;
    private static logSettings logSettings;

    @Test
    void defaultLogSetting() {
        assertEquals("Standard", logSettings.getInstance().getLogLevel());
    }
    @Test
    void defaultEmail() { //Tests for default settings
        assertEquals("", settings.getInstance().getEmailAddress());
    }

    @Test
    void defaultNotificationType() { //Tests default notification types
        List<Boolean> defaultSettings = Arrays.asList(false, true);
        assertEquals(defaultSettings, settings.getInstance().getNotificationTypeSettings());
    }

    @Test
    void defaultNotificationLevel() {//Tests default notification levels
        List<Boolean> defaultSettings = Arrays.asList(true, true, true, false);
        assertEquals(defaultSettings, settings.getInstance().getNotificationLevelSettings());
    }
}