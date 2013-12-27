package com.gp.aegen.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import android.content.Context;
import android.content.res.AssetManager;
import android.util.Log;

public class ReadTextFile {
	private Context myContext;
	private String fileName;
	
	public ReadTextFile(){}
	
	//Pass parameters: getApplicationContext() and filename from assests folder
	//use context data type because class is not bundled by android activity
	public ReadTextFile(Context myContext, String fileName){
		this.myContext=myContext;
		this.fileName=fileName;
	}
	
	public ArrayList<String> readFile(){
		BufferedReader br = null;
		String sCurrentLine = null;
		ArrayList<String> al = new ArrayList<String>();
		AssetManager mngr = myContext.getAssets();
		
		try {
			br = new BufferedReader(new InputStreamReader(mngr.open(fileName)));
			
			while ((sCurrentLine = br.readLine()) != null) {
				al.add(sCurrentLine.trim());
			}
			
		} catch (IOException e) {
			e.printStackTrace();
			Log.e("Error:", fileName+": Cannot read the file.");
		} finally{
			try {
				if (br != null)br.close();
			} catch (IOException ex) {
				ex.printStackTrace();
				Log.e("Error:", "Cannot close the file.");
			}
		}
		
		return al;
	}

}
