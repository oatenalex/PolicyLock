package com.example.policylock;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class logSettingsTest {

    private static LogSettings settings;
    private String message;

    @Test
    void getInstance() {
        assertNotNull(settings.getInstance());
    }

    @Test
    void getLogLevel() {
        //checks that the logging level/mode is set to standard if not specified
        assertEquals("Standard", settings.getInstance().getLogLevel());
    }

    //Verbose Log Setting Tests
    @Test
    void setLogSettingsVerboseReturn() {
        message = settings.getInstance().setLogSettingsVerbose();
        assertEquals("Log Setting successfully set to -Verbose-", message);
    }

    @Test
    void setLogSettingsVerbose() {
        settings.getInstance().setLogSettingsVerbose();
        assertEquals("Verbose", settings.getInstance().getLogLevel());
    }

    //Standard Log Setting Tests
    @Test
    void setLogSettingsStandardReturn(){
        message = settings.getInstance().setLogSettingsStandard();
        assertEquals("Log Setting successfully set to -Standard-", message);
    }
    @Test
    void setLogSettingsStandard() {
        settings.getInstance().setLogSettingsStandard();
        assertEquals("Standard", settings.getInstance().getLogLevel());
    }

    //Minimal Log Setting Tests
    @Test
    void setLogSettingsMinimalReturn(){
        message = settings.getInstance().setLogSettingsMinimal();
        assertEquals("Log Setting successfully set to -Minimal-", message);
    }
    @Test
    void setLogSettingsMinimal() {
        settings.getInstance().setLogSettingsMinimal();
        assertEquals("Minimal", settings.getInstance().getLogLevel());
    }
}