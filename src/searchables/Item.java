package searchables;

import java.util.ArrayList;

import tokens.AltName;

public class Item extends Searchable {
	
	public Item(String name) {
		super(name);
	}
	
	public Item(String name, ArrayList<String> tags, ArrayList<AltName> alts) {
		super(name, tags, alts);
	}

}
