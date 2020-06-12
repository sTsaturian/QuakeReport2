package com.example.android.quakereport;

public class Earthquake {

    private String location;
    private double magnitude;
    private String date;

    /**
     * Create a new Word object.
     *
     * @param location is the description of the location of the eartquake (i.e. city)
     * @param date is the date in format *********
     * @param magnitude is the magnitude on scale from 0 to 10
     */
    public Earthquake(String location, double magnitude, String date) {
        this.date = date;
        this.location = location;
        this.magnitude = magnitude;
    }

    public double getMagnitude() {
        return magnitude;
    }

    public String getDate() {
        return date;
    }

    public String getLocation() {
        return location;
    }
}
