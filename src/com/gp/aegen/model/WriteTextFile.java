package com.gp.aegen.model;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import android.os.Environment;

public class WriteTextFile {
	public WriteTextFile(){}
	
	public void getWriter(ArrayList<String> emails, FileWriter path){
		try {
			path = new FileWriter(Environment.getExternalStorageDirectory().toString() + "text.txt", true);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
