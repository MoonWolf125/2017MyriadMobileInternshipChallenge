package com.example.kl7304qk.dahnkyfinal.API;

import android.util.Log;

import com.example.kl7304qk.dahnkyfinal.model.Character;
import com.example.kl7304qk.dahnkyfinal.model.Kingdom;
import com.example.kl7304qk.dahnkyfinal.model.Quest;
import com.example.kl7304qk.dahnkyfinal.model.Subscriber;

import java.io.IOException;
import java.util.List;

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
    private SubscriberService subscriberService;

    public ApiService() {
        kingdomService = retrofit.create(KingdomService.class);
        questService = retrofit.create(QuestService.class);
        characterService = retrofit.create(CharacterService.class);
        subscriberService = retrofit.create(SubscriberService.class);
    }

    public List<Kingdom> syncGetKingdoms() {
        try {
            return kingdomService.getKingdoms().execute().body();
        }
        catch (IOException e) {
            Log.d("ERROR : syncGetKingdoms", e.toString());
            return null;
        }
    }

    public Kingdom syncGetKingdom(int kingdomID) {
        try {
            return kingdomService.getKingdom(kingdomID).execute().body();
        }
        catch (IOException e) {
            Log.d("ERROR : syncGetKingdom", e.toString());
            return null;
        }
    }

    public List<Quest> syncGetQuests(int kingdomID) {
        try {
            return questService.getQuests(kingdomID).execute().body();
        }
        catch (IOException e) {
            Log.d("ERROR : syncGetQuests", e.toString());
            return null;
        }
    }

    public Quest syncGetQuest(int kingdomID, int questID) {
        try {
            return questService.getQuest(kingdomID, questID).execute().body();
        }
        catch (IOException e) {
            Log.d("ERROR : syncGetQuest", e.toString());
            return null;
        }
    }

    public Character syncGetCharacter(int characterID) {
        try {
            return characterService.getCharacter(characterID).execute().body();
        }
        catch (IOException e) {
            Log.d("ERROR : syncGetChar", e.toString());
            return null;
        }
    }

    public void getKingdoms(Callback<List<Kingdom>> callback) {
        kingdomService.getKingdoms().enqueue(callback);
    }

    public void getKingdom(int kingdomID, Callback<Kingdom> callback) {
        kingdomService.getKingdom(kingdomID).enqueue(callback);
    }

    public void getQuests(int kingdomID, Callback<List<Quest>> callback) {
        questService.getQuests(kingdomID).enqueue(callback);
    }

    public void subscribe(String email, Callback<Subscriber> callback) {
        subscriberService.subscribe(email).enqueue(callback);
    }
}
