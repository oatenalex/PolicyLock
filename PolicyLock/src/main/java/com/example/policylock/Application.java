package com.example.policylock;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.GregorianCalendar;

public class Application {

    public String name;

    private GregorianCalendar dateLastModified;
    private String path;
    private File icon;
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

    public void setIcon(File icon) {
        this.icon = icon;
    }

    public File getIcon() {
        if (this.icon == null) {
            return new File("Images/DefaultIcon.icns");
        }
        return this.icon;
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
}
