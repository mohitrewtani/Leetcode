package com.mohit.coding;

import java.util.HashMap;
import java.util.Map;

public class ValidAnagram_242 {

	public static void main(String[] args) {
		/*
		 * Given two strings s and t, return true if t is an anagram of s, and false otherwise.
		 * Input: s = "anagram", t = "nagaram" Output: true
		 */
		String s = "anagram";
		String t = "nagaram";
		System.out.println(isAnagram(s,t));
	}

	private static boolean isAnagram(String s, String t) {

		Map<Character,Integer> map = new HashMap<>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			map.put(c, map.getOrDefault(c, 0) + 1);
		}
		
		for (int i = 0; i < t.length(); i++) {
			char c = t.charAt(i);
			if(!map.containsKey(c))
				return false;
			else if(map.get(c) == 1)
				map.remove(c);
			else
				map.put(c, map.get(c)-1);
		}
		return map.size() == 0;
	}

}
