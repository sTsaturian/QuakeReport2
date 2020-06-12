package com.example.android.quakereport;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.ArrayList;

public class EarthquakeAdapter extends ArrayAdapter<Earthquake> {

    @SuppressLint("ResourceType")
    public EarthquakeAdapter(@NonNull Activity context, ArrayList<Earthquake> words) {
        super(context, 42, words);
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

        TextView locView = listItemView.findViewById(R.id.location);
        locView.setText(currentEQ.getLocation());

        TextView dateView = listItemView.findViewById(R.id.date);
        dateView.setText(currentEQ.getDate());

        return listItemView;
    }
}
