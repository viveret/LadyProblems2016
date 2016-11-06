package com.ladyproblems16.app1;

import android.app.Activity;
import android.os.Bundle;
import android.content.Intent;

import android.view.Display;
import android.graphics.Point;
import android.widget.Button;

import android.widget.TextView;
import android.view.View;

public class HomeActivity extends Activity {

    private IUserDescription myUserDescription;
    
    private TextView myUserFullNameTextView;
    private TextView myUserSubInfoTextView;

    private Button call911;

    private GpsAccess myGps;
    
	public void onCreate(Bundle bundle) {
		super.onCreate(bundle);
	    setContentView(R.layout.home_activity);

        myUserFullNameTextView = (TextView) findViewById(R.id.user_full_name);
        myUserSubInfoTextView = (TextView) findViewById(R.id.user_sub_info);

        call911 = (Button) findViewById(R.id.call911_button);

        // Load user info from somewhere
        // basically myUserDescription = blah.getUserDesc();
        if (myUserDescription != null) {
            if (myUserFullNameTextView != null) {
                myUserFullNameTextView.setText(myUserDescription.getFullName());
            }
            if (myUserFullNameTextView != null) {
                myUserSubInfoTextView.setText(myUserDescription.getGender() +
                                              ", " + myUserDescription.getAge());
            }
        }

        if (call911 != null) {
            call911.setOnClickListener(new Button.OnClickListener() {
                public void onClick(View v) {
                    Intent i = new Intent(getApplicationContext(), ReadScriptActivity.class);
                    startActivity(i);
                }
            });
        }

        myGps = new GpsAccess(this);
	}


	@Override
	protected void onResume() {
	  super.onResume();
      myGps.resume();
	}

	@Override
	protected void onPause() {
	  super.onPause();
      myGps.pause();
	}
}
