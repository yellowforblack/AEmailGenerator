package com.gp.aegen.main;

import java.util.ArrayList;
import java.util.List;

public class ContentList {

	List<String> mylist;
	
	public ContentList(){}
	
	public List<String> CList(){
		
		mylist = new ArrayList<String>();
		mylist.add("US - First Name");
		mylist.add("US - Last Name");
		mylist.add("Philippines - First Name");
		mylist.add("philippines - Last Name");
		mylist.add("UK - First Name");
		mylist.add("UK - Last Name");
		mylist.add("India - First Name");
		mylist.add("India - Last Name");
		mylist.add("Keyword");
		
		return mylist;
	}
}
