package com.example.kl7304qk.dahnkyfinal.adapter;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.kl7304qk.dahnkyfinal.API.ApiService;
import com.example.kl7304qk.dahnkyfinal.R;
import com.example.kl7304qk.dahnkyfinal.model.Kingdom;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Kyle on 12/9/2017.
 */

public class KingdomFragment extends Fragment {
    private ApiService apiService;
    private Kingdom kingdom;

    private ImageView image;
    private TextView climate;
    private TextView population;

    private RecyclerView quests;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        apiService = new ApiService();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup group, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.kingdom_fragment, group, false);

        image = (ImageView) view.findViewById(R.id.image);
        climate = (TextView) view.findViewById(R.id.climate);
        population = (TextView) view.findViewById(R.id.population);

        Glide.with(this).load(kingdom.getImage()).into(image);
        climate.setText(kingdom.getClimate());
        population.setText(Integer.toString(kingdom.getPopulation()));

        return view;
    }

    protected void setInstance(Kingdom kingdom) {
        this.kingdom = kingdom;
    }
}
