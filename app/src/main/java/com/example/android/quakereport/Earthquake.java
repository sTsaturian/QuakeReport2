package com.example.android.quakereport;

public class Earthquake {

    private String location;
    private double magnitude;
    private long timeMilliseconds;

    /**
     * Create a new Word object.
     *  @param location is the description of the location of the eartquake (i.e. city)
     * @param magnitude is the magnitude on scale from 0 to 10
     * @param timeMilliseconds is the date in format *********
     */
    public Earthquake(String location, double magnitude, long timeMilliseconds) {
        this.timeMilliseconds = timeMilliseconds;
        this.location = location;
        this.magnitude = magnitude;
    }

    public double getMagnitude() {
        return magnitude;
    }

    public long getTimeMilliseconds() {
        return timeMilliseconds;
    }

    public String getLocation() {
        return location;
    }
}
