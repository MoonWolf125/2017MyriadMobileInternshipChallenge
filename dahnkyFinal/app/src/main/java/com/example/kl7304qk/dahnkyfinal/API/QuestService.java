package com.example.kl7304qk.dahnkyfinal.API;

import com.example.kl7304qk.dahnkyfinal.model.Quest;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Kyle on 12/8/2017.
 */

public interface QuestService {
    @GET("kingdoms/{kingdomID}/quests/")
    Call<Quest> getQuests(@Path("kingdomID") String kingdomID);

    @GET("kingdoms/{kingdomID}/quests/{questID}/")
    Call<Quest> getQuest(@Path("kingdomID") String kingdomID, @Path("questID") String questID);
}
