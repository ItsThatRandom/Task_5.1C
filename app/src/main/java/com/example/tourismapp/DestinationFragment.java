package com.example.tourismapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class DestinationFragment extends Fragment {

    public DestinationFragment() {
    }

    public static DestinationFragment newInstance() {
        DestinationFragment fragment = new DestinationFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    // Sets the elements with the desired data passed in the Bundle, else making no changes.
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_destination, container, false);
        ImageView image = view.findViewById(R.id.fragDestinationImageView);
        TextView location = view.findViewById(R.id.fragLocationTextView);
        TextView description = view.findViewById(R.id.fragDescriptionTextView);

        Bundle data = getArguments();
        if (data != null) {
            image.setImageResource(data.getInt("IMAGE"));
            location.setText(data.getString("LOCATION"));
            description.setText(data.getString("DESCRIPTION"));
        }
        return view;
    }
}