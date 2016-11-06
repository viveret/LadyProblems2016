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
import android.widget.ArrayAdapter;

public class CreateProfileActivity extends Activity {

    private Button connectWithFacebook;
    private Button nextButton;
    private NumberPicker selectAgeNumberPicker;
    private Spinner selectGenderSpinner;
    private Spinner selectRaceSpinner;

    private EditText userFullName;
    
	public void onCreate(Bundle bundle) {
		super.onCreate(bundle);
	    setContentView(R.layout.create_profile);

        connectWithFacebook = (Button) findViewById(R.id.connect_with_facebook);
        nextButton = (Button) findViewById(R.id.go_next_button);

        selectAgeNumberPicker = (NumberPicker) findViewById(R.id.select_age);

        selectGenderSpinner = (Spinner) findViewById(R.id.select_gender);
        selectRaceSpinner = (Spinner) findViewById(R.id.select_race);

        userFullName = (EditText) findViewById(R.id.edit_user_full_name);

        String[] ops = getResources().getStringArray(R.array.gender);
        ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, ops);
        spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        selectGenderSpinner.setAdapter(spinnerArrayAdapter);

        String[] ops2 = getResources().getStringArray(R.array.ethnicityRace);
        ArrayAdapter<String> ethnicityRaceArrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, ops2);
        ethnicityRaceArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        selectRaceSpinner.setAdapter(ethnicityRaceArrayAdapter);

        // Load user info from somewhere
        // basically myUserDescription = blah.getUserDesc();
        if (connectWithFacebook != null) {
            connectWithFacebook.setOnClickListener(new Button.OnClickListener() {
                public void onClick(View v) {
                    // Connect Facebook profile
                }
            });
        }

        if (UserDescriptionManager.exists(this)) {
            IUserDescription tmp = UserDescriptionManager.loadFromFile(this);
            selectGenderSpinner.setSelection(((ArrayAdapter)selectGenderSpinner.getAdapter()).getPosition(tmp.getGender()));
            selectRaceSpinner.setSelection(((ArrayAdapter)selectRaceSpinner.getAdapter()).getPosition(tmp.getEthnicityRace()));
            selectAgeNumberPicker.setValue(tmp.getAge());
            userFullName.setText(tmp.getFullName());
        }
        
        if (nextButton != null) {
            nextButton.setOnClickListener(new Button.OnClickListener() {
                public void onClick(View v) {
                    IUserDescription tmp = new UserDescription();
                    tmp.setFullName(userFullName.getText().toString());
                    tmp.setGender(selectGenderSpinner.getSelectedItem().toString());
                    tmp.setEthnicityRace(selectRaceSpinner.getSelectedItem().toString());
                    tmp.setAge(selectAgeNumberPicker.getValue());

                    UserDescriptionManager.writeToFile(CreateProfileActivity.this, tmp);
                    finish();
                }
            });
        }
 	}
}
