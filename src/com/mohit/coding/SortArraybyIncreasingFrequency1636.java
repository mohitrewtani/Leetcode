package com.mohit.coding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SortArraybyIncreasingFrequency1636 {

	public static void main(String[] args) {
		/*
		 * Given an array of integers nums, sort the array in increasing order based on the frequency of the values. 
		 * If multiple values have the same frequency, sort them in decreasing order.
		 * Return the sorted array.
		 * Input: nums = [1,1,2,2,2,3]Output: [3,1,1,2,2,2]
		 * Input: nums = [-1,1,-6,4,5,-6,1,4,1]Output: [5,-1,4,4,-6,-6,1,1,1]
		 */
		int[] nums = {-1,1,-6,4,5,-6,1,4,1};
		int[] res = frequencySort(nums);
		for (int i = 0; i < res.length; i++) {
			System.out.print(res[i]+ " " );
		}
	}
    public static int[] frequencySort(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
			map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
		}
        List<Map.Entry<Integer,Integer> > list = new ArrayList<Map.Entry<Integer, Integer>>(map.entrySet());
        Collections.sort(list,(i1,i2)->i1.getValue()==i2.getValue()? i2.getKey()-i1.getKey():i1.getValue()-i2.getValue());
        int i = 0;
        for(Map.Entry<Integer, Integer> mapEntry : list) {
        	int val = mapEntry.getValue();
        	while(val > 0) {
        		val--;
        		nums[i] = mapEntry.getKey(); 
        		i++;
        	}
        }
		return nums;
        
    }

}
