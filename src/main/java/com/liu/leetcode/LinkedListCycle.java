package com.liu.leetcode;

import java.util.HashSet;
import java.util.Set;

public class LinkedListCycle {
	public static final class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}

		@Override
		public String toString() {
			return "ListNode [val=" + val + "]";
		}
	}

	public static boolean hasCycle(ListNode head) {
		if (head == null) {
			return false;
		}
		ListNode pointer1 = head;
		ListNode pointer2 = head;
		while (pointer1 != null && pointer2 != null) {
			pointer1 = pointer1.next;
			if (pointer2.next != null) {
				pointer2 = pointer2.next.next;
			} else {
				return false;
			}
			if (pointer1 == pointer2) {
				return true;
			}
		}
		return false;
	}

	public static ListNode getCycleStartNode(ListNode head) {
		if (head == null) {
			return null;
		}
		Set<ListNode> traversal = new HashSet<>();
		while (head != null) {
			if (traversal.contains(head)) {
				return head;
			}
			traversal.add(head);
			head = head.next;
		}
		return null;
	}

	/**
	 * 
		start at x
		cycle length y
		slow: x+ty+m
		fast:x+ky+m
		
		2x+2ty+2m=x+ky+m
		->x+m=ky-2ty
		
		(x+m) mod y=k-2t
		0+x
		x+m+ty+x
	 * @param head
	 * @return
	 */
	public static ListNode getCycleStartNodeNonEntraSpace(ListNode head) {
		if (head == null) {
			return null;
		}
		ListNode pointer1 = head;
		ListNode pointer2 = head;
		while (pointer1 != null && pointer2 != null) {
			pointer1 = pointer1.next;
			if (pointer2.next == null) {
				return null;
			}
			pointer2 = pointer2.next.next;
			if (pointer1 == pointer2) {
				break;
			}
		}
		if (pointer1 == null || pointer2 == null) {
			return null;
		}
		pointer1 = head;
		while (pointer1 != pointer2) {
			pointer1 = pointer1.next;
			pointer2 = pointer2.next;
		}
		return pointer1;
	}

	public static void main(String[] args) {
		ListNode head = new ListNode(0);
		ListNode copyHead = head;
		for (int i = 1; i < 2; i++) {
			head.next = new ListNode(i);
			head = head.next;
		}
		head.next = copyHead;
		System.out.println(hasCycle(head));
		System.out.println(getCycleStartNode(head));
		System.out.println(getCycleStartNodeNonEntraSpace(head));
	}
}
