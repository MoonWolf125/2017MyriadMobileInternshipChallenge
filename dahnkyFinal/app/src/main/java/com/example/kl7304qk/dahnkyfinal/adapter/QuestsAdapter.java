package com.example.kl7304qk.dahnkyfinal.adapter;

import android.content.Context;
import android.content.Intent;
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
import com.example.kl7304qk.dahnkyfinal.activity.QuestDetailActivity;
import com.example.kl7304qk.dahnkyfinal.model.Quest;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Kyle on 12/10/2017.
 */

public class QuestsAdapter extends RecyclerView.Adapter<QuestsAdapter.ViewHolder> {
    Context context;
    ApiService apiService;
    List<Quest> quests;
    int position;

    public QuestsAdapter(List<Quest> quests, int position, Context context) {
        this.context = context;
        this.quests = quests;
        this.position = position;
        apiService = new ApiService();
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
        ImageView questImage;
        TextView questName;
        public ViewHolder(final View itemView) {
            super(itemView);

            questImage = (ImageView) itemView.findViewById(R.id.questImage);
            questName = (TextView) itemView.findViewById(R.id.questName);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(context, quests.get(getAdapterPosition()).getName(), Toast.LENGTH_SHORT).show();
                    Intent Quest = new Intent(context, QuestDetailActivity.class);
                    Quest.putExtra("kingdom", position);
                    Quest.putExtra("position", getAdapterPosition());
                    Quest.putExtra("count", getItemCount());
                    context.startActivity(Quest);
                }
            });
        }
    }
}
