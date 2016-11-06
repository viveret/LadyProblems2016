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
		// myUserDescription =
		final ScriptGenerator sg = new ScriptGenerator(myUserDescription);
		tts = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
				@Override
				public void onInit(int status) {
					if(status != TextToSpeech.ERROR) {
						Toast.makeText(getApplicationContext(), "Error initializing text to speech engine", Toast.LENGTH_SHORT).show();
					} else {
						tts.speak(sg.generateDefault(), TextToSpeech.QUEUE_FLUSH, null);
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
