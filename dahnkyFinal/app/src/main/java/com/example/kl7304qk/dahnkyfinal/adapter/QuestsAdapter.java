package com.example.kl7304qk.dahnkyfinal.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.kl7304qk.dahnkyfinal.R;
import com.example.kl7304qk.dahnkyfinal.activity.QuestDetailActivity;
import com.example.kl7304qk.dahnkyfinal.model.Quest;

import java.util.List;

/**
 * Created by Kyle on 12/10/2017.
 */

public class QuestsAdapter extends RecyclerView.Adapter<QuestsAdapter.ViewHolder> {
    private final Context context;
    private final List<Quest> quests;
    private final int position;

    public QuestsAdapter(List<Quest> quests, int position, Context context) {
        this.context = context;
        this.quests = quests;
        this.position = position;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_quest, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Quest quest = quests.get(position);
        holder.questName.setText(quest.getName());
        Glide.with(context).load(quest.getImage()).apply(RequestOptions.circleCropTransform()).into(holder.questImage);
    }

    @Override
    public int getItemCount() {
        return quests.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        final ImageView questImage;
        final TextView questName;
        public ViewHolder(final View itemView) {
            super(itemView);

            questImage = itemView.findViewById(R.id.questImage);
            questName = itemView.findViewById(R.id.questName);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent quest = new Intent(context, QuestDetailActivity.class);
                    quest.putExtra("kingdom", position);
                    quest.putExtra("position", getAdapterPosition());
                    quest.putExtra("count", getItemCount());
                    context.startActivity(quest);
                }
            });
        }
    }
}
