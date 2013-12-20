package com.gp.aegen.main;

import java.io.File;
import java.util.ArrayList;

import com.gp.aegen.model.ReadTextFile;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class GenerateEmail extends Activity {
	
	String firstField;
	String secondField;
	
	String midiator;
	String domainName;
	String frontKwrd;
	String backKwrd;
	
	ReadTextFile firstFile;
	ReadTextFile secondFile;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.generate_email);
		
		Button genEmail_btn = (Button) findViewById(R.id.genEmail_btn);	
		final File dir = new File(Environment.getExternalStorageDirectory()+"/aegenfiles");
		
		genEmail_btn.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				
				Bundle extras = getIntent().getExtras();
				firstField = extras.getString("firstField");
				secondField = extras.getString("secondField");
				
				setMidiator(extras.getString("midiator"));
				setDomainName(extras.getString("domainName"));
				setFrontKwrd(extras.getString("frontKwrd"));
				setBackKwrd(extras.getString("backKwrd"));
				
				firstFile = new ReadTextFile(getApplicationContext(),firstField);
				secondFile = new ReadTextFile(getApplicationContext(),secondField);
				
			
				if(!dir.exists()){
					Log.i("info:", dir+" is created.");
					dir.mkdir();
				}else{

					Log.i("info:", dir+" is exist.");
				}
				
				for(int i=0; i<getFiles(firstFile, secondFile).size(); i++){
				getFiles(firstFile, secondFile);
				}
				

			}
		});
	}
	
	public ArrayList<String> getFiles(ReadTextFile f, ReadTextFile s){
		
		ArrayList<String> store = new ArrayList<String>();
		
		for(int i=0; i < f.readFile().size(); i++){
			for(int j=0; j < s.readFile().size();j++){
				store.add(getFrontKwrd()+f.readFile().get(i)+getMidiator()+s.readFile().get(j)+getBackKwrd()+getDomainName());
			}
		}
		return store;
	}

	public String getMidiator() {
		return midiator;
	}

	public void setMidiator(String midiator) {
		this.midiator = midiator;
	}

	public String getDomainName() {
		return domainName;
	}

	public void setDomainName(String domainName) {
		this.domainName = domainName;
	}

	public String getFrontKwrd() {
		return frontKwrd;
	}

	public void setFrontKwrd(String frontKwrd) {
		this.frontKwrd = frontKwrd;
	}

	public String getBackKwrd() {
		return backKwrd;
	}

	public void setBackKwrd(String backKwrd) {
		this.backKwrd = backKwrd;
	}
	
	
}
