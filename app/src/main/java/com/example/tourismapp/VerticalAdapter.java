package com.example.tourismapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class VerticalAdapter extends RecyclerView.Adapter<VerticalAdapter.VerticalViewHolder> {
    private List<Destinations> destinationList;
    private Context context;

    private OnDestinationListener clickListener;

    // Basic constructor
    public VerticalAdapter(List<Destinations> destinationList, Context context, OnDestinationListener destinationListener) {
        this.destinationList = destinationList;
        this.context = context;
        this.clickListener = destinationListener;
    }

    // Uses the vertical destinations layout.
    @NonNull
    @Override
    public VerticalViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.vertical_destinations, parent, false);
        return new VerticalViewHolder(itemView);
    }

    // Binds the images from destinationList.
    @Override
    public void onBindViewHolder(@NonNull VerticalViewHolder holder, int position) {
        holder.destinationImageView.setImageResource(destinationList.get(position).getImage());
        holder.locationTextView.setText(destinationList.get(position).getLocation());
        holder.descriptionTextView.setText(destinationList.get(position).getDescription());
    }

    // item count for destinationList.
    @Override
    public int getItemCount() {
        return destinationList.size();
    }

    // VerticalViewHolder class
    public class VerticalViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public ImageView destinationImageView;
        public TextView  locationTextView, descriptionTextView;

        // Basic constructor, also sets onclick listener.
        public VerticalViewHolder(@NonNull View itemView) {
            super(itemView);
            destinationImageView = itemView.findViewById(R.id.destinationImageView);
            locationTextView = itemView.findViewById(R.id.locationTextView);
            descriptionTextView = itemView.findViewById(R.id.descriptionTextView);
            itemView.setOnClickListener(this);
        }

        // Gets the selected items position and passes it to the required function.
        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
            clickListener.onDestinationClick(position);
        }
    }

    // Interface that calls our click function to create a fragment with the desired item position.
    public interface OnDestinationListener {
        void onDestinationClick(int position);
    }
}
