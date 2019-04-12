package com.example.seannotman;



import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;
import java.util.HashMap;



import java.util.ArrayList;
import java.util.List;


public class FeedAdapter extends ArrayAdapter implements Filterable {
    private static final String TAG = "FeedAdapter";
    private final int layoutResource;
    private final LayoutInflater layoutInflater;
    private List<FeedEntry> applications;
    private List<FeedEntry> listCopyFull;

    public FeedAdapter(Context context, int resource, List<FeedEntry> applications) {
        super(context, resource);
        this.layoutResource = resource;
        this.layoutInflater = LayoutInflater.from(context);
        this.applications = applications;
        listCopyFull = new ArrayList<>(applications);
    }

    @Override
    public int getCount() {
        return applications.size();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null) {
            convertView = layoutInflater.inflate(layoutResource, parent, false);
        }
        TextView locationText = (TextView) convertView.findViewById(R.id.earthquakeLocation);
        TextView dayText = (TextView) convertView.findViewById(R.id.tvArtist);
        //   TextView tvSummary = (TextView) convertView.findViewById(R.id.tvSummary);

        FeedEntry earthquakeItem = applications.get(position);

        String desc = earthquakeItem.getName();

        //https://www.youtube.com/watch?v=sJ-Z9G0SDhc



        String[] splitDescription = desc.split(";", -1);

        String[] dayDateTime = splitDescription[0].split(":", -1);

        String[] daySplit = dayDateTime[1].split(",", -1);

        String day = daySplit[0];

        String dateTime = daySplit[1];

        earthquakeItem.setDateTime(dateTime);
        //  currentApp.setDay(day);

        Log.d(TAG, "getDay: " + day);


        earthquakeItem.setDay(day);

        dayText.setText(day);

        Log.d(TAG, "getEarthquake set: " + earthquakeItem.getDay());

        String[] locationSplit = splitDescription[1].split(":", -1);

        Log.d(TAG, "getLocation: " + locationSplit[1]);

        String location = locationSplit[1];

        earthquakeItem.setLocation(location);

        //Set name text as Location
        locationText.setText(location);

        String[] LatLong = splitDescription[2].split(":", -1);
        Log.d(TAG, "getLatLong: " + LatLong[1]);
        String[] Lat = LatLong[1].split(",", -1);

        String Latitude = Lat[0];
        String Longitude = Lat[1];
        Log.d(TAG, "getLat: " + Latitude);
        Log.d(TAG, "getLong: " + Longitude);




        earthquakeItem.setLatitude(Latitude);
        earthquakeItem.setLongitude(Longitude);



        String[] splitDepth = splitDescription[3].split(":", -1);
        String depth = splitDepth[1];
        Log.d(TAG, "getDepth: " + depth);



        earthquakeItem.setDepth(depth);



        String[] splitMagnitude = splitDescription[4].split(":", -1);
        String magnitude = splitMagnitude[1];
        Log.d(TAG, "getMagnitude: " + magnitude);



        earthquakeItem.setMagnitude(magnitude);


        //tvName.setText(location[1]);
        //   tvArtist.setText(currentApp.getArtist());
//        tvSummary.setText(currentApp.getSummary());

        return convertView;
    }


 @Override
 public Filter getFilter() {
 return exampleFilter;
 }

 private Filter exampleFilter = new Filter() {

 @Override
 protected FilterResults performFiltering(CharSequence constraint) {

 List<FeedEntry> filteredList = new ArrayList<>();


 //if no entry then show full list
 if (constraint == null || constraint.length() == 0) {
 filteredList.addAll(listCopyFull);
 } else {

 //not case sensitive trim removes spaces
 String filterPattern = constraint.toString().toLowerCase().trim();

 for (FeedEntry item : listCopyFull) {
 if (item.getName().toLowerCase().contains(filterPattern)) {
 filteredList.add(item);
 }
 }

 }

 FilterResults results = new FilterResults();
 results.values = filteredList;

 return results;

 }

 @Override
 protected void publishResults(CharSequence constraint, FilterResults results) {
 applications.clear();
 applications.addAll((List) results.values);
 notifyDataSetChanged();
 }
 };

}




