package com.ladyproblems2016.app1;



public class GpsAccess implements IGpsAccess {
    void init() {
        
    }

    @Override
    double getLatitude() {
        return 0;
    }
    
    double getLongitude() {
        return 0;
    }
    
    String getStreetAddress() {
        return "";
    }
    
    String getCity() {
        return "";
    }
    
    String getState() {
        return "";
    }

    int getZipcode() {
        return 0;
    }


    awd(){
        IGpsAccess gps = API.getGps();
        gps.getZipcode();
        
    }
}
