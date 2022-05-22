package com.mohit.coding;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring_76 {

	public static void main(String[] args) {
		/*
		 * Given two strings s and t of lengths m and n respectively, 
		 * return the minimum window substring of s such that every character in t (including duplicates) is included in the window. 
		 * If there is no such substring, return the empty string "".
		 * Input: s = "ADOBECODEBANC", t = "ABC" Output: "BANC"
		 */
		String s = "ADOBECODEBANC";
		String t = "ABC";
		System.out.println(minWindow(s,t));
	}

	private static String minWindow(String s, String t) {
		  if(t == "" || t.length() > s.length())return "";
			
			Map<Character,Integer> CountMap = new HashMap<>();
			Map<Character,Integer> WindowMap = new HashMap<>();
			int[] result = new int[2];
			int resultLength = Integer.MAX_VALUE;

			
			for (int i = 0; i < t.length(); i++) {
			    char ch = t.charAt(i);
			    if(CountMap.containsKey(ch)) {
			    	CountMap.put(ch, 1 + CountMap.get(ch));
			    } else CountMap.put(ch, 1);
			   
			}
			int l = 0, have = 0, need = CountMap.size();
	        
			for (int r = 0; r < s.length(); r++) {
				char ch = s.charAt(r);
				if(CountMap.containsKey(ch)) {
					if(WindowMap.containsKey(ch)) {
						WindowMap.put(ch, 1 + WindowMap.get(ch));
					} else WindowMap.put(ch, 1);
					
					if(WindowMap.get(ch).equals(CountMap.get(ch))) {
						have++;
					}
				}
				while(have == need) {
					if((r-l+1) < resultLength) {
						result[0] = l;
						result[1] = r;
						resultLength = r-l+1;
					}
					char popChar = s.charAt(l);
					if(CountMap.containsKey(popChar)) {
						WindowMap.put(popChar, WindowMap.get(popChar)-1);
						if(WindowMap.get(popChar) < CountMap.get(popChar))
								have--;
					}
					l++;
				}

			}
			if(resultLength == Integer.MAX_VALUE)return "";
			return s.substring(result[0], result[1]+1);
	}

}
