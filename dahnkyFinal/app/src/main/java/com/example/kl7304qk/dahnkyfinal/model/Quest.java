package com.example.kl7304qk.dahnkyfinal.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Kyle on 12/8/2017.
 */

public class Quest {
    @SerializedName("id")
    private final int id;
    @SerializedName("name")
    private final String name;
    @SerializedName("description")
    private final String description;
    @SerializedName("image")
    private final String image;
    @SerializedName("giver")
    private final Character character;

    public Quest(int id, String name, String description, String image, Character character) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.image = image;
        this.character = character;
    }

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
