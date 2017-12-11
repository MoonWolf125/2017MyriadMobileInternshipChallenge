package com.example.kl7304qk.dahnkyfinal.adapter;

import android.os.Bundle;
import android.support.v4.app.BundleCompat;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.kl7304qk.dahnkyfinal.API.ApiService;
import com.example.kl7304qk.dahnkyfinal.R;
import com.example.kl7304qk.dahnkyfinal.model.Quest;

/**
 * Created by Kyle on 12/10/2017.
 */

public class QuestFragment extends Fragment {
    ApiService apiService;

    private ImageView image;
    private TextView description;
    private ImageView characterImage;
    private TextView characterName;
    private TextView characterDescription;

    public QuestFragment() {
    }

    public static QuestFragment newInstance(Quest quest) {
        QuestFragment fragment = new QuestFragment();
        Bundle args = new Bundle();
        args.putInt("id", quest.getId());
        args.putString("name", quest.getName());
        args.putString("image", quest.getImage());
        args.putString("description", quest.getDescription());
        args.putString("characterImage", quest.getCharacter().getImage());
        args.putString("characterName", quest.getCharacter().getName());
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
        View view = inflater.inflate(R.layout.quest_fragment, group, false);
        image = (ImageView) view.findViewById(R.id.image);
        description = (TextView) view.findViewById(R.id.description);
        characterImage = (ImageView) view.findViewById(R.id.characterImage);
        characterName = (TextView) view.findViewById(R.id.characterName);
        characterDescription = (TextView) view.findViewById(R.id.characterDescription);

        Glide.with(getContext()).load(getArguments().getString("image")).into(image);
        description.setText(getArguments().getString("description"));
        Glide.with(getContext()).load(getArguments().getString("characterImage")).apply(RequestOptions.circleCropTransform()).into(characterImage);
        characterName.setText(getArguments().getString("characterName"));

        return view;
    }
}
