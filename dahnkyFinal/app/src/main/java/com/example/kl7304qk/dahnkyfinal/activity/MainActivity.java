package com.example.kl7304qk.dahnkyfinal.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.kl7304qk.dahnkyfinal.API.ApiService;
import com.example.kl7304qk.dahnkyfinal.R;
import com.example.kl7304qk.dahnkyfinal.adapter.KingdomsAdapter;
import com.example.kl7304qk.dahnkyfinal.model.Kingdom;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    ApiService apiService;

    RecyclerView kingdoms;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        apiService = new ApiService();
        kingdoms = (RecyclerView) findViewById(R.id.kingdoms);
        kingdoms.setLayoutManager(new LinearLayoutManager(this));

        displayKingdoms();
    }

    private void displayKingdoms() {
        apiService.getKingdoms(new Callback<List<Kingdom>>() {
            @Override
            public void onResponse(Call<List<Kingdom>> call, Response<List<Kingdom>> response) {
                kingdoms.setAdapter(new KingdomsAdapter(response.body(), getApplicationContext()));
            }

            @Override
            public void onFailure(Call<List<Kingdom>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "ERROR", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
