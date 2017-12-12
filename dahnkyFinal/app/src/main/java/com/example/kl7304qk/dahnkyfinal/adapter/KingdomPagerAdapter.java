package com.example.kl7304qk.dahnkyfinal.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.kl7304qk.dahnkyfinal.model.Kingdom;

import java.util.List;

/**
 * Created by Kyle on 12/9/2017.
 */

public class KingdomPagerAdapter extends FragmentPagerAdapter {
    private final List<Kingdom> kingdoms;

    public KingdomPagerAdapter(List<Kingdom> kingdoms, FragmentManager fm) {
        super(fm);
        this.kingdoms = kingdoms;
    }

    @Override
    public Fragment getItem(int position) {
        return KingdomFragment.newInstance(kingdoms.get(position));
    }

    @Override
    public int getCount() {
        return kingdoms.size();
    }
}
