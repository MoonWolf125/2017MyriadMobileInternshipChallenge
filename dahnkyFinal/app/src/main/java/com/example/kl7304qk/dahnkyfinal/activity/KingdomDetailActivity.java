package com.example.kl7304qk.dahnkyfinal.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import com.example.kl7304qk.dahnkyfinal.API.ApiService;
import com.example.kl7304qk.dahnkyfinal.R;
import com.example.kl7304qk.dahnkyfinal.adapter.KingdomPagerAdapter;
import com.example.kl7304qk.dahnkyfinal.model.Kingdom;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Kyle on 12/9/2017.
 */

public class KingdomDetailActivity extends AppCompatActivity {
    private ApiService apiService;
    private KingdomPagerAdapter kingdomPagerAdapter;
    private ViewPager kingdom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kingdoms);
        apiService = new ApiService();
        kingdom = (ViewPager) findViewById(R.id.kingdom);

        displayKingdom(getIntent().getExtras());
    }

    private void displayKingdom(final Bundle bundle) {
        apiService.getKingdoms(new Callback<List<Kingdom>>() {
            @Override
            public void onResponse(Call<List<Kingdom>> call, Response<List<Kingdom>> response) {
                kingdomPagerAdapter = new KingdomPagerAdapter(bundle.getInt("position"),
                        response.body(), KingdomDetailActivity.this, getSupportFragmentManager());
                kingdom.setAdapter(kingdomPagerAdapter);
                kingdom.setCurrentItem(bundle.getInt("position"));
            }

            @Override
            public void onFailure(Call<List<Kingdom>> call, Throwable t) {
                Toast.makeText(KingdomDetailActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
