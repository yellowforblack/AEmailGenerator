package com.gp.aegen.main;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;


public class SelectDomainName extends Activity {
	
	String firstField;
	String secondField;
	String keyword_editT;
	String midiator;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.select_domainname);
		
		Button nxtBtn = (Button) findViewById(R.id.next_btn);
		
		Bundle extras = getIntent().getExtras();
		
		    firstField = extras.getString("firstField");
		    secondField = extras.getString("secondField");
		    keyword_editT = extras.getString("keyword_editT");
		    midiator = extras.getString("midiator");
		    
		    
		
		    nxtBtn.setOnClickListener(new View.OnClickListener() {

				@Override
				public void onClick(View v) {
					 
					Log.i("info", firstField+" "+secondField+" "+keyword_editT+" "+midiator);
				}
		    	
		    });
		
	}

}
