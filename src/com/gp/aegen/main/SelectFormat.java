package com.gp.aegen.main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class SelectFormat extends Activity{
	Spinner firstfField;
	Spinner secondField;
	EditText keyword_editT;
	EditText midiator;
	Button btnFieldNext;
	

	List<String> c_list_one;
	List<String> c_list_two;
	
	// Alert Dialog Manager
    AlertDialogManager alert = new AlertDialogManager();
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.selectformat);
		
		firstfField = (Spinner) findViewById(R.id.fnspinner);
		secondField = (Spinner) findViewById(R.id.lnspinner);
		keyword_editT = (EditText) findViewById(R.id.keyword_editText);
		midiator = (EditText) findViewById(R.id.midiator_editText);
		btnFieldNext = (Button) findViewById(R.id.btn_nextId);
		
		c_list_one = new ArrayList<String>();
		c_list_one.add("US - First Name");
		c_list_one.add("US - Last Name");
		c_list_one.add("Philippines - First Name");
		c_list_one.add("philippines - Last Name");
		c_list_one.add("UK - First Name");
		c_list_one.add("UK - Last Name");
		c_list_one.add("India - First Name");
		c_list_one.add("India - Last Name");
		c_list_one.add("Keyword");
		
		c_list_two = new ArrayList<String>();
		c_list_two.add("US - First Name");
		c_list_two.add("US - Last Name");
		c_list_two.add("Philippines - First Name");
		c_list_two.add("philippines - Last Name");
		c_list_two.add("UK - First Name");
		c_list_two.add("UK - Last Name");
		c_list_two.add("India - First Name");
		c_list_two.add("India - Last Name");
		c_list_two.add("Keyword");
		
		ArrayAdapter<String> adapterFNField = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,c_list_one);
		adapterFNField.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		firstfField.setAdapter(adapterFNField);
		
		ArrayAdapter<String> adapterSNField = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,c_list_two);
		adapterSNField.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		secondField.setAdapter(adapterSNField);
		
		
		//Listening to button event
		btnFieldNext.setOnClickListener(new View.OnClickListener() {
 
            public void onClick(View arg0) {
            	
            	String select_firstfField  = firstfField.getSelectedItem().toString();
            	String select_secondField  = secondField.getSelectedItem().toString();
            	String select_keyword_editT = keyword_editT.getText().toString().trim();
            	String select_midiator = midiator.getText().toString();
            	
                //Starting a new Intent
                Intent nextScreen = new Intent(getApplicationContext(), SelectDomainName.class);
                
                if(select_keyword_editT.equals("") && (select_firstfField.equals("Keyword") || select_secondField.equals("Keyword"))){
                	alert.showAlertDialog(SelectFormat.this, "Login failed..", "Udfsdffsername/Password is incorrect", false);
                }else{
                	//Sending data to another Activity
                    nextScreen.putExtra("firstField", getValueFromHashMap(select_firstfField));
                    nextScreen.putExtra("secondField", getValueFromHashMap(select_secondField));
                    nextScreen.putExtra("keyword_editT", select_keyword_editT);
                    nextScreen.putExtra("midiator", select_midiator);
                    
                    startActivity(nextScreen);
                }
 
            }
        });
		
		firstfField.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

			public void onItemSelected(AdapterView<?> arg0, View v, int position, long id) {
				if(arg0.getItemAtPosition(position).toString().equals("Keyword")){
					c_list_two.remove("Keyword");
				}else{
					if(!c_list_two.contains("Keyword")){
						c_list_two.add("Keyword");	
					}
				}
	        }

	        public void onNothingSelected(AdapterView<?> arg0) {
	        }
	    });
		
		secondField.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
			public void onItemSelected(AdapterView<?> arg0, View v, int position, long id) {
				if(arg0.getItemAtPosition(position).toString().equals("Keyword")){
					c_list_one.remove("Keyword");
				}else{
					if(!c_list_one.contains("Keyword")){
						c_list_one.add("Keyword");
					}
				}
	        }

	        public void onNothingSelected(AdapterView<?> arg0) {
	        }
	    });
		
		
	}
	
	public String getValueFromHashMap(String value){
				String textFileValue = null;
		
				//Using Hashmap
				HashMap<String, String> hm = new HashMap<String, String>();
				hm.put("Keyword", "null");
				hm.put("US - First Name", "fname-us.txt");
				hm.put("US - First Name", "fname-us.txt");
				hm.put("US - Last Name", "lname-us.txt");
				hm.put("Philippines - First Name", "fname-phil.txt");
				hm.put("Philippines - Last Name", "lname-phil.txt");
				hm.put("UK - First Name", "fname-uk.txt");
				hm.put("UK - Last Name", "lname-uk.txt");
				hm.put("India - First Name", "fname-inda.txt");
				hm.put("India - Last Name", "lname-inda.txt");
				
				textFileValue = hm.get(value);
		return textFileValue;
	}
	
}
