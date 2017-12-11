package com.example.kl7304qk.dahnkyfinal.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Kyle on 12/8/2017.
 */

public class Quest {
    @SerializedName("id")
    private int id;
    @SerializedName("name")
    private String name;
    @SerializedName("description")
    private String description;
    @SerializedName("image")
    private String image;
    @SerializedName("giver")
    private Character character;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getImage() {
        return image;
    }

    public Character getCharacter() {
        return character;
    }
}
