package com.example.app;


import android.os.AsyncTask;
import android.util.Log;

import androidx.fragment.app.Fragment;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class FetchData extends AsyncTask<String, listItem, Void> {

    listAdapter mListAdapter;
    Fragment fragment;

    // Constructor
    public FetchData(Fragment fragment) {
        this.fragment = fragment;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();

        // Find Fragment's listView
        mListAdapter = (listAdapter) ((ResultsFragment) fragment).listView.getAdapter();

        // Clear Previous Content
        mListAdapter.clear();
        mListAdapter.notifyDataSetChanged();

    }

    @Override
    protected Void doInBackground(String... params) {

        // Declare Variables
        String str;
        HttpURLConnection connection = null;
        StringBuilder builder = new StringBuilder();

        // Set Foursquare API Keys
        final String CLIENT_ID = "141W4JNRKQRNCETDIKNP3CQSNY5YV1N3VXOEJYQ1MSOEY5NJ";
        final String CLIENT_PASSWORD = "WFPTH0UWNJWDSC0ZXKERP3TAMICR3YXXPH0PF1UH2SOMK1I0";

        // Coordinates of Miami Dade College Wolfson Campus (for Testing Purposes)
        final String Latitude = "25.777657";
        final String Longitude = "-80.190532";

        // Setup URL where Param is the Query
        String completeURL = "https://api.foursquare.com/v2/venues/search?ll=" + Latitude + "," + Longitude + "&client_id=" + CLIENT_ID + "&client_secret=" + CLIENT_PASSWORD + "&v=20151110&limit=20&venuePhotos=1&query=" + params[0];
        try {

            // Create Connection
            URL url = new URL(completeURL);
            connection = (HttpURLConnection) url.openConnection();

            // Create Buffer Reader
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));

            // Read Input
            while ((str = reader.readLine()) != null) {
                builder.append(str + "\n");
            }

            // Parse JSON
            final JSONObject jsonObject = new JSONObject(builder.toString());

            // Obtain venues from response
            JSONArray jsonArray = jsonObject.getJSONObject("response").getJSONArray("venues");
            int size = jsonArray.length();

            // Find Venue Details
            for (int i = 0; i < size; i++) {

                // Venue Details
                String venueId = "0";
                String venueName = "name";
                String venueAddress = "address";
                Double venueLatitude = null;
                Double venueLongitude = null;
                int venueDistance = 0;
                String venueCategory = "category";

                // Create Object
                JSONObject object = jsonArray.getJSONObject(i);

                // Obtain Id of Venue
                if (object.has("id")) {
                    venueId = object.getString("id");
                }

                // Obtain Name of Venue
                if (object.has("name")) {
                    venueName = object.getString("name");
                }

                // Obtain Address of Venue
                if (object.getJSONObject("location").has("formattedAddress")) {
                    JSONArray array = object.getJSONObject("location").getJSONArray("formattedAddress");
                    StringBuilder stringBuilder = new StringBuilder();
                    if (array.get(0) != null) {
                        stringBuilder.append(array.getString(0));
                    }
                    venueAddress = stringBuilder.toString();
                }

                // Obtain Latitude of Venue
                if (object.getJSONObject("location").has("lat")) {
                    venueLatitude = object.getJSONObject("location").getDouble("lat");
                }

                // Obtain Longitude of Venue
                if (object.getJSONObject("location").has("lng")) {
                    venueLongitude = object.getJSONObject("location").getDouble("lng");
                }

                // Obtain Distance of Venue
                if (object.getJSONObject("location").has("distance")) {
                    venueDistance = object.getJSONObject("location").getInt("distance");
                }

                // Obtain Category of Venue
                if (object.getJSONObject("location").has("categories")) {
                    JSONArray array = object.getJSONObject("location").getJSONArray("name");
                    StringBuilder stringBuilder = new StringBuilder();
                    if (array.get(0) != null) {
                        stringBuilder.append(array.getString(0));
                    }
                    venueCategory = stringBuilder.toString();
                }

                // Create List Item using Values Collected
                listItem newItem = new listItem(venueId, venueName, venueAddress, venueLatitude, venueLongitude, venueDistance, venueCategory);
                publishProgress(newItem);
            }


        } catch (Exception e) {
            e.printStackTrace();
            Log.d("FetchData", "Error w/ Parsing Response");
        } finally {
            if (connection != null)
                connection.disconnect();
            Log.d("FetchData", "Connectivity Issue");
        }

        return null;
    }

    @Override
    protected void onProgressUpdate(listItem... item) {
        super.onProgressUpdate(item);
        // Add items to Adapter
        mListAdapter.add(item[0]);
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
    }
}


