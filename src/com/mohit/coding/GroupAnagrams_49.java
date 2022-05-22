package com.mohit.coding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams_49 {

	public static void main(String[] args) {
		/*
		 * Given an array of strings strs, group the anagrams together. You can return the answer in any order.
		 * Input: strs = ["eat","tea","tan","ate","nat","bat"]
         * Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
		 */
		String[] strs =  {"eat","tea","tan","ate","nat","bat"};
		List<List<String>> anagramList = groupAnagrams(strs);
		System.out.println(anagramList);
	}

	private static List<List<String>> groupAnagrams(String[] strs) {
		Map<String,List<String>> map = new HashMap<>();
		for (String s: strs) {
			char[] char_arr = s.toCharArray();
			Arrays.sort(char_arr);
			String keystr = new String(char_arr);
			if(!map.containsKey(keystr))map.put(keystr, new ArrayList<String>());
			map.get(keystr).add(s);
		}
		return new ArrayList<List<String>>(map.values());
	}

}
