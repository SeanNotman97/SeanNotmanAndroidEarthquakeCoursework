package com.example.seannotman;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class MainActivity5 extends AppCompatActivity {

    private static final String TAG = "MainActivity5";

    private ArrayList<Earthquake> earthquakeArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main5);

        Intent intentEarthquakeList = getIntent();
        earthquakeArrayList = intentEarthquakeList.getParcelableArrayListExtra("EarthquakeList");

        Earthquake highestDepth = Collections.max(earthquakeArrayList, Earthquake.cmp);
        Log.d(TAG, "highestDepth: " + highestDepth);

        Earthquake lowestDepth = Collections.min(earthquakeArrayList, Earthquake.cmp);
        Log.d(TAG, "lowestDepth: " + lowestDepth);

        Earthquake lowestMagnitude = Collections.min(earthquakeArrayList, Earthquake.cmp2);
        Log.d(TAG, "lowestMagnitude " + lowestMagnitude);

        Earthquake highestMagnitude = Collections.max(earthquakeArrayList, Earthquake.cmp2);
        Log.d(TAG, "highestMagnitude " + highestMagnitude);

        Earthquake mostSouth = Collections.min(earthquakeArrayList, Earthquake.cmp3);
        Log.d(TAG, "mostSouth " + mostSouth);

        Earthquake mostNorth = Collections.max(earthquakeArrayList, Earthquake.cmp3);
        Log.d(TAG, "mostNorth " + mostNorth);

        Earthquake mostEast = Collections.max(earthquakeArrayList, Earthquake.cmp4);
        Log.d(TAG, "mostEast " + mostEast);

        Earthquake mostWest = Collections.min(earthquakeArrayList, Earthquake.cmp4);
        Log.d(TAG, "mostWest " + mostWest);
    }








    }