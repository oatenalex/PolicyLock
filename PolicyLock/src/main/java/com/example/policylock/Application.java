package com.example.policylock;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

public class Application {

    public String name;

    private GregorianCalendar dateLastModified;

    public Application(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDateLastModified(GregorianCalendar dateInstalled) {
        this.dateLastModified = dateInstalled;
    }

    public String getLastModifiedString() {
        SimpleDateFormat fmt = new SimpleDateFormat("MMM dd, yyyy");
        return fmt.format(dateLastModified.getTime());
    }

    public String getButtonFormat() {
        StringBuilder formatted = new StringBuilder();
        formatted.append("Name: ").append(this.name);
        for (int i = 0; i < 30 - this.name.length(); i++) {
            formatted.append(" ");
        }
        formatted.append(" Last Modified: " + this.getLastModifiedString());
        return formatted.toString();
    }
}
