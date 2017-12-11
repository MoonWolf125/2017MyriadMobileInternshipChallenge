package com.example.kl7304qk.dahnkyfinal.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.Log;
import android.widget.Toast;

import com.example.kl7304qk.dahnkyfinal.API.ApiService;
import com.example.kl7304qk.dahnkyfinal.activity.MainActivity;
import com.example.kl7304qk.dahnkyfinal.model.Kingdom;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Kyle on 12/9/2017.
 */

public class KingdomPagerAdapter extends FragmentPagerAdapter {
    private int position;
    private ApiService apiService;
    private Context context;
    private List<Kingdom> kingdoms;

    public static void addFragment(KingdomFragment kingdomFragment) {
        Log.d("GET ADD", "X");
    }

    public KingdomPagerAdapter(int position, List<Kingdom> kingdoms, Context context, FragmentManager fm) {
        super(fm);
        this.position = position;
        this.kingdoms = kingdoms;
        this.context = context;
        this.apiService = new ApiService();
    }

    @Override
    public Fragment getItem(int position) {
        Log.d("GET ITEM", Integer.toString(position));
        Toast.makeText(context, Integer.toString(position), Toast.LENGTH_SHORT).show();
        return KingdomFragment.newInstance(kingdoms.get(position));
    }

    @Override
    public int getCount() {
        return kingdoms.size();
    }
}
