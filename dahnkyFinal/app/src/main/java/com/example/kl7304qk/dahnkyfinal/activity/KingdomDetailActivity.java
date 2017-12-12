package com.example.kl7304qk.dahnkyfinal.activity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;

import com.example.kl7304qk.dahnkyfinal.API.ApiService;
import com.example.kl7304qk.dahnkyfinal.R;
import com.example.kl7304qk.dahnkyfinal.adapter.KingdomPagerAdapter;
import com.example.kl7304qk.dahnkyfinal.model.Kingdom;

import java.util.List;

/**
 * Created by Kyle on 12/9/2017.
 */

public class KingdomDetailActivity extends AppCompatActivity {
    private ViewPager kingdom;
    private List<Kingdom> kingdoms;
    private Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kingdoms);
        kingdom = (ViewPager) findViewById(R.id.kingdom);
        bundle = getIntent().getExtras();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Kingdoms getFull = new Kingdoms();
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

    public class Kingdoms extends AsyncTask<Void, Integer, Boolean> {

        Kingdoms() {}

        @Override
        protected Boolean doInBackground(Void... voids) {
            ApiService apiService = new ApiService();
            try {
                kingdoms = apiService.syncGetKingdoms();
                for (int i = 0; i < kingdoms.size(); i++)
                    kingdoms.set(i, apiService.syncGetKingdom(i + 1));
            }
            catch (Exception e) {
                Log.d("TEST", e.toString());
                return false;
            }
            return true;
        }

        @Override
        protected void onPostExecute(final Boolean result) {
            if (result) {
                for (int i = 0; i < kingdoms.size(); i++)
                    Log.d("DATA", kingdoms.get(i).getClimate() + " " + kingdoms.get(i).getPopulation());
                KingdomPagerAdapter kingdomPagerAdapter = new KingdomPagerAdapter(kingdoms, getSupportFragmentManager());
                kingdom.setAdapter(kingdomPagerAdapter);
                kingdom.setCurrentItem(bundle.getInt("position") - 1);
                setTitle(kingdoms.get(bundle.getInt("position") - 1).getName());
                kingdom.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
                    @Override
                    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

                    }

                    @Override
                    public void onPageSelected(int position) {
                        setTitle(kingdoms.get(position).getName());
                    }

                    @Override
                    public void onPageScrollStateChanged(int state) {

                    }
                });
            }
        }
    }
}
