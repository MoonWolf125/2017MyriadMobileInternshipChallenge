package com.example.kl7304qk.dahnkyfinal.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.kl7304qk.dahnkyfinal.model.Quest;

import java.util.List;

/**
 * Created by Kyle on 12/10/2017.
 */

public class QuestPagerAdapter extends FragmentPagerAdapter {
    private int position;
    private List<Quest> quests;

    public QuestPagerAdapter(int position, List<Quest> quests, FragmentManager fm) {
        super(fm);
        this.position = position;
        this.quests = quests;
    }

    @Override
    public Fragment getItem(int position) {
        return QuestFragment.newInstance(quests.get(position));
    }

    @Override
    public int getCount() {
        return quests.size();
    }
}
