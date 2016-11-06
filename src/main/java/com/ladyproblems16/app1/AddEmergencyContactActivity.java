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

public class AddEmergencyContactActivity extends Activity {

    private Button addFromContactsButton;
    private Button backButton;
    private Button nextButton;

    private EditText emergencyContactNameEditText;
    private EditText emergencyContactPhoneNumberEditText;

    
	public void onCreate(Bundle bundle) {
		super.onCreate(bundle);
	    setContentView(R.layout.home_activity);

        addFromContactsButton = (Button) findViewById(R.id.add_contact_button);
        backButton = (Button) findViewById(R.id.go_back_button);
        nextButton = (Button) findViewById(R.id.go_next_button);

        emergencyContactNameEditText = (EditText) findViewById(R.id.edit_contact_name);
        emergencyContactPhoneNumberEditText = (EditText) findViewById(R.id.edit_contact_number);

        // Load user info from somewhere
        // basically myUserDescription = blah.getUserDesc();
        if (addFromContactsButton != null) {
            addFromContactsButton.setOnClickListener(new Button.OnClickListener() {
                public void onClick(View v) {
                    // Open add contact from contacts activity
                }
            });
        }

        if (backButton != null) {
            backButton.setOnClickListener(new Button.OnClickListener() {
                public void onClick(View v) {
                    // Open previous screen
                }
            });

        }

        if (nextButton != null) {
            nextButton.setOnClickListener(new Button.OnClickListener() {
                public void onClick(View v) {
                    // Open next screen
                }
            });


        } 
 	}
}
