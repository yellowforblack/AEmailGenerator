package com.gp.aegen.main;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SelectKeyWord extends Activity{
	
	String firstField;
	String secondField;
	String midiator;
	String domainName;
	
	String frontKwrd;
	String backKwrd;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.select_keyword);
		
		final EditText frontKwrd_editText = (EditText) findViewById(R.id.frontkwrd_editText);
		final EditText backKwrd_editText = (EditText) findViewById(R.id.backkwrd_editText);
		final Button next_btn = (Button) findViewById(R.id.next_btn);
		
		frontKwrd = frontKwrd_editText.getText().toString().trim();
		backKwrd = backKwrd_editText.getText().toString().trim();
		
	    
	    next_btn.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				Bundle extras = getIntent().getExtras();
				
				firstField = extras.getString("firstField");
				secondField = extras.getString("secondField");
				midiator = extras.getString("midiator");
				domainName = extras.getString("domainName");
				
				Log.i("info", "Set Keyword: "+frontKwrd+" "+backKwrd);
				Intent nextScreen = new Intent(getApplicationContext(), GenerateEmail.class);
				
				nextScreen.putExtra("firstField",firstField);
				nextScreen.putExtra("secondField",secondField);
				nextScreen.putExtra("midiator",midiator);
				nextScreen.putExtra("domainName",domainName);
				
				nextScreen.putExtra("frontKwrd", frontKwrd);
				nextScreen.putExtra("backKwrd", backKwrd);
				
				startActivity(nextScreen);
			}
		});
	    
	}
}
