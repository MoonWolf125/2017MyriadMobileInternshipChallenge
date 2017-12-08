package com.example.kl7304qk.dahnkyfinal.API;

import com.example.kl7304qk.dahnkyfinal.model.Character;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Kyle on 12/8/2017.
 */

public interface CharacterService {
    @GET("characters/{characterID}/")
    Call<Character> getCharacter(@Path("characterID") String characterID);
}
