package com.example.kl7304qk.dahnkyfinal.API;

import com.example.kl7304qk.dahnkyfinal.model.Kingdom;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Kyle on 12/8/2017.
 */

public interface KingdomService {
    @GET("kingdoms/")
    Call<Kingdom> getKingdoms();

    @GET("kingdoms/{kingdomID}/")
    Call<Kingdom> getKingdom(@Path("kingdomID") String kingdomID);
}
