package com.ladyproblems16.app1;

import android.app.Activity;
import android.os.Bundle;
import android.content.Intent;
import android.Manifest;

import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.content.pm.PackageManager;

import android.view.Display;
import android.graphics.Point;
import android.widget.Toast;

import android.os.Handler;

public class MainActivity extends Activity {
	public void onCreate(Bundle bundle) {
		super.onCreate(bundle);
	    setContentView(R.layout.splash_activity);

		int permissionCheck = ContextCompat.checkSelfPermission(
            this, Manifest.permission.ACCESS_FINE_LOCATION);
		if (permissionCheck != PackageManager.PERMISSION_GRANTED) {
			if (ActivityCompat.shouldShowRequestPermissionRationale(this,
																	Manifest.permission.ACCESS_FINE_LOCATION)) {
				Toast.makeText(MainActivity.this, "Permission Needed!", Toast.LENGTH_SHORT).show();
			} else {
				ActivityCompat.requestPermissions(this, new String[] {
						Manifest.permission.ACCESS_FINE_LOCATION}, 1
				);
			}
		} else {
			continueToHomeScreen();
		}
	}

	@Override
	public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
		//super.onRequestPermissionsResult(requestCode, permissions, grantResults);
		continueToHomeScreen();
	}

	private void continueToHomeScreen() {
		Handler handler = new Handler();
		handler.postDelayed(new Runnable() {
				@Override
				public void run() {
					Intent i = new Intent(getApplicationContext(), HomeActivity.class);
					startActivity(i);
					finish();
				}

			}, 5000); // 5000ms delay
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
