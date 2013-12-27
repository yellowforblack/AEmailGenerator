package com.gp.aegen.model;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import android.os.Environment;

public class WriteFileToStorageDevice {
	String dirName;
	String fileName;
	
	public WriteFileToStorageDevice(){}

	public String getDirName() {
		return dirName;
	}

	public void setDirName(String dirName) {
		this.dirName = dirName;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	/**
	 * write file to:
	 * Environment.getExternalStorageDirectory() or
	 * getFilesDir()
	 * **/
	public void writeToAFile(String data){
		try {
			FileWriter fw = new FileWriter(Environment.getExternalStorageDirectory()+File.separator+dirName+File.separator+fileName);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(data);
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * to create folder use: <foldername>.mkdirs()
	 * 
	 * */
	public File Folder(){
		File folder = new File(Environment.getExternalStorageDirectory() +File.separator+dirName);
		return folder;
	}
	
	/**
	 * to create file use: <filename>.createNewFile()
	 * 
	 * */
	public File File() throws IOException{
		File file = new File(Environment.getExternalStorageDirectory() + "/"+dirName+"/"+fileName);
		return file;
	}
	
	
}
