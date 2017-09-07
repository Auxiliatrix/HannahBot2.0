package searchables;

import java.util.ArrayList;

import constants.Calibration;
import tokens.AltName;
import tokens.ItemScore;

public class Group extends Searchable {

	public ArrayList<Item> items;
	
	public Group(String name) {
		super(name);
	}
	
	public Group(String name, ArrayList<String> tags, ArrayList<AltName> alts) {
		super(name, tags, alts);
	}
	
	public ArrayList<ItemScore> exactMatch(ArrayList<String> keywords) {
		ArrayList<ItemScore> found = new ArrayList<ItemScore>();
		for( Item item : items ) {
			int score = item.exactScore(keywords);
			if( score > 0 ) {
				found.add(new ItemScore(item, score));
			}
		}
		return found;
	}
	
	public ArrayList<ItemScore> taggedMatch(ArrayList<String> keywords) {
		ArrayList<ItemScore> found = new ArrayList<ItemScore>();
		for( Item item : items ) {
			int score = item.tagScore(keywords);
			if( score > Calibration.TAG_THRESHOLD ) {
				found.add(new ItemScore(item, score));
			}
		}
		return found;
	}
	
	public ArrayList<ItemScore> partialMatch(ArrayList<String> keywords) {
		ArrayList<ItemScore> found = new ArrayList<ItemScore>();
		for( Item item : items ) {
			int score = item.partialScore(keywords);
			if( score > Calibration.LEVENSHTEIN_THRESHOLD ) {
				found.add(new ItemScore(item, score));
			}
		}
		return found;
	}
	
}
