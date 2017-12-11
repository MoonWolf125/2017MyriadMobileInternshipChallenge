package com.example.kl7304qk.dahnkyfinal.adapter;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
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
import com.example.kl7304qk.dahnkyfinal.model.Quest;

import java.util.List;

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

    public static KingdomFragment newInstance(Kingdom kingdom) {
        Log.d("GET FRAG", "X");
        KingdomFragment fragment = new KingdomFragment();
        Bundle args = new Bundle();
        args.putInt("id", kingdom.getId());
        args.putString("name", kingdom.getName());
        args.putString("image", kingdom.getImage());
        args.putString("climate", kingdom.getClimate());
        args.putInt("population", kingdom.getPopulation());
        fragment.setArguments(args);
        return fragment;
    }

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
        quests = (RecyclerView) view.findViewById(R.id.quests);
        quests.setLayoutManager(new LinearLayoutManager(getContext()));

        Glide.with(this).load(getArguments().getString("image")).into(image);
        climate.setText(getArguments().getString("climate"));
        population.setText(Integer.toString(getArguments().getInt("population")));

        apiService.getQuests(getArguments().getInt("id"), new Callback<List<Quest>>() {
            @Override
            public void onResponse(Call<List<Quest>> call, Response<List<Quest>> response) {
                quests.setAdapter(new QuestsAdapter(response.body(), getArguments().getInt("id"), getContext()));

            }

            @Override
            public void onFailure(Call<List<Quest>> call, Throwable t) {

            }
        });

        return view;
    }
}
