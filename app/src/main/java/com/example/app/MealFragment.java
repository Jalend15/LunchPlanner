package com.example.app;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import java.util.ArrayList;


public class MealFragment extends Fragment {

    private TextView milesDesired;
    private ListView listView;
    private MealAdapter mAdapter;
    String query;
    String meal;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_meal, container, false);

        // Find View for Miles
        milesDesired = (TextView) view.findViewById(R.id.milesChosenTextView);

        // Get Data Passed from Previous Fragment
        Bundle bundle = getArguments();

        if (bundle != null) {

            // Receive message value from intent
            String mileMessage = bundle.getString("Miles");

            // Display message on textView
            milesDesired.setText(mileMessage);
        }


        listView = (ListView) view.findViewById(R.id.mealTypeList);
        final ArrayList<MealType> mealType = new ArrayList<>();

        // Create Meal Types
        mealType.add(new MealType("Breakfast"));
        mealType.add(new MealType("Lunch"));
        mealType.add(new MealType("Dinner"));
        mealType.add(new MealType("Snack"));

        // Set Adapter
        mAdapter = new MealAdapter(view.getContext(), mealType);
        listView.setAdapter(mAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                //CustomListItem singleListItem = (CustomListItem) listView.getItemAtPosition(position);
                MealType mItem = (MealType) listView.getItemAtPosition(position);

                // Obtain Meal Type
                meal = mItem.getmealType();

                // Create Bundle
                Bundle bundle = new Bundle();
                bundle.putString("meal", meal);

                // Setup Manager + Transaction
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

                // Directs user to next fragment:
                ResultsFragment resultsFragment = new ResultsFragment();

                // Insert Values to Pass to Next Fragment
                resultsFragment.setArguments(bundle);

                // Begin Next Fragment
                fragmentTransaction.replace(R.id.main_content_frame, resultsFragment);
                fragmentTransaction.commit();
            }
        });

        return view;
    }
}
