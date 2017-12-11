package com.example.kl7304qk.dahnkyfinal.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import com.example.kl7304qk.dahnkyfinal.API.ApiService;
import com.example.kl7304qk.dahnkyfinal.API.KingdomService;
import com.example.kl7304qk.dahnkyfinal.R;
import com.example.kl7304qk.dahnkyfinal.adapter.KingdomFragment;
import com.example.kl7304qk.dahnkyfinal.adapter.KingdomPagerAdapter;
import com.example.kl7304qk.dahnkyfinal.model.Kingdom;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Kyle on 12/9/2017.
 */

public class KingdomDetailActivity extends AppCompatActivity {
    private ApiService apiService;
    private KingdomPagerAdapter kingdomPagerAdapter;
    private ViewPager kingdom;
    private static ArrayList<Kingdom> kingdoms;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kingdoms);
        apiService = new ApiService();
        kingdom = (ViewPager) findViewById(R.id.kingdom);

        displayKingdom(getIntent().getExtras());
    }

    private void displayKingdom(final Bundle bundle) {
        apiService.getKingdom(bundle.getInt("position"), new Callback<Kingdom>() {
            @Override
            public void onResponse(Call<Kingdom> call, Response<Kingdom> response) {
                kingdomPagerAdapter = new KingdomPagerAdapter(bundle.getInt("position"),
                        response.body(), KingdomDetailActivity.this, getSupportFragmentManager());
                kingdom.setAdapter(kingdomPagerAdapter);
                kingdom.setCurrentItem(bundle.getInt("position"));
                setTitle(response.body().getName());
            }

            @Override
            public void onFailure(Call<Kingdom> call, Throwable t) {

            }
        });
    }
}
