package com.liu.leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class BinaryTreeInorderTraversal {
	static final class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}

		TreeNode() {
		}
	}

	public static ArrayList<Integer> preorderTraversal(TreeNode root) {
		if (root == null) {
			return null;
		}
		ArrayList<Integer> preorderTraversal = new ArrayList<>();
		preorderTraversal.add(root.val);
		if (root.left != null) {
			preorderTraversal.addAll(preorderTraversal(root.left));
		}
		if (root.right != null) {
			preorderTraversal.addAll(preorderTraversal(root.right));
		}
		return preorderTraversal;
	}

	public static ArrayList<Integer> preorderTraversalNonRecurion(TreeNode root) {
		if (root == null) {
			return null;
		}
		ArrayList<Integer> preorderTraversal = new ArrayList<>();
		Deque<TreeNode> deque = new ArrayDeque<>();
		deque.push(root);
		return preorderTraversal;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(0);
		root.left = null;
		root.right = new TreeNode(1);
		root.right.left = new TreeNode(2);
		System.out.println(preorderTraversal(root));
	}
}
