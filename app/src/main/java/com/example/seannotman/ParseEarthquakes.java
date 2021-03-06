package com.example.seannotman;


import android.util.Log;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.StringReader;
import java.util.ArrayList;



public class ParseEarthquakes {
    private static final String TAG = "ParseEarthquakes";
    private ArrayList<Earthquake> applications;

    public ParseEarthquakes() {
        this.applications = new ArrayList<>();
    }

    public ArrayList<Earthquake> getApplications() {
        return applications;
    }

    public boolean parse(String xmlData) {
        boolean status = true;
        Earthquake currentRecord = null;
        boolean inEntry = false;
        String textValue = "";

        try {
            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
            factory.setNamespaceAware(true);
            XmlPullParser xpp = factory.newPullParser();
            xpp.setInput(new StringReader(xmlData));
            int eventType = xpp.getEventType();
            while(eventType != XmlPullParser.END_DOCUMENT) {
                String tagName = xpp.getName();
                switch (eventType) {
                    case XmlPullParser.START_TAG:
                      //  Log.d(TAG, "parse: Starting tag for " + tagName);
                        if("item".equalsIgnoreCase(tagName)) {
                            inEntry = true;
                            currentRecord = new Earthquake();
                        }
                        break;

                    case XmlPullParser.TEXT:
                        textValue = xpp.getText();
                        break;

                    case XmlPullParser.END_TAG:
                       // Log.d(TAG, "parse: Ending tag for " + tagName);
                        if(inEntry) {
                            if("item".equalsIgnoreCase(tagName)) {
                                applications.add(currentRecord);
                                inEntry = false;
                            } else if("description".equalsIgnoreCase(tagName)) {
                                currentRecord.setName(textValue);

                            }

//                            else if("artist".equalsIgnoreCase(tagName)) {
//                                currentRecord.setArtist(textValue);
//                            } else if("releaseDate".equalsIgnoreCase(tagName)) {
//                                currentRecord.setReleaseDate(textValue);
//                            } else if("summary".equalsIgnoreCase(tagName)) {
//                                currentRecord.setSummary(textValue);
//                            } else if("image".equalsIgnoreCase(tagName)) {
//                                currentRecord.setImageURL(textValue);
//                            }
                        }
                        break;

                    default:
                        // Nothing else to do.
                }
                eventType = xpp.next();

            }
            for (Earthquake app: applications) {
                Log.d(TAG, "******************");
                Log.d(TAG, app.toString());
            }

        } catch(Exception e) {
            status = false;
            e.printStackTrace();
        }
        return status;
    }
}