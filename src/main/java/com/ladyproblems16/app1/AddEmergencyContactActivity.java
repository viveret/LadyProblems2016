package com.ladyproblems16.app1;

import java.util.List;
import java.util.ArrayList;

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
	    setContentView(R.layout.add_contacts);

        addFromContactsButton = (Button) findViewById(R.id.add_contact_button);
        backButton = (Button) findViewById(R.id.go_back_button);
        nextButton = (Button) findViewById(R.id.go_next_button);

        emergencyContactNameEditText = (EditText) findViewById(R.id.edit_contact_name);
        emergencyContactPhoneNumberEditText = (EditText) findViewById(R.id.edit_contact_number);

        if (addFromContactsButton != null) {
            addFromContactsButton.setOnClickListener(new Button.OnClickListener() {
                public void onClick(View v) {
                }
            });
        }

        if (backButton != null) {
            backButton.setOnClickListener(new Button.OnClickListener() {
                public void onClick(View v) {
                    finish();
                }
            });
        }

        if (nextButton != null) {
            nextButton.setOnClickListener(new Button.OnClickListener() {
                public void onClick(View v) {
                    IContact tmp = new Contact(emergencyContactNameEditText.getText().toString(),
                                               emergencyContactPhoneNumberEditText.getText().toString());

                    List<IContact> tmpList = new ArrayList<IContact>();
                    tmpList.add(tmp);
                    ContactManager.writeToFile(AddEmergencyContactActivity.this, tmpList);
                    finish();
                }
            });
        }
 	}
}
