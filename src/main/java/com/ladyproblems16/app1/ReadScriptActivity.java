package com.ladyproblems16.app1;

import android.app.Activity;
import android.os.Bundle;
import android.content.Intent;
import android.widget.Toast;

import android.view.Display;
import android.graphics.Point;

import android.widget.TextView;

import android.speech.tts.TextToSpeech;

public class ReadScriptActivity extends Activity {

    private IUserDescription myUserDescription;
    
    private TextView myScriptTV;
    private TextView myTimeDurationTV;

	private TextToSpeech tts;
    
	public void onCreate(Bundle bundle) {
		super.onCreate(bundle);
	    // setContentView(R.layout.read_script_activity);

		// Get user description
	    myUserDescription = new UserDescription("Viveret Steele", "White kid", "person", 20);
        final GpsAccess myGps = new GpsAccess(this);
        
		tts = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
				@Override
				public void onInit(int status) {
					if(status == TextToSpeech.SUCCESS) {
                        final ScriptGenerator sg = new ScriptGenerator(myUserDescription, myGps);
                        tts.speak(sg.generateDefault(), TextToSpeech.QUEUE_FLUSH, null);
                        myGps.setWhenReady(new GpsAccess.GpsReady() {
                                @Override
                                public void onReady(IGpsAccess gps) {
                                    final ScriptGenerator sg = new ScriptGenerator(myUserDescription, gps);
                                    tts.speak(sg.generateDefault(), TextToSpeech.QUEUE_FLUSH, null);
                                }
                            });
					} else {
						Toast.makeText(getApplicationContext(), "Error initializing text to speech engine", Toast.LENGTH_SHORT).show();
					}
				}
			});
	}


	@Override
	protected void onResume() {
	  super.onResume();
	}

	@Override
	protected void onPause() {
      if(tts !=null){
         tts.stop();
         tts.shutdown();
      }
	  super.onPause();
	}
}
