package searchables;

import java.util.ArrayList;

import tokens.AltName;
import utilities.FuzzyMatcher;

public class Searchable {
	
	public FuzzyMatcher fm = new FuzzyMatcher(3);
	
	public String name;
	public ArrayList<String> tags;
	public ArrayList<AltName> alts;

	public Searchable(String name) {
		this.name = name;
		tags = new ArrayList<String>();
		alts = new ArrayList<AltName>();
	}
	public Searchable(String name, ArrayList<String> tags, ArrayList<AltName> alts) {
		this.name = name;
		this.tags = tags;
		this.alts = alts;
	}
	
	public int exactScore(ArrayList<String> keywords) {
		int score = 0;
		for( String keyword : keywords ) {
			if(name.equalsIgnoreCase(keyword)) {
				score++;
			}
		}
		return score;
	}
	
	public int tagScore(ArrayList<String> keywords) {
		int score = 0;
		for( String keyword : keywords ) {
			for( String tag : tags ) {
				if( keyword.equalsIgnoreCase(tag) ) {
					score++;
				}
			}
		}
		return score;
	}
	
	public int partialScore(ArrayList<String> keywords) {
		int score = -1;
		for( String keyword : keywords ) {
			int temp = fm.match(keyword, name);
			if( temp < score || score == -1) {
				score = temp;
			}
		}
		return score;
	}
	
	
}
