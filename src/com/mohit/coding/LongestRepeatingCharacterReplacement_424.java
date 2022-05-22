package com.mohit.coding;

public class LongestRepeatingCharacterReplacement_424 {

	public static void main(String[] args) {
		/*
		 * You are given a string s and an integer k. You can choose any character of the string and 
		 * change it to any other upper case English character. You can perform this operation at most k times.
		 * Return the length of the longest substring containing the same letter you can get after performing the above operations.
		 */
		String s = "AABABBA";
		int k = 1;
		System.out.println(characterReplacement(s,k));
	}

	private static int characterReplacement(String s, int k) {
		int[] count = new int[26];
		int maxcount = 0, maxlen = 0, start = 0;
		for (int i = 0; i < s.length(); i++) {
			maxcount = Math.max(maxcount, ++count[s.charAt(i)-'A']);
			while(i-start+1-maxcount > k) {
				count[s.charAt(start)-'A']--;
				start++;
			}
			maxlen = Math.max(maxlen, i-start+1);
		}
		return maxlen;
	}

}
