package com.example.app;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;


public class MilesFragment extends Fragment {

    // Seekbar to represent miles
    private SeekBar milesSeekBar;
    // Display current miles selected
    private TextView milesTextView;
    // Confirmation of Miles
    private Button milesConfirmButton;

    int miles = 0;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_miles, container, false);

        milesSeekBar = (SeekBar) view.findViewById(R.id.mileSeekBar);
        milesTextView = (TextView) view.findViewById(R.id.mileTextView);
        milesConfirmButton = (Button) view.findViewById(R.id.confirmMileButton);

        // Set Text to Current Miles
        milesTextView.setText("Miles: " + milesSeekBar.getProgress());

        // Create on Click Listener for SeekBar
        milesSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            // When miles value is changed
            @Override
            public void onProgressChanged(SeekBar seekBar, int progressValue, boolean fromUser) {
                miles = progressValue;
                milesTextView.setText("Miles: " + progressValue);
            }

            // User has started a touch gesture on Seek Bar
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                Log.i("MilesFragment", "Started tracking miles");
            }

            // User has finished a touch gesture on Seek Bar
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                milesTextView.setText("Miles: " + miles);

            }
        });

        milesConfirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Create Bundle
                Bundle bundle = new Bundle();
                bundle.putString("Miles", String.valueOf(miles));

                // Setup Manager + Transaction
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

                // Directs user to next fragment:
                MealFragment mealFragment = new MealFragment();

                // Insert Values to Pass to Next Fragment
                mealFragment.setArguments(bundle);

                // Begin Next Fragment
                fragmentTransaction.replace(R.id.main_content_frame, mealFragment);
                fragmentTransaction.commit();

            }
        });

        return view;
    }
}
