package com.example.kl7304qk.dahnkyfinal.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Kyle on 12/8/2017.
 */

public class Kingdom {
    @SerializedName("id")
    private int id;
    @SerializedName("name")
    private String name;
    @SerializedName("image")
    private String image;
    @SerializedName("climate")
    private String climate;
    @SerializedName("population")
    private int population;

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
