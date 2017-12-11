package com.example.kl7304qk.dahnkyfinal.activity;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.example.kl7304qk.dahnkyfinal.API.ApiService;
import com.example.kl7304qk.dahnkyfinal.R;
import com.example.kl7304qk.dahnkyfinal.adapter.QuestPagerAdapter;
import com.example.kl7304qk.dahnkyfinal.model.Quest;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Kyle on 12/10/2017.
 */

public class QuestDetailActivity extends AppCompatActivity {
    ApiService apiService;
    ViewPager quest;
    QuestPagerAdapter questPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quests);
        apiService = new ApiService();
        quest = (ViewPager) findViewById(R.id.quest);

        displayQuest(getIntent().getExtras());
    }

    private void displayQuest(final Bundle extras) {
        apiService.getQuests(extras.getInt("kingdom"), new Callback<List<Quest>>() {
            @Override
            public void onResponse(Call<List<Quest>> call, Response<List<Quest>> response) {
                questPagerAdapter = new QuestPagerAdapter(extras.getInt("position"), response.body(), getSupportFragmentManager());
                quest.setAdapter(questPagerAdapter);
                quest.setCurrentItem(extras.getInt("position"));
            }

            @Override
            public void onFailure(Call<List<Quest>> call, Throwable t) {

            }
        });
    }
}
