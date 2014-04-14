package com.liu.leetcode;

public class SameTree {
	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}

	}

	public static boolean isSameTree(TreeNode p, TreeNode q) {
		if (p == q && p == null) {
			return true;
		}
		if (p == null || q == null) {
			return false;
		}
		if (p.val == q.val) {
			boolean left = isSameTree(p.left, q.left);
			if (!left) {
				return false;
			}
			boolean right = isSameTree(p.right, q.right);

			if (!right) {
				return false;
			}
			return true;
		}
		return false;
	}

	public static boolean isTreeNodeEqual(TreeNode p, TreeNode q) {
		if (p == q && p == null) {
			return true;
		}
		if (p == null || q == null) {
			return false;
		}
		if (p.val == q.val) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(0);
//		root.left = new TreeNode(1);
		TreeNode root2 = new TreeNode(0);
//		root2.left = new TreeNode(1);
		System.out.println(isSameTree(root, root2));
	}
}
