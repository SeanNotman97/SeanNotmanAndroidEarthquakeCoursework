package com.example.seannotman;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;

public class MapsActivity2 extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private static final String TAG = "MapsActivity";
    private ArrayList<Earthquake> earthquakeArrayList;
    //private MarkerOptions options = new MarkerOptions();
    String preEarthquakeLat;
    String preEarthquakeLong;
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
            preEarthquakeLat = e.getLatitude();
            Log.d(TAG, "prelatttt " + preEarthquakeLat);
            preEarthquakeLong = e.getLongitude();
            Log.d(TAG, "prelongggg " + preEarthquakeLong);
            earthquakeMarkerTitle = e.getLocation();
            Log.d(TAG, "titleeee " + earthquakeMarkerTitle);


            double Latd = Double.parseDouble(preEarthquakeLat);
            double Longd = Double.parseDouble(preEarthquakeLong);
//
//
            LatLng earthquakeLocation = new LatLng(Latd, Longd);

            Log.d(TAG, "LatLngs: " + earthquakeLocation);
//
//            mMap.addMarker(new MarkerOptions().position(earthquakeLocation)
//                    .title(earthquakeMarkerTitle))
//                    .icon(BitmapDescriptorFactory.fromResource())
            //mMap.moveCamera(CameraUpdateFactory.newLatLng(earthquakeLocation));
        }
    }
}
