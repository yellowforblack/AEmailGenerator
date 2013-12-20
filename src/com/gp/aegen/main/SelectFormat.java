package com.gp.aegen.main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.gp.aegen.model.AlertDialogManager;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class SelectFormat extends Activity{

	List<String> c_list_one;
	List<String> c_list_two;
	
	// Alert Dialog Manager
    AlertDialogManager alert = new AlertDialogManager();
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.selectformat);
		
		final Spinner firstfField = (Spinner) findViewById(R.id.fnspinner);
		final Spinner secondField = (Spinner) findViewById(R.id.lnspinner);
		
		final EditText keyword_editT = (EditText) findViewById(R.id.keyword_editText);
		final EditText midiator = (EditText) findViewById(R.id.midiator_editText);
		
		final Button btnFieldNext = (Button) findViewById(R.id.btn_nextId);
		
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
		c_list_two.add("Philippines - Last Name");
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
                
                if(select_firstfField.equals("Keyword") || select_secondField.equals("Keyword")){
                	if(select_keyword_editT.equals("")){
                    	alert.showAlertDialog(SelectFormat.this, "Error", "fill keyword field", false);
                    }else{
                    	if(select_firstfField.equals("Keyword")){
                    		nextScreen.putExtra("firstField", select_keyword_editT);
                            nextScreen.putExtra("secondField", getValueFromHashMap(select_secondField));
                    	}else{
                            nextScreen.putExtra("firstField", getValueFromHashMap(select_firstfField));
                    		nextScreen.putExtra("secondField", select_keyword_editT);
                    	}
                    	
                    	nextScreen.putExtra("midiator", select_midiator);
                    	startActivity(nextScreen);
                    }
                	
                } else{
                	
                	Log.i("info:","Format: "+getValueFromHashMap(select_firstfField)+" "+select_midiator+" "+getValueFromHashMap(select_secondField));
                	
                	//Sending data to another Activity
                    nextScreen.putExtra("firstField", getValueFromHashMap(select_firstfField));
                    nextScreen.putExtra("secondField", getValueFromHashMap(select_secondField));
                    nextScreen.putExtra("midiator", select_midiator);
                    
                    startActivity(nextScreen);
                }
 
            }
        });
		
		configField(firstfField, c_list_two);
		configField(secondField, c_list_one);
	}
	
	/**
	 * Two parameters are required on this method, first is the field name(first or second) and content list.
	 * Two fields are available. (first field and second field)
	 * A method that remove or add keyword name on the list if any in the field selected the keyword option 
	 * Method that update the content list real time
	 * **/
	public void configField(Spinner field, final List<String> list_names){
		
		field.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
			public void onItemSelected(AdapterView<?> arg0, View v, int position, long id) {
				if(arg0.getItemAtPosition(position).toString().equals("Keyword")){
					list_names.remove("Keyword");
				}else{
					if(!list_names.contains("Keyword")){
						list_names.add("Keyword");
					}
				}
	        }
	        public void onNothingSelected(AdapterView<?> arg0) {
	        }
	    });
	}
	
	
	/**
	 * Method that Maps the return value of the fields. 
	 * **/
	public String getValueFromHashMap(String value){
				String textFileValue = null;
		
				//Using Hashmap
				HashMap<String, String> hm = new HashMap<String, String>();
				hm.put("Keyword", "keyword");
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
