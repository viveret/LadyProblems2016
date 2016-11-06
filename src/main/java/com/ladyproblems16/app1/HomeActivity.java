package com.ladyproblems16.app1;

import android.app.Activity;
import android.os.Bundle;
import android.content.Intent;

import android.view.Display;
import android.graphics.Point;

import android.widget.TextView;

public class HomeActivity extends Activity {

    private IUserDescription myUserDescription;
    
    private TextView myUserFullNameTextView;
    private TextView myUserSubInfoTextView;
    
	public void onCreate(Bundle bundle) {
		super.onCreate(bundle);
	    setContentView(R.layout.home_activity);

        myUserFullNameTextView = (TextView) findViewById(R.id.user_full_name);
        myUserSubInfoTextView = (TextView) findViewById(R.id.user_sub_info);

        // Load user info from somewhere
        // basically myUserDescription = blah.getUserDesc();
        if (myUserDescription != null) {
            if (myUserFullNameTextView != null) {
                myUserFullNameTextView.setText(myUserDescription.getFirstName() +
                                               " " + myUserDescription.getLastName());
            }
            if (myUserFullNameTextView != null) {
                myUserSubInfoTextView.setText(myUserDescription.getGender() +
                                              ", " + myUserDescription.getAge());
            }
        }
	}


	@Override
	protected void onResume() {
	  super.onResume();
	}

	@Override
	protected void onPause() {
	  super.onPause();
	}
}
