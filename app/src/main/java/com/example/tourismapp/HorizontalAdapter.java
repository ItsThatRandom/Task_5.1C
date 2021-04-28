package com.example.tourismapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class HorizontalAdapter extends RecyclerView.Adapter<HorizontalAdapter.HorizontalViewHolder> {
    private List<Destinations> destinationList;
    private Context context;

    // Basic constructor
    public HorizontalAdapter(List<Destinations> destinationList, Context context) {
        this.destinationList = destinationList;
        this.context = context;
    }

    // Uses the horizontal destinations layout.
    @NonNull
    @Override
    public HorizontalViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.horizontal_destinations, parent, false);
        return new HorizontalViewHolder(itemView);
    }

    // Binds the images from destinationList.
    @Override
    public void onBindViewHolder(@NonNull HorizontalViewHolder holder, int position) {
        holder.destinationImageView.setImageResource(destinationList.get(position).getImage());
    }

    // item count for destinationList.
    @Override
    public int getItemCount() {
        return destinationList.size();
    }

    public class HorizontalViewHolder extends RecyclerView.ViewHolder {
        public ImageView destinationImageView;

        public HorizontalViewHolder(@NonNull View itemView) {
            super(itemView);
            destinationImageView = itemView.findViewById(R.id.destinationImageViewH);
        }
    }

}
