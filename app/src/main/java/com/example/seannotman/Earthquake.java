package com.example.seannotman;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

import java.io.Serializable;
import java.util.Comparator;

import static android.content.ContentValues.TAG;



public class Earthquake implements Parcelable {

    private String name;
    private Double latitude;
    private Double longitude;
    private String day;
    private String location;
    private Double depth;
    private Double magnitude;
    private String dateTime;
    private String eTime;


    public Earthquake(String name, Double latitude, Double longitude, String day, String location, Double depth, Double magnitude, String dateTime, String eTime) {
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
        this.day = day;
        this.location = location;
        this.depth = depth;
        this.magnitude = magnitude;
        this.dateTime = dateTime;
        this.eTime = eTime;
    }

    public Earthquake(){
        this.name = "";
        this.latitude = 0.0;
        this.longitude = 0.0;
        this.day = "";
        this.location = "";
        this.depth = 0.0;
        this.magnitude = 0.0;
        this.dateTime = "";
        this.eTime = "";
    }


    @Override
    public String toString() {
        return "Earthquake{" +
                "name='" + name + '\'' +
                ", latitude='" + latitude + '\'' +
                ", longitude='" + longitude + '\'' +
                ", day='" + day + '\'' +
                ", location='" + location + '\'' +
                ", depth='" + depth + '\'' +
                ", magnitude='" + magnitude + '\'' +
                ", dateTime='" + dateTime + '\'' +
                '}';
    }

    protected Earthquake(Parcel in) {
        name = in.readString();
        latitude = in.readDouble();
        longitude = in.readDouble();
        day = in.readString();
        location = in.readString();
        depth = in.readDouble();
        magnitude = in.readDouble();
        dateTime = in.readString();
        eTime = in.readString();
    }

    public static final Creator<Earthquake> CREATOR = new Creator<Earthquake>() {
        @Override
        public Earthquake createFromParcel(Parcel in) {
            return new Earthquake(in);
        }


        @Override
        public Earthquake[] newArray(int size) {
            return new Earthquake[size];

        }

    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeDouble(latitude);
        parcel.writeDouble(longitude);
        parcel.writeString(day);
        parcel.writeString(location);
        parcel.writeDouble(depth);
        parcel.writeDouble(magnitude);
        parcel.writeString(dateTime);
        parcel.writeString(eTime);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
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

    public void setDepth(Double depth) {
        this.depth = depth;
    }

    public Double getDepth() {
        return depth;
    }

    public void setMagnitude(Double magnitude) {
        this.magnitude = magnitude;
    }

    public Double getMagnitude() {
        return magnitude;
    }


    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void seteTime(String eTime) {
        this.eTime = eTime;
    }

    public String geteTime() {
        return eTime;
    }


    public static final Comparator<Earthquake> cmp = new Comparator<Earthquake>() {
        @Override

        public int compare (Earthquake o1, Earthquake o2) {

            return Double.compare(o1.getDepth(), o2.getDepth());
        }
        };

    public static final Comparator<Earthquake> cmp2 = new Comparator<Earthquake>() {
        @Override
        public int compare(Earthquake o1, Earthquake o2) {
            return Double.compare(o1.getMagnitude(), o2.getMagnitude());
        }
    };

    public static final Comparator<Earthquake> cmp3 = new Comparator<Earthquake>() {
        @Override
        public int compare(Earthquake o1, Earthquake o2) {
            return Double.compare(o1.getLongitude(), o2.getLongitude());
        }
    };

    public static final Comparator<Earthquake> cmp4 = new Comparator<Earthquake>() {
        @Override
        public int compare(Earthquake o1, Earthquake o2) {
            return Double.compare(o1.getLatitude(), o2.getLatitude());
        }
    };

}
