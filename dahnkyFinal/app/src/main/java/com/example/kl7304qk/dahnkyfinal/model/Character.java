package com.example.kl7304qk.dahnkyfinal.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Kyle on 12/8/2017.
 */

public class Character {
    @SerializedName("id")
    private final int id;
    @SerializedName("name")
    private final String name;
    @SerializedName("image")
    private final String image;
    @SerializedName("profession")
    private final String profession;
    @SerializedName("bio")
    private final String bio;

    public Character(int id, String name, String image, String profession, String bio) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.profession = profession;
        this.bio = bio;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getImage() {
        return image;
    }

    public String getProfession() {
        return profession;
    }

    public String getBio() {
        return bio;
    }
}
