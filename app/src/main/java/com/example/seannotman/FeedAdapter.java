package com.example.seannotman;



import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;


import java.util.ArrayList;
import java.util.List;


public class FeedAdapter extends ArrayAdapter implements Filterable {
    private static final String TAG = "FeedAdapter";
    private final int layoutResource;
    private final LayoutInflater layoutInflater;
    private List<Earthquake> applications;
    private List<Earthquake> listCopyFull;

    public FeedAdapter(Context context, int resource, List<Earthquake> applications) {
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

        Earthquake earthquakeItem = applications.get(position);

       // String desc = earthquakeItem.getName();

        //https://www.youtube.com/watch?v=sJ-Z9G0SDhc

        dayText.setText(earthquakeItem.getDay());
        locationText.setText(earthquakeItem.getLocation());

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

 List<Earthquake> filteredList = new ArrayList<>();


 //if no entry then show full list
 if (constraint == null || constraint.length() == 0) {
 filteredList.addAll(listCopyFull);
 } else {

 //not case sensitive trim removes spaces
 String filterPattern = constraint.toString().toLowerCase().trim();

 for (Earthquake item : listCopyFull) {
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




