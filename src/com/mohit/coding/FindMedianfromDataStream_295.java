package com.mohit.coding;

import java.util.Collections;
import java.util.PriorityQueue;

class MedianFinder {
	PriorityQueue<Integer> minHeap;
	PriorityQueue<Integer> maxHeap;

    public MedianFinder() {
    	minHeap = new PriorityQueue<Integer>();
    	maxHeap = new PriorityQueue<Integer>(Collections.reverseOrder());
    }
    
    public void addNum(int num) {
        maxHeap.add(num);
        minHeap.add(maxHeap.poll());
        if(minHeap.size() > maxHeap.size())
        	maxHeap.add(minHeap.poll());
    }
    
    public double findMedian() {
    	if(maxHeap.size() > minHeap.size())
    		return maxHeap.peek()/1.0;
    	else {
    		return (minHeap.peek()/2.0 + maxHeap.peek()/2.0);
    	}
    }
}

public class FindMedianfromDataStream_295 {

	public static void main(String[] args) {
		MedianFinder medianFinder = new MedianFinder();
		medianFinder.addNum(1);    // arr = [1]
		medianFinder.addNum(2);    // arr = [1, 2]
		System.out.println(medianFinder.findMedian()); // return 1.5 (i.e., (1 + 2) / 2)
		medianFinder.addNum(3);    // arr[1, 2, 3]
		System.out.println(medianFinder.findMedian());// return 2.0
	}

}
