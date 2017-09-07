package classes;

import java.util.ArrayList;
import java.util.Scanner;

import constants.Wordlists;
import utilities.FuzzyMatcher;
import utilities.KeywordParser;

public class FuzzyTester {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		FuzzyMatcher fm = new FuzzyMatcher();
		KeywordParser kp = new KeywordParser();
		
		
		while( true ) {
			String s = sc.nextLine();
			String t = sc.nextLine();
			System.out.println(fm.match(s, t));
		}
		
		
		/*
		String tester = sc.nextLine();
		String line = sc.nextLine();
		ArrayList<String> keywords = kp.parse(line);
		for( String keyword : keywords ) {
			System.out.println(keyword);
			System.out.println(fm.match(tester, keyword));
		}
		*/
		
		
	}

}
