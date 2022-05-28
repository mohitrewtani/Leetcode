package com.mohit.coding;

import java.util.Comparator;
import java.util.PriorityQueue;

class ListNode {
	int val;
	ListNode next;
	ListNode() {}
	ListNode(int val) { this.val = val; }
	ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
public class MergekSortedLists_23 {

	public static void main(String[] args) {
		/*
		 * You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.
		 * Merge all the linked-lists into one sorted linked-list and return it.
		 * Input: lists = [[1,4,5],[1,3,4],[2,6]] Output: [1,1,2,3,4,4,5,6]
		 */
		ListNode list1 = new ListNode(1);
		list1.next = new ListNode(4);		
		list1.next.next = new ListNode(5);
		ListNode list2 = new ListNode(1);
		list2.next = new ListNode(3);		
		list2.next.next = new ListNode(4);
		ListNode list3 = new ListNode(2);
		list3.next = new ListNode(6);
		ListNode[] lists = {list1,list2,list3};
		ListNode res = mergeKLists(lists);
		while(res != null) {
			System.out.print(" " + res.val + " ");
			res = res.next;
		}
	}

	private static ListNode mergeKLists(ListNode[] lists) {
		PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>(new Comparator<ListNode>(){
			@Override
			public int compare(ListNode l1, ListNode l2) {
				return l1.val-l2.val;
			}
		});
		for (int i = 0; i < lists.length; i++) {
			if(lists[i] != null)
				pq.add(lists[i]);
		}
		ListNode dummy = new ListNode(0);
		ListNode tail = dummy;
		while(!pq.isEmpty()) {
			tail.next = pq.poll();
			tail = tail.next;
			if(tail.next != null) {
				pq.add(tail.next);
			}
		}
		return dummy.next;
	}
}
