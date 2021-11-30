package com.example.policylock;

import java.util.ArrayList;
import java.util.Arrays;

public class Device {
    public String name;
    public ArrayList<Application> applications;

    public Device(String name) {
        this.name = name;
        applications = new ArrayList<>();
    }

    public void setNewName(String name) {
        this.name = name;
    }

    public void addApplication(Application application) {
        applications.add(application);
    }

    public void addMultipleApplications(ArrayList<Application> applications) {
        this.applications.addAll(applications);
    }

    public ArrayList<Application> getApplications() {
        return this.applications;
    }
}
