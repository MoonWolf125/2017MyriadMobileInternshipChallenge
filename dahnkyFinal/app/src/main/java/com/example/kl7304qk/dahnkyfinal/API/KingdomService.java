package com.example.kl7304qk.dahnkyfinal.API;

import com.example.kl7304qk.dahnkyfinal.model.Kingdom;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Kyle on 12/8/2017.
 */

interface KingdomService {
    @GET("v1/kingdoms/")
    Call<List<Kingdom>> getKingdoms();

    @GET("v1/kingdoms/{kingdomID}/")
    Call<Kingdom> getKingdom(@Path("kingdomID") int kingdomID);
}
