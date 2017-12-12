package com.example.kl7304qk.dahnkyfinal.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Kyle on 12/8/2017.
 */

public class Kingdom {
    @SerializedName("id")
    private final int id;
    @SerializedName("name")
    private final String name;
    @SerializedName("image")
    private final String image;
    @SerializedName("climate")
    private final String climate;
    @SerializedName("population")
    private final int population;

    public Kingdom(int id, String name, String image, String climate, int population) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.climate = climate;
        this.population = population;
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

    public String getClimate() {
        return climate;
    }

    public int getPopulation() {
        return population;
    }
}
