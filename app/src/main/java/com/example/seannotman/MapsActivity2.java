package com.example.seannotman;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.annotation.DrawableRes;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.util.Log;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import android.graphics.Bitmap;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;

import static android.content.ContentValues.TAG;

public class MapsActivity2 extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private static final String TAG = "MapsActivity";
    private ArrayList<Earthquake> earthquakeArrayList;


    //private MarkerOptions options = new MarkerOptions();
    Double EarthquakeLat;
    Double EarthquakeLong;
    String earthquakeMarkerTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps2);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        Intent intentEarthquakeList = getIntent();
        earthquakeArrayList = intentEarthquakeList.getParcelableArrayListExtra("EarthquakeList");

    }



    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        for (Earthquake e : earthquakeArrayList) {
            EarthquakeLat = e.getLatitude();
            //Log.d(TAG, "prelatttt " + preEarthquakeLat);
            EarthquakeLong = e.getLongitude();
            //Log.d(TAG, "prelongggg " + preEarthquakeLong);
            earthquakeMarkerTitle = e.getLocation();
            Log.d(TAG, "titleeee " + earthquakeMarkerTitle);

            double Magnitude = e.getMagnitude();
            //double Latd = Double.parseDouble(preEarthquakeLat);
            //double Longd = Double.parseDouble(preEarthquakeLong);
//
//
            LatLng earthquakeLocation = new LatLng(EarthquakeLat, EarthquakeLong);
            Log.d(TAG, "LatLngs: " + earthquakeLocation);

            //Bitmap icon = BitmapFactory.decodeResource(getResources(),R.drawable.magnitude_medium);


//.icon(bitmapDescriptorFromVector(this, R.drawable.ic_car_white_24dp));

            //  Bitmap.createBitmap(mapManager.getMarkerColor());

            if (Magnitude >= 3) {
                mMap.addMarker(new MarkerOptions().position(earthquakeLocation).title(earthquakeMarkerTitle).icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_mag_med)));
                //  mMap.moveCamera(CameraUpdateFactory.newLatLng(earthquakeLocation));
            }


            else  if (Magnitude >=2 && Magnitude < 3) {
                mMap.addMarker(new MarkerOptions().position(earthquakeLocation).title(earthquakeMarkerTitle).icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_mag_med)));

            }
        else  if (Magnitude >=1 && Magnitude < 2) {
              mMap.addMarker(new MarkerOptions().position(earthquakeLocation).title(earthquakeMarkerTitle).icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_mag_low)));
//
           }
//            else  if (Magnitude >=0 && Magnitude < 1) {
//                mMap.addMarker(new MarkerOptions().position(earthquakeLocation).title(earthquakeMarkerTitle).icon(bitmapDescriptorFromVectorVeryLow(this, R.drawable.magnitude_verylow)));
//
//            }

            else {
                Log.d(TAG, "Error - magnitude below zero");
            }

        }
    }


}
