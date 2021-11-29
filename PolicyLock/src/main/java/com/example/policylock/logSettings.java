package com.example.policylock;

public class logSettings {
    private static logSettings instance;
    private String logLevel;

    private logSettings(){
        logLevel = "standard";  //Log settings intially set to standard
    }

    public static synchronized logSettings getInstance()
    {
        if (instance == null)
            instance = new logSettings();
        return instance;
    }

    public String getLogLevel(){
        return logLevel;
    }

    public String setLogSettingsVerbose(){
        logLevel = "verbose";
        return "Log Setting set to -Verbose-";
    }

    public String setLogSettingsStandard(){
        logLevel = "standard";
        return "Log Setting set to -Standard-";
    }

    public String setLogSettingsMinimal(){
        logLevel = "minimal";
        return "Log Setting set to -Minimal-";
    }
}
