package com.gp.aegen.main;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class SelectFormat extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.selectformat);
		
		Spinner spinner1 = (Spinner) findViewById(R.id.fnspinner);
		ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this, R.array.assets_textfile_array, android.R.layout.simple_spinner_item);
		// Specify the layout to use when the list of choices appears
		adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); 
		spinner1.setAdapter(adapter1); // Apply the adapter to the spinner
	}
}
