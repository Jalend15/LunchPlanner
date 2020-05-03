package com.example.app;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.Locale;

public class listAdapter extends ArrayAdapter<listItem> {

    // widgets
    Context context;
    TextView venueName;
    TextView venueAddress;
    listItem venueItem;

    // vars
    Double latitude = null;
    Double longitude = null;

    public listAdapter(Context context) {
        super(context, R.layout.list_item);
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater layoutInflater = LayoutInflater.from(context);
            convertView = layoutInflater.inflate(R.layout.list_item, parent, false);

        }

        // Convert Views
        venueName = (TextView) convertView.findViewById(R.id.placeTitle);
        venueAddress = (TextView) convertView.findViewById(R.id.placeAddress);

        // Get position of current item
        venueItem = getItem(position);

        // Set Item
        venueName.setText(venueItem.getNameOfLocation());
        venueAddress.setText(venueItem.getAddressOfLocation());

        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                latitude = venueItem.getLatOfLocation();
                longitude = venueItem.getLongOfLocation();
                Log.d("RESULTS", "LAT:" + latitude);
                Log.d("RESULTS", "LONG" + longitude);

                String map = "http://maps.google.co.in/maps?q=" + venueItem.getAddressOfLocation();
                String geoUri = "http://maps.google.com/maps?q=loc:" + latitude + "," + longitude;
                String uri = String.format(Locale.ENGLISH, "geo:%f,%f", latitude, longitude);

                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(map));
                context.startActivity(intent);
            }
        });

        return convertView;
    }

}
