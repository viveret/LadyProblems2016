package com.ladyproblems16.app1;

/**
 * Created by Kristi Anna on 11/5/2016.
 */

public interface IUserDescription {
    String getFirstName();
    String getLastName();

    String getFullName();

    int getAge();

    String getGender();

    String getEthnicityRace();

    void setFirstName(String lastName);
    void setLastName(String firstName);

    void setAge(int age);

    void setGender(String gender);

    void setEthnicityRace(String ethnicityRace);
}
