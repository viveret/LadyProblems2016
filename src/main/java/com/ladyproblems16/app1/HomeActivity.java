package com.ladyproblems16.app1;

import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.content.Intent;

import android.view.Display;
import android.graphics.Point;
import android.widget.Button;

import android.widget.TextView;
import android.view.View;
import android.widget.Toast;

public class HomeActivity extends Activity {

    private IUserDescription myUserDescription;
    private IContact emergencyContact;
    
    private TextView myUserFullNameTextView;
    private TextView myUserSubInfoTextView;
    private TextView myContactFullNameTextView;
    private TextView myContactNumberTextView;

    private Button editUserDesc;
    private Button editContact;
    
    private Button call911;

    private GpsAccess myGps;
    
	public void onCreate(Bundle bundle) {
		super.onCreate(bundle);
	    setContentView(R.layout.home_activity);

        if (!UserDescriptionManager.exists(this)) {
            Intent i = new Intent(getApplicationContext(), CreateProfileActivity.class);
            startActivity(i);
        }

        myUserFullNameTextView = (TextView) findViewById(R.id.user_full_name);
        myUserSubInfoTextView = (TextView) findViewById(R.id.user_sub_info);
        myContactFullNameTextView = (TextView) findViewById(R.id.emergency_contact_full_name);
        myContactNumberTextView = (TextView) findViewById(R.id.emergency_contact_phone_number);

        editUserDesc = (Button) findViewById(R.id.edit_user);
        editContact = (Button) findViewById(R.id.edit_contact);
        
        call911 = (Button) findViewById(R.id.call911_button);
        
        if (editUserDesc != null) {
            editUserDesc.setOnClickListener(new Button.OnClickListener() {
                public void onClick(View v) {
                    Intent i = new Intent(getApplicationContext(), CreateProfileActivity.class);
                    startActivity(i);
                }
            });
        }

        if (editContact != null) {
            editContact.setOnClickListener(new Button.OnClickListener() {
                public void onClick(View v) {
                    Intent i = new Intent(getApplicationContext(), AddEmergencyContactActivity.class);
                    startActivity(i);
                }
            });
        }

        if (call911 != null) {
            call911.setOnClickListener(new Button.OnClickListener() {
                public void onClick(View v) {
                    Intent i = new Intent(getApplicationContext(), ReadScriptActivity.class);
                    startActivity(i);
                }
            });
        }

        reloadUserDesc();
        reloadContact();
        //myGps = new GpsAccess(this);
	}

    private void reloadUserDesc() {
        // Load user info from somewhere
        myUserDescription = UserDescriptionManager.loadFromFile(this);
        Toast.makeText(this, "null", Toast.LENGTH_SHORT);
        if (myUserDescription != null) {
            if (myUserFullNameTextView != null) {
                myUserFullNameTextView.setText(myUserDescription.getFullName());
            }
            if (myUserFullNameTextView != null) {
                myUserSubInfoTextView.setText(myUserDescription.getGender() +
                                              ", " + myUserDescription.getAge());
            }
            
            Toast.makeText(this, myUserDescription.getFullName(), Toast.LENGTH_SHORT);
        } else {
            Toast.makeText(this, "Failed to retrieve user desc", Toast.LENGTH_SHORT);
        }
    }

    private void reloadContact() {
        List<IContact> tmpList = ContactManager.loadFromFile(this);
        if (tmpList != null && tmpList.size() > 0) {
            emergencyContact = tmpList.get(0);
        }
        
        if (emergencyContact != null) {
            if (myContactFullNameTextView != null) {
                myContactFullNameTextView.setText(emergencyContact.getName());
            }
            if (myContactNumberTextView != null) {
                myContactNumberTextView.setText(emergencyContact.getNumber());
            }
        }
    }

	@Override
	protected void onResume() {
	  super.onResume();

        reloadUserDesc();
        reloadContact();
      //myGps.resume();
	}

	@Override
	protected void onPause() {
	  super.onPause();
      //myGps.pause();
	}
}
