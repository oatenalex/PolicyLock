package com.example.policylock;

public class LogSettings {
    private static LogSettings instance;
    private String logLevel;

    private LogSettings(){
        logLevel = "Standard";  //Log settings intially set to standard
    }

    public static synchronized LogSettings getInstance()
    {
        if (instance == null)
            instance = new LogSettings();
        return instance;
    }

    public String getLogLevel(){
        return logLevel;
    }

    public String setLogSettingsVerbose(){
        logLevel = "Verbose";
        return "Log Setting successfully set to -Verbose-";
    }

    public String setLogSettingsStandard(){
        logLevel = "Standard";
        return "Log Setting successfully set to -Standard-";
    }

    public String setLogSettingsMinimal(){
        logLevel = "Minimal";
        return "Log Setting successfully set to -Minimal-";
    }
}
