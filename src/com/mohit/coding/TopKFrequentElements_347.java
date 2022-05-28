package com.mohit.coding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class TopKFrequentElements_347 {

	public static void main(String[] args) {
		/*
		 * Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.
		 * Input: nums = [1,1,1,2,2,3], k = 2 Output: [1,2]
		 */
		int[] nums =  {1,1,1,2,2,3,4,4};
		int k = 2;
		int[] res = topKFrequent(nums,k);
		for (int i = 0; i < res.length; i++) {
			System.out.print(res[i] + " ");
		}
		
	}
	 public static int[] topKFrequent(int[] nums, int k) {
		    int[] res = new int[k];
	        Map<Integer,Integer> freqmap = new HashMap<>();
	        List<Integer>[] list = new List[nums.length+1];
	        for (int i = 0; i < nums.length; i++) {
				int val = freqmap.getOrDefault(nums[i], 0);
				val++;
				freqmap.put(nums[i],val);
	        }
	        for (Map.Entry<Integer, Integer> entry : freqmap.entrySet()) {
				Integer key = entry.getKey();
				Integer val = entry.getValue();
				if(list[val] == null)list[val] = new ArrayList<>();
				list[val].add(key);
			}
	        List<Integer> result = new ArrayList<>();
	        for (int i = list.length-1; i > 0 && result.size() < k; i--) {
	        	if(list[i] != null) {
	        		result.addAll(list[i]);
	        	}
			}
	        for (int i = 0; i < result.size() && i < k; i++)
	            res[i] = result.get(i);
	        return res;
	    }

}
