package com.ladyproblems16.app1;

/**
 * Created by Kristi Anna on 11/5/2016.
 */

public interface IUserDescription {
    String getFullName();

    int getAge();

    String getGender();

    String getEthnicityRace();

    void setFullName(String name);

    void setAge(int age);

    void setGender(String gender);

    void setEthnicityRace(String ethnicityRace);
}
