package com.example.policylock;
import java.io.File;
import java.text.SimpleDateFormat;
import java.time.Period;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Application {

    public String name;

    private String path;
    private GregorianCalendar dateLastModified;

    private ArrayList<Permission> permissions;

    public Application(String name) {
        this.name = name;
        this.permissions = new ArrayList<>();
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

    public void setPermissions(ArrayList<Permission> newPerms) {
        this.permissions.clear();
        for (Permission p : newPerms) {
            this.permissions.add(p);
        }
    }

    public ArrayList<Permission> getPermissions() {
        return this.permissions;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getPath() {
        return this.path;
    }
}
