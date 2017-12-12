package com.example.kl7304qk.dahnkyfinal.activity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;

import com.example.kl7304qk.dahnkyfinal.API.ApiService;
import com.example.kl7304qk.dahnkyfinal.R;
import com.example.kl7304qk.dahnkyfinal.adapter.QuestPagerAdapter;
import com.example.kl7304qk.dahnkyfinal.model.Character;
import com.example.kl7304qk.dahnkyfinal.model.Quest;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kyle on 12/10/2017.
 */

public class QuestDetailActivity extends AppCompatActivity {
    private ApiService apiService;
    private ViewPager quest;
    private List<Quest> quests;
    private final ArrayList<Character> characters = new ArrayList<>();
    private Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quests);
        apiService = new ApiService();
        quest = (ViewPager) findViewById(R.id.quest);
        bundle = getIntent().getExtras();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Quests getFull = new Quests();
        getFull.execute();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public class Quests extends AsyncTask<Void, Integer, Boolean> {

        Quests() {
        }

        @Override
        protected Boolean doInBackground(Void... voids) {
            try {
                quests = apiService.syncGetQuests(bundle.getInt("kingdom"));
                Log.d("TEST", Integer.toString(quests.get(0).getCharacter().getId()));
                for (int i = 0; i < quests.size(); i++)
                    characters.add(apiService.syncGetCharacter(quests.get(i).getCharacter().getId()));
            } catch (Exception e) {
                Log.d("TEST", e.toString());
                return false;
            }
            return true;
        }

        @Override
        protected void onPostExecute(final Boolean result) {
            if (result) {
                QuestPagerAdapter questPagerAdapter = new QuestPagerAdapter(quests, characters, getSupportFragmentManager());
                quest.setAdapter(questPagerAdapter);
                quest.setCurrentItem(bundle.getInt("position"));
                setTitle(quests.get(bundle.getInt("position")).getName());
                quest.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
                    @Override
                    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

                    }

                    @Override
                    public void onPageSelected(int position) {
                        setTitle(quests.get(position).getName());
                    }

                    @Override
                    public void onPageScrollStateChanged(int state) {

                    }
                });
            }
        }
    }
}
