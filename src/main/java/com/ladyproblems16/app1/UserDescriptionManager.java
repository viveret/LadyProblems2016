package com.ladyproblems16.app1;

import org.json.*;
import java.io.File;
import java.io.InputStream;
import java.io.FileInputStream;
import java.io.IOException;

import java.io.FileWriter;

import android.content.Context;

public class UserDescriptionManager {
    private static final String USER_FILE_LOC = "userDesc.json";

    public static boolean exists(Context c) {
        return true;//File fin = new File(c.getFilesDir(), USER_FILE_LOC);
        //return fin.exists();
    }

    public static IUserDescription loadFromFile(Context c) {
        /*File fin = new File(c.getFilesDir(), USER_FILE_LOC);
        if (fin.exists()) {
            String json = null;
            try {
                InputStream is = new FileInputStream(fin);
                int size = is.available();
                byte[] buffer = new byte[size];
                is.read(buffer);
                is.close();
                json = new String(buffer, "UTF-8");
            } catch (IOException ex) {
                ex.printStackTrace();
                return new UserDescription();
            }

            try {
                JSONObject o = new JSONObject(json);
                ISerializable tmpParams = new Serializable();
            
                tmpParams.setInt("age", o.getInt("age"));
                tmpParams.setString("gender", o.getString("gender"));
                tmpParams.setString("ethnicityRace", o.getString("ethnicityRace"));
                tmpParams.setString("name", o.getString("name"));

                return new UserDescription(tmpParams);
            } catch (JSONException e) {
                e.printStackTrace();
                return new UserDescription();
            }
        } else {
            return new UserDescription();
            }*/
        IUserDescription ret = new UserDescription();
        ret.setAge(20);
        ret.setGender("Female");
        ret.setEthnicityRace("Native American");
        ret.setFullName("Samantha");

        return ret;
    }
    
    public static void writeToFile(Context c, IUserDescription self) {
        try {
            JSONObject o = new JSONObject();
            o.put("name", self.getFullName());
            o.put("gender", self.getGender());
            o.put("ethnicityRace", self.getEthnicityRace());
            o.put("age", self.getAge());

            FileWriter fout = new FileWriter(new File(c.getFilesDir(), USER_FILE_LOC));
            fout.write(o.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
