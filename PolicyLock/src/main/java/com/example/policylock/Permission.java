package com.example.policylock;

public class Permission {

    public String name;
    public String description;

    public Permission(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

}

