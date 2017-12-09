package com.example.kl7304qk.dahnkyfinal.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
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
import com.example.kl7304qk.dahnkyfinal.activity.MainActivity;
import com.example.kl7304qk.dahnkyfinal.model.Kingdom;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Kyle on 12/8/2017.
 */

public class KingdomsAdapter extends RecyclerView.Adapter<KingdomsAdapter.ViewHolder> {
    Context context;
    ApiService apiService;
    List<Kingdom> kingdoms;

    public KingdomsAdapter(List<Kingdom> kingdoms, Context context) {
        this.context = context;
        this.kingdoms = kingdoms;
        apiService = new ApiService();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_kingdom, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Kingdom kingdom = kingdoms.get(position);
        holder.kingdomName.setText(kingdom.getName());
        Glide.with(context).load(kingdom.getImage()).apply(RequestOptions.circleCropTransform()).into(holder.kingdomImage);
    }

    @Override
    public int getItemCount() {
        return kingdoms.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView kingdomImage;
        TextView kingdomName;
        public ViewHolder(View itemView) {
            super(itemView);

            kingdomImage = (ImageView) itemView.findViewById(R.id.kingdomImage);
            kingdomName = (TextView) itemView.findViewById(R.id.kingdomName);
        }
    }
}
