package com.ladyproblems2016.app1;

public interface ISerializable {
    int getInt(String key);
    String getString(String key);
    ISerializable getSerializable(String key);
}
