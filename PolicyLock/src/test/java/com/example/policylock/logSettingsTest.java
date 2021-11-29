package com.example.policylock;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class logSettingsTest {

    private logSettings settings;
    private String message;

    @Test
    void getInstance() {
        assertNotNull(settings.getInstance());
    }

    @Test
    void getLogLevel() {
        //checks that the logging level/mode is set to standard if not specified
        assertEquals("standard", settings.getInstance().getLogLevel());
    }

    //Verbose Log Setting Tests
    @Test
    void setLogSettingsVerboseReturn() {
        message = settings.getInstance().setLogSettingsVerbose();
        assertEquals("Log Setting set to -Verbose-", message);
    }

    @Test
    void setLogSettingsVerbose() {
        assertEquals("verbose", settings.getInstance().getLogLevel());
    }

    //Standard Log Setting Tests
    @Test
    void setLogSettingsStandardReturn(){
        message = settings.getInstance().setLogSettingsStandard();
        assertEquals("Log Setting set to -Standard-", message);
    }
    @Test
    void setLogSettingsStandard() {
        assertEquals("standard", settings.getInstance().getLogLevel());
    }

    //Minimal Log Setting Tests
    @Test
    void setLogSettingsMinimalReturn(){
        message = settings.getInstance().setLogSettingsMinimal();
        assertEquals("Log Setting set to -Minimal-", message);
    }
    @Test
    void setLogSettingsMinimal() {
        assertEquals("minimal", settings.getInstance().getLogLevel());
    }
}