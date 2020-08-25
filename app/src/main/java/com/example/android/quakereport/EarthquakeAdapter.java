package com.example.android.quakereport;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class EarthquakeAdapter extends ArrayAdapter<Earthquake> {

    private Context mContext;

    @SuppressLint("ResourceType")
    public EarthquakeAdapter(@NonNull Activity context, ArrayList<Earthquake> words) {
        super(context, 42, words);
        mContext = context;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        // this uses method getItem from the original ArrayAdapter class
        Earthquake currentEQ = getItem(position);

        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;

        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                        R.layout.list_item, parent, false);
        }

        TextView magView = listItemView.findViewById(R.id.magnitude);
        assert currentEQ != null;
        magView.setText(String.format("%s", currentEQ.getMagnitude()));

        // Split the location into two two parts
        String fullLocation = currentEQ.getLocation();
        int ofIndex = fullLocation.indexOf(" of ");
        String firstPart = mContext.getString(R.string.near_the);
        String secondPart = fullLocation;
        if (ofIndex != -1) {
            firstPart = fullLocation.substring(0, ofIndex + 3);
            secondPart = fullLocation.substring(ofIndex + 4);
        }

        // Find the location views and display the two parts of the location in these views
        TextView firstLocView = listItemView.findViewById(R.id.location1);
        firstLocView.setText(firstPart);
        TextView secondLocView = listItemView.findViewById(R.id.location2);
        secondLocView.setText(secondPart);

        // Create a new Date object from the time in milliseconds of the earthquake
        Date dateObject = new Date(currentEQ.getTimeMilliseconds());

        // Find the TextView with view ID date
        TextView dateView = (TextView) listItemView.findViewById(R.id.date);
        // Format the date string (i.e. "Mar 3, 1984")
        String formattedDate = formatDate(dateObject);
        // Display the date of the current earthquake in that TextView
        dateView.setText(formattedDate);

        // Find the TextView with view ID time
        TextView timeView = (TextView) listItemView.findViewById(R.id.time);
        // Format the time string (i.e. "4:30PM")
        String formattedTime = formatTime(dateObject);
        // Display the time of the current earthquake in that TextView
        timeView.setText(formattedTime);

        return listItemView;
}

    /**
     * Return the formatted date string (i.e. "Mar 3, 1984") from a Date object.
     */
    private String formatDate(Date dateObject) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("LLL dd, yyyy");
        return dateFormat.format(dateObject);
    }

    /**
     * Return the formatted date string (i.e. "4:30 PM") from a Date object.
     */
    private String formatTime(Date dateObject) {
        SimpleDateFormat timeFormat = new SimpleDateFormat("h:mm a");
        return timeFormat.format(dateObject);
    }

    }
