package com.example.seannotman;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MainActivity4 extends AppCompatActivity implements OnMapReadyCallback {

    private static final String TAG = "MapsActivity";
    private GoogleMap mMap;
    String preEarthquakeLat;
    String preEarthquakeLong;
    String earthquakeMarkerTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        Intent intent = getIntent();
        FeedEntry earthquakeItem = intent.getParcelableExtra("Example Item");

        String earthquakeName = earthquakeItem.getName();
        String earthquakeMagnitude = earthquakeItem.getMagnitude();
        String earthquakeDepth = earthquakeItem.getDepth();

        String earthquakeMarker = earthquakeItem.getLocation();
        earthquakeMarkerTitle = earthquakeMarker;

        preEarthquakeLat = earthquakeItem.getLatitude();
        preEarthquakeLong = earthquakeItem.getLongitude();



        TextView textView1 = findViewById(R.id.activity4_textView);
        textView1.setText(earthquakeName);

        TextView textView2 = findViewById(R.id.activity4_textView2);
        textView2.setText(earthquakeMagnitude);

        TextView textView3 = findViewById(R.id.activity4_textView3);
        textView3.setText(earthquakeDepth);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);



        Log.d(TAG, "onMaps: ");



    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        double Latd = Double.parseDouble(preEarthquakeLat);
        double Longd = Double.parseDouble(preEarthquakeLong);

        // Add a marker in Sydney and move the camera
        LatLng earthquakeLocation = new LatLng(Latd, Longd);

        Log.d(TAG, "LatLngs: " + earthquakeLocation);

        mMap.addMarker(new MarkerOptions().position(earthquakeLocation).title(earthquakeMarkerTitle));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(earthquakeLocation));
    }



}
