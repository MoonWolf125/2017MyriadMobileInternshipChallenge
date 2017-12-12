package com.example.kl7304qk.dahnkyfinal.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.kl7304qk.dahnkyfinal.model.Character;
import com.example.kl7304qk.dahnkyfinal.model.Quest;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kyle on 12/10/2017.
 */

public class QuestPagerAdapter extends FragmentPagerAdapter {
    private final List<Quest> quests;
    private final ArrayList<Character> characters;

    public QuestPagerAdapter(List<Quest> quests, ArrayList<Character> characters, FragmentManager fm) {
        super(fm);
        this.quests = quests;
        this.characters = characters;
    }

    @Override
    public Fragment getItem(int position) {
        return QuestFragment.newInstance(quests.get(position), characters.get(position));
    }

    @Override
    public int getCount() {
        return quests.size();
    }
}
