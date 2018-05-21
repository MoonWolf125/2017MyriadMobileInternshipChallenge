package com.example.kl7304qk.dahnkyfinal.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.kl7304qk.dahnkyfinal.API.ApiService;
import com.example.kl7304qk.dahnkyfinal.R;
import com.example.kl7304qk.dahnkyfinal.adapter.KingdomsAdapter;
import com.example.kl7304qk.dahnkyfinal.model.Kingdom;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.kl7304qk.dahnkyfinal.activity.LoginActivity.getEmail;
import static com.example.kl7304qk.dahnkyfinal.activity.LoginActivity.isRegistered;

public class MainActivity extends AppCompatActivity {
    private ApiService apiService;

    private RecyclerView kingdoms;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (!isRegistered(this)) {
            Intent login = new Intent(this, LoginActivity.class);
            startActivity(login);
            finish();
        }
        else
            setTitle(getEmail(this));
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
                kingdoms.setAdapter(new KingdomsAdapter(response.body(), MainActivity.this));
            }

            @Override
            public void onFailure(Call<List<Kingdom>> call, Throwable t) {
                Log.d("Kingdoms Call", t.toString());
                Toast.makeText(MainActivity.this, "Kingdoms Not Loaded", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.logout: {
                int tmp = LoginActivity.logout(this);
                if (tmp == 1) {
                    Toast.makeText(this, "Logged out", Toast.LENGTH_SHORT).show();
                    Intent login = new Intent(this, LoginActivity.class);
                    startActivity(login);
                    finish();
                }
                else
                    Toast.makeText(this, "ERROR", Toast.LENGTH_SHORT).show();
            }
            return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
