package com.ladyproblems16.app1;

import java.util.List;
import java.util.ArrayList;

import org.json.*;
import java.io.File;
import java.io.InputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.FileWriter;

import android.content.Context;


public class ContactManager {
    private static final String CONTACTS_FILE_LOC = "contacts.json";

    public static List<IContact> loadFromFile(Context c) {
        List<IContact> ret = new ArrayList<IContact>();
        IContact tmp = new Contact("Barbara Jones", "(206) 123-1234");
        ret.add(tmp);
        return ret;
        /*File fin = new File(c.getFilesDir(), CONTACTS_FILE_LOC);

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
                return ret;
            }

            try {
                JSONArray ar = new JSONArray(json);
                for (int i = 0; i < ar.length(); i++) {
                    JSONObject o = ar.getJSONObject(i);
                    ISerializable tmpParams = new Serializable();
                
                    tmpParams.setInt("id", o.getInt("id"));
                    tmpParams.setString("number", o.getString("number"));
                    tmpParams.setString("name", o.getString("name"));

                    ret.add(new Contact(tmpParams));
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return ret;
        } else {
            return ret;
            }*/
    }
    
    public static void writeToFile(Context c, List<IContact> self) {
        try {
            JSONArray ar = new JSONArray();
            for (IContact e : self) {
                JSONObject o = new JSONObject();
                o.put("name", e.getName());
                o.put("number", e.getNumber());
                o.put("id", e.getId());
                ar.put(o);
            }

            FileWriter fout = new FileWriter(new File(c.getFilesDir(), CONTACTS_FILE_LOC));
            fout.write(ar.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
