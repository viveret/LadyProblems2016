package com.ladyproblems2016.app1;

public interface IGpsAccess {
    void init();

    double getLatitude();
    double getLongitude();

    String getStreetAddress();
    String getCity();
    String getState();

    int getZipcode();
}
