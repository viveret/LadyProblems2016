package com.ladyproblems16.app1;
import java.util.Scanner;
import java.util.concurrent.locks.AbstractOwnableSynchronizer;

/**
 * Created by Kristi Anna on 11/5/2016.
 */

public class UserDescription implements IUserDescription{

    //Initialize Variables
    private String firstName = "";
    private String lastName = "";

    private int age = 0;

    private String gender = "";

    private String ethnicityRace = "";


    //Getters and Setters
    @Override
    public String getFirstName() {
        return firstName;
    }
    @Override
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Override
    public String getLastName() {
        return lastName;
    }
    @Override
    public void setLastName(String lastName) {
        this.lastName = lastName;
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
