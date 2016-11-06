package com.ladyproblems16.app1;

import java.util.List;

import java.io.IOException;

import android.os.Bundle;
import android.content.Context;
import android.location.*;

public class GpsAccess implements IGpsAccess, LocationListener {
    private Context c;
    private LocationManager locationManager;
    private Location myLoc;

    private Geocoder myGeocoder;
    
    private Address geocode;

    public GpsAccess(Context theC) {
        c = theC;
        myGeocoder = new Geocoder(c);
        resume();
    }

    @Override
    public void pause() {
        locationManager.removeUpdates(this);
        locationManager = null;
    }

    @Override
    public void resume() {
        locationManager = (LocationManager) c.getSystemService(Context.LOCATION_SERVICE);
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, this);
    }

    @Override
    public void onLocationChanged(final Location location) {
        myLoc = location;

        try {
            List<Address> tmpGeocodes = myGeocoder.getFromLocation(getLatitude(), getLongitude(), 1);
            if (tmpGeocodes.size() > 0) {
                geocode = tmpGeocodes.get(0);
            } else {
                geocode = null;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public double getLatitude() {
        return myLoc.getLatitude();
    }
    
    @Override
    public double getLongitude() {
        return myLoc.getLongitude();
    }
    
    @Override
    public String getStreetAddress() {
        if (geocode != null) {
            StringBuilder sb = new StringBuilder();
            if (geocode.getFeatureName() != null)
                sb.append(geocode.getFeatureName());

            if (geocode.getThoroughfare() != null)
                sb.append("");
            
            return sb.toString();
        } else {
            return "";
        }
    }
    
    @Override
    public String getCity() {
        if (geocode != null) {
            return geocode.getLocality();
        } else {
            return "";
        }
    }
    
    @Override
    public String getState() {
        if (geocode != null) {
            return geocode.getAdminArea();
        } else {
            return "";
        }
    }

    @Override
    public String getZipcode(){
        if (geocode != null) {
            return geocode.getPostalCode();
        } else {
            return "";
        }
    }

    @Override
    public boolean isAvailable() {
        return Geocoder.isPresent();
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {
    }

    @Override
    public void onProviderEnabled(String provider) {
    }

    @Override
    public void onProviderDisabled(String provider) {
    }
}
