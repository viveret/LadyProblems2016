package com.ladyproblems16.app1;
import java.util.Scanner;
import java.util.concurrent.locks.AbstractOwnableSynchronizer;

/**
 * Created by Kristi Anna on 11/5/2016.
 */

public class UserDescription implements IUserDescription{

    //Initialize Variables
    private String myFullName = "";

    private int age = 0;

    private String gender = "";

    private String ethnicityRace = "";


    public UserDescription(ISerializable params) {
        setFullName(params.getString("name"));
        setEthnicityRace(params.getString("ethnicityRace"));
        setAge(params.getInt("age"));
        setGender(params.getString("gender"));
    }

    public UserDescription() {
        setFullName("");
        setEthnicityRace("");
        setAge(0);
        setGender("");
    }

    @Override
    public String getFullName() {
        return myFullName;
    }

    @Override
    public void setFullName(String val) {
        myFullName = val;
    }
    
    @Override
    public int getAge() {
        return age;
    }
    @Override
    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String getGender() {
        return gender;
    }
    @Override
    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String getEthnicityRace() {
        return ethnicityRace;
    }
    @Override
    public void setEthnicityRace(String ethnicityRace) {
        this.ethnicityRace = ethnicityRace;
    }
}
