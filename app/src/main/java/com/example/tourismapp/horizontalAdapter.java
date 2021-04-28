package com.example.tourismapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class horizontalAdapter extends RecyclerView.Adapter<horizontalAdapter.horizontalViewHolder> {
    private List<destinations> destinationList;
    private Context context;

    // Basic constructor
    public horizontalAdapter(List<destinations> destinationList, Context context) {
        this.destinationList = destinationList;
        this.context = context;
    }

    // Uses the horizontal destinations layout.
    @NonNull
    @Override
    public horizontalViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.horizontal_destinations, parent, false);
        return new horizontalViewHolder(itemView);
    }

    // Binds the images from destinationList.
    @Override
    public void onBindViewHolder(@NonNull horizontalViewHolder holder, int position) {
        holder.destinationImageView.setImageResource(destinationList.get(position).getImage());
    }

    // item count for destinationList.
    @Override
    public int getItemCount() {
        return destinationList.size();
    }

    public class horizontalViewHolder extends RecyclerView.ViewHolder {
        public ImageView destinationImageView;

        public horizontalViewHolder(@NonNull View itemView) {
            super(itemView);
            destinationImageView = itemView.findViewById(R.id.destinationImageViewH);
        }
    }

}
