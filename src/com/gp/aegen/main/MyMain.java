package com.gp.aegen.main;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class MyMain extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.my_main);
		
		Button startGenEmailBtn = (Button) findViewById(R.id.startGenEmailId);
		
		//Listening to button event
				startGenEmailBtn.setOnClickListener(new View.OnClickListener() {
		 
		            public void onClick(View arg0) {
		                //Starting a new Intent
		                Intent nextScreen = new Intent(getApplicationContext(), SelectFormat.class);
		                startActivity(nextScreen);
		            }
		        });
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.my_main, menu);
		return true;
	}

}
