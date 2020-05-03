package com.example.app;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;


public class DecisionFragment extends Fragment {

    // Directs user to a list, the user composed, of their favorite locations
    private Button visitFavoriteLocationButton;

    // Directs user to MilesActivity to Explore a New Location
    private Button exploreNewPlaceButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_decision, container, false);

        // Find Views
        visitFavoriteLocationButton = view.findViewById(R.id.visitFavoriteLocationButton);
        exploreNewPlaceButton = view.findViewById(R.id.exploreLocationButton);

        // Set onClickListeners for Buttons
        exploreNewPlaceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Directs user to Miles Fragment
                MilesFragment miles = new MilesFragment();
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.main_content_frame, miles, "MilesFragment")
                        .addToBackStack(null)
                        .commit();

            }
        });

        // Set onClickListeners for Buttons
        visitFavoriteLocationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Directs user to Favorite's List
                FavoritesFragment favorites = new FavoritesFragment();
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.main_content_frame, favorites, "FavoriteFragment")
                        .addToBackStack(null)
                        .commit();

            }
        });

        return view;
    }

}
