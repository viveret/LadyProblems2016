package com.ladyproblems16.app1;

import android.app.Activity;
import android.os.Bundle;
import android.content.Intent;

import android.view.Display;
import android.graphics.Point;

import android.widget.TextView;

import android.widget.EditText;
import android.widget.Button;

import android.view.View;
import android.widget.NumberPicker;
import android.widget.Spinner;

public class CreateProfileActivity extends Activity {

    private Button connectWithFacebook;
    private NumberPicker selectAgeNumberPicker;
    private Spinner selectGenderSpinner;
    private Spinner selectRaceSpinner;

    private EditText userFullName;
    
	public void onCreate(Bundle bundle) {
		super.onCreate(bundle);
	    setContentView(R.layout.create_profile);

        connectWithFacebook = (Button) findViewById(R.id.connect_with_facebook);
        selectAgeNumberPicker = (NumberPicker) findViewById(R.id.select_age);

        selectGenderSpinner = (Spinner) findViewById(R.id.select_gender);
        selectRaceSpinner = (Spinner) findViewById(R.id.select_race);

        userFullName = (EditText) findViewById(R.id.edit_user_full_name);

        // Load user info from somewhere
        // basically myUserDescription = blah.getUserDesc();
        if (connectWithFacebook != null) {
            connectWithFacebook.setOnClickListener(new Button.OnClickListener() {
                public void onClick(View v) {
                    // Connect Facebook profile
                }
            });
        }

        if (selectAgeNumberPicker != null) {
            //get value()

        }

        if (selectGenderSpinner != null) {
            // store gender

        } 

        if (selectRaceSpinner != null) {
            // store race
        }

        if (userFullName != null) {
            // store name
        }
 	}
}
