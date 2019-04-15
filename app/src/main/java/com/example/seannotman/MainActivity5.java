package com.example.seannotman;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MainActivity5 extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private static final String TAG = "MainActivity5";

    private ArrayList<Earthquake> earthquakeArrayList;


    List<String> dateListSize = new ArrayList<>();
    private String[] dates;

    //private String dateText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main5);

        Intent intentEarthquakeList = getIntent();
        earthquakeArrayList = intentEarthquakeList.getParcelableArrayListExtra("EarthquakeList");

        for (Earthquake e: earthquakeArrayList){
                String newDate = e.getDateTime();
                if (dateListSize.contains(newDate)){
                    //do nothing
            }
            else {
                dateListSize.add(newDate);

            }

        }



        //Log.d(TAG,"dateList" + dates);
        //Getting the instance of Spinner and applying OnItemSelectedListener on it

        dates = dateListSize.toArray(new String[dateListSize.size()]);
        Log.d(TAG, "dates " + Arrays.toString(dates));

        Spinner spin = findViewById(R.id.spinner);

        //String dateText = spin.getSelectedItem().toString();

        spin.setOnItemSelectedListener(this);




        //Creating the ArrayAdapter instance having the country list
        ArrayAdapter<String> aa = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, dates);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        spin.setAdapter(aa);





    }


    @Override
    public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id)
    {
        Toast.makeText(getApplicationContext(),dates[position] , Toast.LENGTH_LONG).show();



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


    @Override
    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub
    }


}