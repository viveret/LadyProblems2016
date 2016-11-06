package com.ladyproblems16.app1;

public interface IGpsAccess {
    double getLatitude();
    double getLongitude();

    String getStreetAddress();
    String getCity();
    String getState();

    String getZipcode();

    void pause();
    void resume();

    boolean isAvailable();
}
