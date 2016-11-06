package com.ladyproblems16.app1;

import java.util.List;

import java.io.IOException;

import android.widget.Toast;

import android.os.Bundle;
import android.content.Context;
import android.location.*;

public class GpsAccess implements IGpsAccess, LocationListener {
    private Context c;
    private LocationManager locationManager;
    private Location myLoc;

    private Geocoder myGeocoder;
    private Address geocode;

    private GpsReady myCallback;

    public GpsAccess(Context theC, GpsReady gps) {
        c = theC;
        myCallback = gps;
        myGeocoder = new Geocoder(c);
        resume();
    }
    
    public GpsAccess(Context theC) {
        this(theC, null);
    }

    @Override
    public void setWhenReady(GpsReady gps) {
        if (myLoc != null) {
            gps.onReady(this);
        } else {
            myCallback = gps;
        }
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
        locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0, this);
    }

    @Override
    public void onLocationChanged(final Location location) {
        myLoc = location;

        Toast.makeText(c, "awdawdawdawd ", Toast.LENGTH_SHORT).show();
        if (myLoc != null) {
            if (myCallback != null) {
                myCallback.onReady(this);
                myCallback = null;
            }
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
    }

    @Override
    public double getLatitude() {
        if (myLoc != null) {
            return myLoc.getLatitude();
        } else {
            return 0;
        }
    }
    
    @Override
    public double getLongitude() {
        if (myLoc != null) {
            return myLoc.getLongitude();
        } else {
            return 0;
        }
    }
    
    @Override
    public String getStreetAddress() {
        if (geocode != null) {
            /*StringBuilder sb = new StringBuilder();
            if (geocode.getFeatureName() != null)
                sb.append(geocode.getFeatureName() + " ");

            if (geocode.getThoroughfare() != null)
                sb.append(geocode.getThoroughfare() + " ");

            if (geocode.getMaxAddressLineIndex() > 0) {
                if (geocode.getAddressLine(0) != null) {
                    sb.append(geocode.getAddressLine(0));
                }
            }
            
            return sb.toString();*/
            String addressLine = "";
            for (int i = 0; i < geocode.getMaxAddressLineIndex(); i++) {
                if (addressLine != "") addressLine += ", ";
                addressLine += geocode.getAddressLine(i);
            }
            return addressLine;
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
