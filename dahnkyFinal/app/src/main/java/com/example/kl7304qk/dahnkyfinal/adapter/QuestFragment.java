package com.example.kl7304qk.dahnkyfinal.adapter;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.kl7304qk.dahnkyfinal.R;
import com.example.kl7304qk.dahnkyfinal.model.Character;
import com.example.kl7304qk.dahnkyfinal.model.Quest;

/**
 * Created by Kyle on 12/10/2017.
 */

public class QuestFragment extends Fragment {

    public QuestFragment() {
    }

    public static QuestFragment newInstance(Quest quest, Character character) {
        QuestFragment fragment = new QuestFragment();
        Bundle args = new Bundle();
        args.putString("name", quest.getName());
        args.putString("image", quest.getImage());
        args.putString("description", quest.getDescription());
        args.putString("characterImage", character.getImage());
        args.putString("characterName", character.getName());
        args.putString("characterProfession", character.getProfession());
        args.putString("characterBio", character.getBio());
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup group, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.quest_fragment, group, false);
        ImageView image = view.findViewById(R.id.image);
        TextView description = view.findViewById(R.id.description);
        ImageView characterImage = view.findViewById(R.id.characterImage);
        TextView characterName = view.findViewById(R.id.characterName);
        TextView characterDescription = view.findViewById(R.id.characterDescription);

        Glide.with(getContext()).load(getArguments().getString("image")).into(image);
        description.setText(getArguments().getString("description"));
        Glide.with(getContext()).load(getArguments().getString("characterImage")).apply(RequestOptions.circleCropTransform()).into(characterImage);
        characterName.setText(getArguments().getString("characterName"));
        characterDescription.setText(getArguments().getString("characterProfession") + "\n" + getArguments().getString("characterBio"));

        return view;
    }
}
