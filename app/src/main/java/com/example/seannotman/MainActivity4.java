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
    Double EarthquakeLat;
    Double EarthquakeLong;
    String earthquakeMarkerTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        Intent intent = getIntent();
        Earthquake earthquakeItem = intent.getParcelableExtra("Example Item");

        String earthquakeName = earthquakeItem.getLocation();
        Double earthquakeMagnitude = earthquakeItem.getMagnitude();
        Double earthquakeDepth = earthquakeItem.getDepth();
        String earthquakeTime = earthquakeItem.geteTime();
        String earthquakeDay = earthquakeItem.getDay();
        String earthquakeDate = earthquakeItem.getDateTime();



        String earthquakeMarker = earthquakeItem.getLocation();
        earthquakeMarkerTitle = earthquakeMarker;

        EarthquakeLat = earthquakeItem.getLatitude();
        EarthquakeLong = earthquakeItem.getLongitude();



        TextView textView1 = findViewById(R.id.activity4_textView);
        textView1.setText(earthquakeName);

        TextView textView2 = findViewById(R.id.activity4_textView2);
        textView2.setText(earthquakeMagnitude.toString());

        TextView textView3 = findViewById(R.id.activity4_textView3);
        textView3.setText(earthquakeDepth.toString());

        TextView textView4 = findViewById(R.id.textView3);
        textView4.setText(earthquakeDate);

        TextView textView5 = findViewById(R.id.textView6);
       textView5.setText(earthquakeDay);

        TextView textView7 = findViewById(R.id.textView7);
        textView7.setText(earthquakeTime);





        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);



        Log.d(TAG, "onMaps: ");



    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        // Add a marker in Sydney and move the camera
        LatLng earthquakeLocation = new LatLng(EarthquakeLat, EarthquakeLong);

        Log.d(TAG, "LatLngs: " + earthquakeLocation);

        mMap.addMarker(new MarkerOptions().position(earthquakeLocation).title(earthquakeMarkerTitle));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(earthquakeLocation));
        mMap.animateCamera( CameraUpdateFactory.zoomTo( 12.0f ) );
    }



}
