package com.ladyproblems16.app1;

import java.util.Map;
import java.util.NoSuchElementException;

public class Serializable implements ISerializable {

    private Map<String, Object> myValues;

    public int getInt(String key) {
        if (myValues.containsKey(key)) {
            if (myValues.get(key) instanceof Integer) {
                return ((Integer) myValues.get(key)).intValue();
            } else {
                throw new IllegalArgumentException();
            }
        } else {
            throw new NoSuchElementException();
        }
    }
    
    public String getString(String key) {
        if (myValues.containsKey(key)) {
            if (myValues.get(key) instanceof String) {
                return (String) myValues.get(key);
            } else {
                throw new IllegalArgumentException();
            }
        } else {
            throw new NoSuchElementException();
        }
    }
    
    public ISerializable getSerializable(String key) {
        if (myValues.containsKey(key)) {
            if (myValues.get(key) instanceof ISerializable) {
                return (ISerializable) myValues.get(key);
            } else {
                throw new IllegalArgumentException();
            }
        } else {
            throw new NoSuchElementException();
        }
    }
    
    public void setInt(String key, int val) {
        myValues.put(key, new Integer(val));
    }
    
    public void setString(String key, String val) {
        myValues.put(key, val);
    }
    
    public void setSerializable(String key, ISerializable val) {
        myValues.put(key, val);
    }
}
