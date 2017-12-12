package com.example.kl7304qk.dahnkyfinal.API;

import com.example.kl7304qk.dahnkyfinal.model.Quest;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Kyle on 12/8/2017.
 */

interface QuestService {
    @GET("kingdoms/{kingdomID}/quests/")
    Call<List<Quest>> getQuests(@Path("kingdomID") int kingdomID);

    @GET("kingdoms/{kingdomID}/quests/{questID}/")
    Call<Quest> getQuest(@Path("kingdomID") int kingdomID, @Path("questID") int questID);
}
