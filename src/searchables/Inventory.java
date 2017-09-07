package searchables;

import java.util.ArrayList;

import tokens.AltName;

public class Inventory {

	public String name;
	public ArrayList<Group> groups;
	
	public Inventory(String name) {
		this.name = name;
		this.groups = new ArrayList<Group>();
	}
	
	public Inventory(String name, ArrayList<Group> groups) {
		this.name = name;
		this.groups = groups;
	}
}
