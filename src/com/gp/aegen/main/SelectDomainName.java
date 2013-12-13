package com.gp.aegen.main;
import com.gp.aegen.model.AlertDialogManager;
import com.gp.aegen.model.DomainFormat;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class SelectDomainName extends Activity {
	
	String firstField;
	String secondField;
	String keyword_editT;
	String midiator;
	String domainName;
	
	EditText domainEditT;
	
	AlertDialogManager alert = new AlertDialogManager();
	DomainFormat checkDomain = new DomainFormat();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.select_domainname);
		
		Button nxtBtn = (Button) findViewById(R.id.next_btn);
		domainEditT = (EditText) findViewById(R.id.domain_editText);
		
		    nxtBtn.setOnClickListener(new View.OnClickListener() {

				@Override
				public void onClick(View v) {
					
					Bundle extras = getIntent().getExtras();
					
					firstField = extras.getString("firstField");
				    secondField = extras.getString("secondField");
				    midiator = extras.getString("midiator");
				    domainName = domainEditT.getText().toString().trim();
					
					//Starting a new Intent
	                Intent nextScreen = new Intent(getApplicationContext(), SelectKeyWord.class);
					
					if(domainName.equals("")){
						alert.showAlertDialog(SelectDomainName.this, "Entry Failed...", "Domain name is Empty", false);
					}else if(!checkDomain.validate(domainName)){
						alert.showAlertDialog(SelectDomainName.this, "Entry Failed...", "Invalid domain", false);
					}else{
						nextScreen.putExtra("firstField", firstField);
	                    nextScreen.putExtra("secondField", secondField);
	                    nextScreen.putExtra("midiator", midiator);
	                    nextScreen.putExtra("domainName", domainName);
	                    
	                    startActivity(nextScreen);
					}
				}
		    	
		    });
		
	}

}
