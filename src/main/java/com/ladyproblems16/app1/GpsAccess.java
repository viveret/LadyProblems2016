package com.ladyproblems2016.app1;



public class GpsAccess implements IGpsAccess {
    public void init() {
        
    }

    @Override
    public double getLatitude() {
        return 0;
    }
    
    public double getLongitude() {
        return 0;
    }
    
    public String getStreetAddress() {
        return "";
    }
    
    public String getCity() {
        return "";
    }
    
    public String getState() {
        return "";
    }

    public int getZipcode() {
        return 0;
    }
}
