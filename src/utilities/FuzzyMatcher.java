package utilities;

import constants.Calibration;

// This class was made by Ryan Lee, based on Levenshtein Distance
public class FuzzyMatcher {
	public static int threshold = Calibration.LEVENSHTEIN_THRESHOLD;
	public FuzzyMatcher() {
		threshold = 0;
	};
	public FuzzyMatcher(int threshold) {
		this.threshold = threshold;
	}
	public static int match(String str1, String str2) {
		int str1len=str1.length();
		int str2len=str2.length();
		int cacheArray[][];
		cacheArray=new int[str1len+1][str2len+1];
		cacheArray[0][0]=0;
		for (int i=1;i<=str1len;i++) {
			cacheArray[i][0]=i;
		}
		for (int j=1;j<=str2len;j++) {
			cacheArray[0][j]=j;
		}
		for (int i=1;i<=str1len;i++) {
			for (int j=1;j<=str2len;j++) {
				int del1=cacheArray[i-1][j]+1;
				int del2=cacheArray[i][j-1]+1;
				int cost=1;
				if (str1.charAt(i-1)==str2.charAt(j-1)) {
					cost=0;
				}
				int subs=cacheArray[i-1][j-1]+cost;
				cacheArray[i][j]=Math.min(Math.min(del1, del2), subs);
			}
		}
		return cacheArray[str1len][str2len];
	}
	public static boolean matchSimilar(String str1, String str2) {
		return matchSimilar(str1, str2, threshold);
	}
	public static boolean matchDifferent(String str1, String str2) {
		return matchSimilar(str1, str2, threshold);
	}
	public static boolean matchSimilar(String str1, String str2, int threshold) {
		int result=match(str1,str2);
		return (result<=threshold);
	}
	public static boolean matchDifferent(String str1, String str2, int threshold) {
		int result=match(str1,str2);
		return (result>=threshold);
	}
}