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
    //private int position = ;
    //private String dateText;
    //Spinner spin;

    private String selectedDate;

    Earthquake lowestDepthDate;
    //private int selectionPosition;

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

        dates = dateListSize.toArray(new String[dateListSize.size()]);


        //Log.d(TAG, "dates " + Arrays.toString(dates));

        Spinner spin = findViewById(R.id.spinner);
        spin.setOnItemSelectedListener(this);

        //spin.setSelection(((ArrayAdapter<String>)spin.getAdapter()).getPosition());



        //String dateText = spin.getSelectedItem().toString();

//        spin.setOnItemSelectedListener(this);
//        int indexValue = spin.getSelectedItemPosition();
//        Log.d(TAG, "onCreate: " + indexValue);


        //Creating the ArrayAdapter instance having the country list
        ArrayAdapter<String> aa = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, dates);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
//        int spinnerPosition = aa.getPosition(dates);
//        spin.setSelection(spinnerPosition);

        spin.setAdapter(aa);



        //use this
       // int selectionPosition = aa.getPosition("YOUR_VALUE");
       // spin.setSelection(selectionPosition);




    }


    @Override
    public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id)
    {
        //Toast.makeText(getApplicationContext(),dates[position] , Toast.LENGTH_LONG).show();

    //https://stackoverflow.com/questions/20151414/how-can-i-use-onitemselected-in-android
        Toast.makeText(arg0.getContext(),
                "OnItemSelectedListener : " + arg0.getItemAtPosition(position).toString(),
                Toast.LENGTH_SHORT).show();
       selectedDate = arg0.getItemAtPosition(position).toString();
       // Log.d(TAG, "onCreate: " + selectedDate);

//        Earthquake highestDepth = Collections.max(earthquakeArrayList, cmp);
//        Log.d(TAG, "highestDepth: " + highestDepth);

      //  Earthquake lowestDepth = Collections.min(earthquakeArrayList, cmp);
        //Log.d(TAG, "lowestDepth: " + lowestDepth);

//        Earthquake lowestMagnitude = Collections.min(earthquakeArrayList, cmp2);
//        Log.d(TAG, "lowestMagnitude " + lowestMagnitude);
//
//        Earthquake highestMagnitude = Collections.max(earthquakeArrayList, cmp2);
//        Log.d(TAG, "highestMagnitude " + highestMagnitude);
//
//        Earthquake mostSouth = Collections.min(earthquakeArrayList, cmp3);
//        Log.d(TAG, "mostSouth " + mostSouth);
//
//        Earthquake mostNorth = Collections.max(earthquakeArrayList, cmp3);
//        Log.d(TAG, "mostNorth " + mostNorth);
//
//        Earthquake mostEast = Collections.max(earthquakeArrayList, cmp4);
//        Log.d(TAG, "mostEast " + mostEast);
//
//        Earthquake mostWest = Collections.min(earthquakeArrayList, cmp4);
//        Log.d(TAG, "mostWest " + mostWest);

//        Double max = Double.MIN_VALUE;
//        for (Earthquake e : earthquakeArrayList){
//           if (e.getDateTime() == selectedDate && e.getDepth() > max) {
//               max = e.getDepth();
//
//            }
//        }
//        Log.d(TAG, "onItemSelected: " + max);


        double minDepth = 999;
        for (Earthquake e : earthquakeArrayList){
            if (e.getDateTime().equals(selectedDate) & e.getDepth() < minDepth){
                minDepth = e.getDepth();
                //e = lowestDepthDate;
            }

        }

        double maxDepth = 0;
        for (Earthquake e : earthquakeArrayList){
            if (e.getDateTime().equals(selectedDate) & e.getDepth() > maxDepth){
                maxDepth = e.getDepth();
                //e = lowestDepthDate;
            }

        }

        double minMagnitude = 999;
        for (Earthquake e : earthquakeArrayList){
            if (e.getDateTime().equals(selectedDate) & e.getMagnitude() < minMagnitude){
                minMagnitude = e.getMagnitude();
                //e = lowestDepthDate;
            }

        }

        double maxMagnitude = 0;
        for (Earthquake e : earthquakeArrayList){
            if (e.getDateTime().equals(selectedDate) & e.getMagnitude() > maxMagnitude){
                maxMagnitude = e.getMagnitude();
                //e = lowestDepthDate;
            }

        }

        double mostWest = 999;
        for (Earthquake e : earthquakeArrayList){
            if (e.getDateTime().equals(selectedDate) & e.getLatitude() < mostWest){
                mostWest = e.getLatitude();
                //e = lowestDepthDate;
            }
        }



        double mostEast = -999;
        for (Earthquake e : earthquakeArrayList){
            if (e.getDateTime().equals(selectedDate) & e.getLatitude() > mostEast){
                mostEast = e.getLatitude();
                //e = lowestDepthDate;
            }
        }

        double mostNorth = -999;
        for (Earthquake e : earthquakeArrayList){
            if (e.getDateTime().equals(selectedDate) & e.getLongitude() > mostNorth){
                mostNorth = e.getLongitude();
                //e = lowestDepthDate;
            }
        }



        double mostSouth = 999;
        for (Earthquake e : earthquakeArrayList){
            if (e.getDateTime().equals(selectedDate) & e.getLongitude() < mostSouth){
                mostSouth = e.getLongitude();
                //e = lowestDepthDate;
            }
        }


        Log.d(TAG, "Max value: " + maxDepth);


        Log.d(TAG, "Min Depth: " + minDepth);

        TextView textView64 = findViewById(R.id.textView64);
        textView64.setText(toString().valueOf(minDepth));

        TextView textView63 = findViewById(R.id.textView63);
        textView63.setText(toString().valueOf(maxDepth));

        TextView textView62 = findViewById(R.id.textView62);
        textView62.setText(toString().valueOf(minMagnitude));

        TextView textView61 = findViewById(R.id.textView61);
        textView61.setText(toString().valueOf(maxMagnitude));

        TextView textView60 = findViewById(R.id.textView60);
        textView60.setText(toString().valueOf(mostSouth));

        TextView textView59 = findViewById(R.id.textView59);
        textView59.setText(toString().valueOf(mostWest));

        TextView textView58 = findViewById(R.id.textView58);
        textView58.setText(toString().valueOf(mostEast));

        TextView textView57 = findViewById(R.id.textView57);
        textView57.setText(toString().valueOf(mostNorth));
    }




        @Override
        public void onNothingSelected (AdapterView < ? > arg0){
        // TODO Auto-generated method stub
    }



//
//    public final Comparator<Earthquake> cmp = new Comparator<Earthquake>() {
//        @Override
//
//        public int compare (Earthquake o1, Earthquake o2) {
//
//
//
//           // if (o2.getDateTime().equals(selectedDate) && o1.getDateTime().equals(selectedDate))
//
//            return o1.getDepth().compareTo(o2.getDepth());

//else
   // return 0;
//            if (o1.getDateTime().equals(selectedDate)) {
//                if (o2.getDateTime().equals(selectedDate)) {
//                    return 0;
//                }
//                return -1;
//            }
//        } else if (o2.getDateTime().equals(selectedDate)) {
//            return 1;
//    }
//
//                return Double.compare(o1.getDepth(), o2.getDepth());
//            }

//        }
//    };
//
//    public static final Comparator<Earthquake> cmp2 = new Comparator<Earthquake>() {
//        @Override
//        public int compare(Earthquake o1, Earthquake o2) {
//            return Double.compare(o1.getMagnitude(), o2.getMagnitude());
//        }
//    };
//
//    public static final Comparator<Earthquake> cmp3 = new Comparator<Earthquake>() {
//        @Override
//        public int compare(Earthquake o1, Earthquake o2) {
//            return Double.compare(o1.getLongitude(), o2.getLongitude());
//        }
//    };
//
//    public static final Comparator<Earthquake> cmp4 = new Comparator<Earthquake>() {
//        @Override
//        public int compare(Earthquake o1, Earthquake o2) {
//            return Double.compare(o1.getLatitude(), o2.getLatitude());
//        }
//    };



}