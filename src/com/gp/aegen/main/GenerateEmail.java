package com.gp.aegen.main;

import java.util.ArrayList;

import com.gp.aegen.impl.FileContent;
import com.gp.aegen.model.ReadTextFile;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class GenerateEmail extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.generate_email);
		
		Button genEmail_btn = (Button) findViewById(R.id.genEmail_btn);
		
		Bundle extras = getIntent().getExtras();
		String firstField = extras.getString("firstField");
		String secondField = extras.getString("secondField");
		
		String midiator = extras.getString("midiator");
		String domainName = extras.getString("domainName");
		String frontKwrd = extras.getString("frontKwrd");
		String backKwrd = extras.getString("backKwrd");
		
		FileContent firstFile = new ReadTextFile(getApplicationContext(),firstField);
		FileContent secondFile = new ReadTextFile(getApplicationContext(),secondField);
		
		
		genEmail_btn.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				
				
				
			}
		});
	}
	
	public String getEmails(){
		ArrayList<String> uname = new ArrayList<String>();
		
		
		return null;
	}
}
