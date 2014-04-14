package com.liu.leetcode;


public class SortLinkedList {
	static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public static ListNode sortList(ListNode head) {
		mergeSort(head);
		return quickSort(head);
	}

	public static ListNode mergeSort(ListNode head) {
		if (head == null) {
			return null;
		}
		
		return null;
	}

	public static ListNode quickSort(ListNode head) {
		if (head == null) {
			return null;
		}
		return null;
	}
	
	public static void main(String[] args) {
	}
}
