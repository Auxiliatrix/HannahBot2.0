package utilities;

import java.util.ArrayList;
import java.util.Scanner;

import constants.Wordlists;

public class KeywordParser {
	public KeywordParser() {}
	
	public ArrayList<String> parse( String line ) {
		ArrayList<String> keywords = new ArrayList<String>();
		while( line.endsWith(" ") ) {
			line = line.substring(0, line.length()-1);
		}
		while( Wordlists.PUNCTUATION.contains(line.charAt(line.length()-1)+"") ) {
			line = line.substring(0, line.length()-1);
		}
		while( line.endsWith(" ") ) {
			line = line.substring(0, line.length()-1);
		}
		while( line.startsWith(" ") ) {
			line = line.substring(1);
		}
		while( Wordlists.PUNCTUATION.contains(line.charAt(line.length()-1)+"") ) {
			line = line.substring(0, line.length()-1);
		}
		while( line.startsWith(" ") ) {
			line = line.substring(1);
		}
		for( int f=0; f<line.length(); f++ ) {
			if( Wordlists.PUNCTUATION.contains(line.charAt(f)+"") ) {
				line = line.substring(0,f) + line.substring(f+1);
				f--;
			}
		}
		String[] split = line.split("\\s+");
		for( String keyword : split ) {
			boolean contains = false;
			for( String filter : Wordlists.FILTER ) {
				if( keyword.equals(filter) ) {
					contains = true;
				}
			}
			if( !contains ) {
				keywords.add(keyword);
			}
		}
		return keywords;
	}
}
