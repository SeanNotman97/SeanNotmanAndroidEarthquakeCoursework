package com.example.seannotman;

import android.os.Parcel;
import android.os.Parcelable;

public class FeedEntry implements Parcelable {

    private String name;
    private String latitude;
    private String longitude;
    private String day;
    private String location;
    private String depth;
    private String magnitude;
    private String dateTime;

    public FeedEntry(String name, String latitude, String longitude, String day, String location, String depth, String magnitude, String dateTime) {
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
        this.day = day;
        this.location = location;
        this.depth = depth;
        this.magnitude = magnitude;
        this.dateTime = dateTime;

    }

    public FeedEntry(){
        this.name = "";
        this.latitude = "";
        this.longitude = "";
        this.day = "";
        this.location = "";
        this.depth = "";
        this.magnitude = "";
        this.dateTime = "";
    }





    protected FeedEntry(Parcel in) {
        name = in.readString();
        latitude = in.readString();
        longitude = in.readString();
        day = in.readString();
        location = in.readString();
        depth = in.readString();
        magnitude = in.readString();
        dateTime = in.readString();
    }

    public static final Creator<FeedEntry> CREATOR = new Creator<FeedEntry>() {
        @Override
        public FeedEntry createFromParcel(Parcel in) {
            return new FeedEntry(in);
        }


        @Override
        public FeedEntry[] newArray(int size) {
            return new FeedEntry[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeString(latitude);
        parcel.writeString(longitude);
        parcel.writeString(day);
        parcel.writeString(location);
        parcel.writeString(depth);
        parcel.writeString(magnitude);
        parcel.writeString(dateTime);

    }







    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getLocation() {
        return location;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public void setDepth(String depth) {
        this.depth = depth;
    }

    public String getDepth() {
        return depth;
    }

    public void setMagnitude(String magnitude) {
        this.magnitude = magnitude;
    }

    public String getMagnitude() {
        return magnitude;
    }


    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public String getDateTime() {
        return dateTime;
    }




}
