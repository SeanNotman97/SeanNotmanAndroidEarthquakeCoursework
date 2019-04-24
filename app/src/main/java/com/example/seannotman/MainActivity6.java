package com.example.seannotman;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;

import static com.example.seannotman.Earthquake.cmp;
import static com.example.seannotman.Earthquake.cmp2;
import static com.example.seannotman.Earthquake.cmp3;
import static com.example.seannotman.Earthquake.cmp4;

public class MainActivity6 extends AppCompatActivity {


    private ArrayList<Earthquake> earthquakeArrayList;
    private String TAG;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);

        Intent intentEarthquakeList = getIntent();
        earthquakeArrayList = intentEarthquakeList.getParcelableArrayListExtra("EarthquakeList");

        Earthquake highestDepth = Collections.max(earthquakeArrayList, cmp);
        Log.d(TAG, "highestDepth: " + highestDepth);

        TextView textView1 = findViewById(R.id.depth1);
        textView1.setText(highestDepth.getLocation());

        TextView textView2 = findViewById(R.id.depth2);
        textView2.setText(highestDepth.getDepth().toString());

        TextView textView3 = findViewById(R.id.depth3);
        textView3.setText(highestDepth.getDateTime());

        TextView textView4 = findViewById(R.id.depth4);
        textView4.setText(highestDepth.getMagnitude().toString());

        highestDepth.getLocation();
        highestDepth.getDepth();
        highestDepth.getDateTime();
        highestDepth.getMagnitude();




        Earthquake lowestDepth = Collections.min(earthquakeArrayList, cmp);
        Log.d(TAG, "lowestDepth: " + lowestDepth);


        TextView textView5 = findViewById(R.id.depth5);
        textView5.setText(lowestDepth.getLocation());

        TextView textView6 = findViewById(R.id.depth6);
        textView6.setText(lowestDepth.getDepth().toString());

        TextView textView7 = findViewById(R.id.depth7);
        textView7.setText(lowestDepth.getDateTime());

        TextView textView8 = findViewById(R.id.depth8);
        textView8.setText(lowestDepth.getMagnitude().toString());


        lowestDepth.getLocation();
        lowestDepth.getDepth();
        lowestDepth.getDateTime();
        lowestDepth.getMagnitude();

        Earthquake lowestMagnitude = Collections.min(earthquakeArrayList, cmp2);
        Log.d(TAG, "lowestMagnitude " + lowestMagnitude);





        lowestMagnitude.getLocation();
        lowestMagnitude.getDepth();
        lowestMagnitude.getDateTime();
        lowestMagnitude.getMagnitude();

        Earthquake highestMagnitude = Collections.max(earthquakeArrayList, cmp2);
        Log.d(TAG, "highestMagnitude " + highestMagnitude);


        highestMagnitude.getLocation();
        highestMagnitude.getDepth();
        highestMagnitude.getDateTime();
        highestMagnitude.getMagnitude();

        TextView textView25 = findViewById(R.id.mag);
        textView25.setText(highestMagnitude.getLocation());

        TextView textView26 = findViewById(R.id.mag2);
        textView26.setText(highestMagnitude.getDepth().toString());

        TextView textView27 = findViewById(R.id.mag3);
        textView27.setText(highestMagnitude.getDateTime());

        TextView textView28 = findViewById(R.id.mag4);
        textView28.setText(highestMagnitude.getMagnitude().toString());



        Earthquake mostSouth = Collections.min(earthquakeArrayList, cmp3);
        Log.d(TAG, "mostSouth " + mostSouth);

        TextView textView13 = findViewById(R.id.South);
        textView13.setText(mostSouth.getLocation());

        TextView textView14 = findViewById(R.id.south);
        textView14.setText(mostSouth.getDepth().toString());

        TextView textView15 = findViewById(R.id.south2);
        textView15.setText(mostSouth.getDateTime());

        TextView textView16 = findViewById(R.id.south3);
        textView16.setText(mostSouth.getMagnitude().toString());

        mostSouth.getLocation();
        mostSouth.getDepth();
        mostSouth.getDateTime();
        mostSouth.getMagnitude();

        Earthquake mostNorth = Collections.max(earthquakeArrayList, cmp3);
        Log.d(TAG, "mostNorth " + mostNorth);

        TextView textView9 = findViewById(R.id.north1);
        textView9.setText(mostNorth.getLocation());

        TextView textView10 = findViewById(R.id.north2);
        textView10.setText(mostNorth.getDepth().toString());

        TextView textView11 = findViewById(R.id.north3);
        textView11.setText(mostNorth.getDateTime());

        TextView textView12 = findViewById(R.id.north4);
        textView12.setText(mostNorth.getMagnitude().toString());

        mostNorth.getLocation();
        mostNorth.getDepth();
        mostNorth.getDateTime();
        mostNorth.getMagnitude();

        Earthquake mostEast = Collections.max(earthquakeArrayList, cmp4);
        Log.d(TAG, "mostEast " + mostEast);


        TextView textView21 = findViewById(R.id.east);
        textView21.setText(mostEast.getLocation());

        TextView textView22 = findViewById(R.id.east1);
        textView22.setText(mostEast.getDepth().toString());

        TextView textView23 = findViewById(R.id.east2);
        textView23.setText(mostEast.getDateTime());

        TextView textView24 = findViewById(R.id.east3);
        textView24.setText(mostEast.getMagnitude().toString());



        mostEast.getLocation();
        mostEast.getDepth();
        mostEast.getDateTime();
        mostEast.getMagnitude();

        Earthquake mostWest = Collections.min(earthquakeArrayList, cmp4);
        Log.d(TAG, "mostWest " + mostWest);

        mostWest.getLocation();
        mostWest.getDepth();
        mostWest.getDateTime();
        mostWest.getMagnitude();

        TextView textView17 = findViewById(R.id.West);
        textView17.setText(mostWest.getLocation());

        TextView textView18 = findViewById(R.id.west1);
        textView18.setText(mostWest.getDepth().toString());

        TextView textView19 = findViewById(R.id.west2);
        textView19.setText(mostWest.getDateTime());

        TextView textView20 = findViewById(R.id.west3);
        textView20.setText(mostWest.getMagnitude().toString());


    }

}
