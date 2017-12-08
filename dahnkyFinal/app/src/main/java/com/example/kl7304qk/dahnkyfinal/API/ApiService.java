package com.example.kl7304qk.dahnkyfinal.API;

import com.example.kl7304qk.dahnkyfinal.model.Character;
import com.example.kl7304qk.dahnkyfinal.model.Kingdom;
import com.example.kl7304qk.dahnkyfinal.model.Quest;

import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Kyle on 12/8/2017.
 */

public class ApiService {
    private Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://challenge2015.myriadapps.com/api/v1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    private KingdomService kingdomService;
    private QuestService questService;
    private CharacterService characterService;

    public ApiService() {
        kingdomService = retrofit.create(KingdomService.class);
        questService = retrofit.create(QuestService.class);
        characterService = retrofit.create(CharacterService.class);
    }

    public void getKingdoms(Callback<Kingdom> callback) {
        kingdomService.getKingdoms().enqueue(callback);
    }

    public void getKingdom(String kingdomID, Callback<Kingdom> callback) {
        kingdomService.getKingdom(kingdomID).enqueue(callback);
    }

    public void getQuests(String kingdomID, Callback<Quest> callback) {
        questService.getQuests(kingdomID).enqueue(callback);
    }

    public void getQuest(String kingdomID, String questID, Callback<Quest> callback) {
        questService.getQuest(kingdomID, questID).enqueue(callback);
    }

    public void getCharacter(String characterID, Callback<Character> callback) {
        characterService.getCharacter(characterID).enqueue(callback);
    }
}
