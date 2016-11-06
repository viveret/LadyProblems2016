package com.ladyproblems16.app1;

public interface ISerializable {
    int getInt(String key);
    String getString(String key);
    ISerializable getSerializable(String key);
}
