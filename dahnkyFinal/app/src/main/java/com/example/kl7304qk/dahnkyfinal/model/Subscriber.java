package com.example.kl7304qk.dahnkyfinal.model;

/**
 * Created by Kyle on 12/8/2017.
 */

public class Subscriber {
    private final String name;
    private final String email;

    public Subscriber(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
}
