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

    void setWhenReady(GpsReady gps);

    public static interface GpsReady {
        void onReady(IGpsAccess gps);
    }
}
