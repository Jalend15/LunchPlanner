package com.example.app;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;


public class ResultsFragment extends Fragment {

    // Displays list of Locations based on user preferences
    ArrayList<listItem> list;
    listAdapter mListAdapter;
    ListView listView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_results, container, false);

        // Display Results from User Preference
        list = new ArrayList<>();
        listView = (ListView) view.findViewById(R.id.listView);
        mListAdapter = new listAdapter(view.getContext());
        listView.setAdapter(mListAdapter);


        // Get Data Passed from Previous Fragment
        Bundle bundle = getArguments();

        if (bundle != null) {

            // Receive message value from intent
            String mealMessage = bundle.getString("meal");

            // mealMessage serves as query for FetchData
            new FetchData(this).execute(mealMessage);

        }



        return view;
    }

}