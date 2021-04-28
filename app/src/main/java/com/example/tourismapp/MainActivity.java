package com.example.tourismapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements com.example.tourismapp.VerticalAdapter.OnDestinationListener {

    RecyclerView verticalRecyclerView;
    VerticalAdapter VerticalAdapter;
    RecyclerView horizontalRecyclerView;
    HorizontalAdapter horizontalAdapter;
    List<Destinations> destinationsList = new ArrayList<>();

    Integer[] imageList = {R.drawable.abu_dhabi, R.drawable.alberta, R.drawable.indonesia, R.drawable.morocco, R.drawable.paris, R.drawable.pisa};
    String[] locationList = {"United Arab Emirates", "Canada", "Indonesia", "Morocco", "France", "Italy"};
    String[] descriptionList = {"UAE Description.", "Canada Description", "Indonesia Description", "Morocco Description", "France Description", "Italy Description"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Vertical Recycler setup
        verticalRecyclerView = findViewById(R.id.verticalRecycler);
        VerticalAdapter = new VerticalAdapter(destinationsList, MainActivity.this, this);
        verticalRecyclerView.setAdapter(VerticalAdapter);
        RecyclerView.LayoutManager verticalLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        verticalRecyclerView.setLayoutManager(verticalLayoutManager);

        // Horizontal Recycler setup
        horizontalRecyclerView = findViewById(R.id.horizontalRecycler);
        horizontalAdapter = new HorizontalAdapter(destinationsList, MainActivity.this);
        horizontalRecyclerView.setAdapter(horizontalAdapter);
        RecyclerView.LayoutManager horizontalLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        horizontalRecyclerView.setLayoutManager(horizontalLayoutManager);

        // Combines lists of images, locations and descriptions into destinationsList.
        for (int i = 0; i < imageList.length; i++)
        {
            Destinations destinations = new Destinations(i, imageList[i], locationList[i], descriptionList[i]);
            destinationsList.add(destinations);
        }
    }

    // Used to ensure user can see the main activity screen and interact with it again.
    @Override
    public void onBackPressed() {
        View f = findViewById(R.id.fragment);
        f.setBackgroundColor(Color.TRANSPARENT);
        f.setClickable(false);
        f.setFocusable(false);
        super.onBackPressed();
    }

    // Creates the new fragment with data based on the item clicked. Also ensures that the user
    // can no longer see or interact with the main activity screen the fragment is overlaying on.
    @Override
    public void onDestinationClick(int position) {
        Fragment fragment;
        fragment = new DestinationFragment();

        View f = findViewById(R.id.fragment);
        f.setBackgroundColor(Color.WHITE);
        f.setClickable(true);
        f.setFocusable(true);

        Bundle data = new Bundle();
        data.putInt("IMAGE", imageList[position]);
        data.putString("LOCATION", locationList[position]);
        data.putString("DESCRIPTION", descriptionList[position]);
        fragment.setArguments(data);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment, fragment)
                .addToBackStack("")
                .commit();
    }
}