package com.example.app;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

// Content Activity Hosts Multiple Fragments
public class ContentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content);

        init();
    }

    private void init() {
        DecisionFragment decisionFragment = new DecisionFragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.main_content_frame, decisionFragment, getString(R.string.tag_decision));

        transaction.addToBackStack(getString(R.string.tag_decision));
        transaction.commit();
    }

}
