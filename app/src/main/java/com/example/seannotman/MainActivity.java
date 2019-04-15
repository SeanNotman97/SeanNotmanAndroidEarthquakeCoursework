package com.example.seannotman;


import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.MenuInflater;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ListView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private static final String TAG = "MainActivity";
    private ListView listApps;
    private FeedAdapter adapter;
    private ArrayList<Earthquake> earthquakeArrayList;

   // DatabaseHelper listdatabaseHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        listApps = findViewById(R.id.xmlListView);



        Log.d(TAG, "onCreate: starting Asynctask");
        DownloadData downloadData = new DownloadData();
        downloadData.execute("http://quakes.bgs.ac.uk/feeds/MhSeismology.xml");
        Log.d(TAG, "onCreate: done");




        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }


    private class DownloadData extends AsyncTask<String, Void, String> {
        private static final String TAG = "DownloadData";

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            //Log.d(TAG, "onPostExecute: parameter is " + s);
            final ParseEarthquakes parseEarthquakes = new ParseEarthquakes();
            parseEarthquakes.parse(s);




            earthquakeArrayList = parseEarthquakes.getApplications();
for(Earthquake earthquakeItem : earthquakeArrayList){

    String desc = earthquakeItem.getName();

    //https://www.youtube.com/watch?v=sJ-Z9G0SDhc

    String[] splitDescription = desc.split(";", -1);

    String[] dayDateTime = splitDescription[0].split(":", -1);

    String[] daySplit = dayDateTime[1].split(",", -1);

    String day = daySplit[0];

    String dateTimeSplit = daySplit[1];

   // Log.d(TAG, "dayTimeSplit" + dateTimeSplit);

    String[] dateTime1 = dateTimeSplit.split(" ", -1);

    String dateTime = dateTime1[1];

    String dateTimea1 = dateTime1[2];

    String dateTimea2 = dateTime1[3];

    String dateTimea3 = (dateTime + " " + dateTimea1 + " " + dateTimea2);

    //Log.d(TAG, "dateTime " + dateTimea3);

    earthquakeItem.setDateTime(dateTimea3);
    //  currentApp.setDay(day);

    Log.d(TAG, "getDate: " + dateTimea3);

    earthquakeItem.setDay(day);
//
//    String timeSplit1 = dateTime1[4];

    //Log.d(TAG, "TimeSplit " + timeSplit1);

//    String[] timeSplit2 = splitDescription[0].split(":", -1);
//
    String timeSplit3 = dateTime1[4];
//
   String timeSplit4 = dayDateTime[2];
//
   String timeSplit5 = dayDateTime[3];

   // Log.d(TAG, "ts1 " + "/" + timeSplit3 + "/" + timeSplit4 + "/" + timeSplit5);

    earthquakeItem.seteTime(timeSplit3 + ":" + timeSplit4 + ":" + timeSplit5);
//    Log.d(TAG, "timesplit3: " + timeSplit3);
//    Log.d(TAG, "timeSplit4" + timeSplit4);
//    Log.d(TAG, "tuneSplit5" + timeSplit5);






   // Log.d(TAG, "getEarthquake set: " + earthquakeItem.getDay());

    String[] locationSplit = splitDescription[1].split(":", -1);

    //Log.d(TAG, "getLocation: " + locationSplit[1]);

    String location = locationSplit[1];

    earthquakeItem.setLocation(location);

    //Set name text as Location


    String[] LatLong = splitDescription[2].split(":", -1);
   // Log.d(TAG, "getLatLong: " + LatLong[1]);
    String[] Lat = LatLong[1].split(",", -1);

    String Latitude = Lat[0];
    String Longitude = Lat[1];
    //Log.d(TAG, "getLat: " + Latitude);
    //Log.d(TAG, "getLong: " + Longitude);


    earthquakeItem.setLatitude(Double.valueOf(Latitude));
    earthquakeItem.setLongitude(Double.valueOf(Longitude));



    String[] splitDepth = splitDescription[3].split(":", -1);

    String[] splitDepth2 = splitDepth[1].split(" ", -1);

    String[] splitDepth3 = splitDepth2[1].split(" ", -1);

    String depth = splitDepth3[0];

    Log.d(TAG, "onPostExecute: " + depth);



    earthquakeItem.setDepth(Double.valueOf(depth));



    String[] splitMagnitude = splitDescription[4].split(":", -1);
    String magnitude = splitMagnitude[1];
   // Log.d(TAG, "getMagnitude: " + magnitude);



    earthquakeItem.setMagnitude(Double.valueOf(magnitude));

   // Log.d(TAG, "onPostExecute: " + earthquakeItem.toString());



}

            adapter = new FeedAdapter(MainActivity.this, R.layout.list_record, earthquakeArrayList);
            listApps.setAdapter(adapter);



            listApps.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Intent intent = new Intent(MainActivity.this, MainActivity4.class);
                    intent.putExtra("Example Item", earthquakeArrayList.get(position));

                    startActivity(intent);
                }
            });



        }

        @Override
        protected String doInBackground(String... strings) {
            Log.d(TAG, "doInBackground: starts with " + strings[0]);
            String rssFeed = downloadXML(strings[0]);
            if(rssFeed == null) {
                Log.e(TAG, "doInBackground: Error downloading");
            }
            return rssFeed;
        }

        private String downloadXML(String urlPath) {
            StringBuilder xmlResult = new StringBuilder();

            try {
                URL url = new URL(urlPath);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                int response = connection.getResponseCode();
                Log.d(TAG, "downloadXML: The response code was " + response);
//                InputStream inputStream = connection.getInputStream();
//                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
//                BufferedReader reader = new BufferedReader(inputStreamReader);
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));

                int charsRead;
                char[] inputBuffer = new char[500];
                while(true) {
                    charsRead = reader.read(inputBuffer);
                    if(charsRead < 0) {
                        break;
                    }
                    if(charsRead > 0) {
                        xmlResult.append(String.copyValueOf(inputBuffer, 0, charsRead));
                    }
                }
                reader.close();

                return xmlResult.toString();
            } catch(MalformedURLException e) {
                Log.e(TAG, "downloadXML: Invalid URL " + e.getMessage());
            } catch(IOException e) {
                Log.e(TAG, "downloadXML: IO Exception reading data: " + e.getMessage());
            } catch(SecurityException e) {
                Log.e(TAG, "downloadXML: Security Exception.  Needs permisson? " + e.getMessage());
//                e.printStackTrace();
            }

            return null;
        }
    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_search, menu);

        MenuItem searchItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) searchItem.getActionView();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.getFilter().filter(newText);
                return false;
            }
        });
        return true;
    }
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }
//
//        return super.onOptionsItemSelected(item);
//    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
//        final ParseEarthquakes parseEarthquakes = new ParseEarthquakes();

        if (id == R.id.nav_map) {

            Intent intentEarthquakeMap = new Intent(MainActivity.this, MapsActivity2.class);
            intentEarthquakeMap.putParcelableArrayListExtra("EarthquakeList", earthquakeArrayList);
            // intentEarthquakeList.putExtra("EarthquakeList", earthquakeArrayList);

            startActivity(intentEarthquakeMap);

        } else if (id == R.id.nav_dateSearch) {

            Intent intentEarthquakeList = new Intent(MainActivity.this, MainActivity5.class);
            intentEarthquakeList.putParcelableArrayListExtra("EarthquakeList", earthquakeArrayList);
           // intentEarthquakeList.putExtra("EarthquakeList", earthquakeArrayList);

            startActivity(intentEarthquakeList);

        } else if (id == R.id.nav_slideshow) {


        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
