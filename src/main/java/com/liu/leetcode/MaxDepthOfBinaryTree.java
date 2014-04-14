package com.liu.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

import sun.reflect.generics.tree.Tree;



public class MaxDepthOfBinaryTree {
	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		
		TreeNode(int x) {
			val = x;
		}
		
		TreeNode() {
		}
	};
	public class DepthNode {
		TreeNode node;
		int depth;

		public DepthNode(TreeNode node, int depth) {
			this.node = node;
			this.depth = depth;
		}
	}

	public static int maxDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int depth = 0;
		int leftDepth = maxDepth(root.left);
		int rigthDepth = maxDepth(root.right);
		depth = (leftDepth > rigthDepth ? leftDepth : rigthDepth) + 1;
		return depth;
	}

	public int maxDepthNonRecursion(TreeNode root) {
		if (root == null) {
			return 0;
		}
		Deque<DepthNode> deque = new ArrayDeque<>();
		deque.push(new DepthNode(root, 1));
		DepthNode depthNode;
		int max = 0;
		while (null != (depthNode = deque.poll())) {
			TreeNode leftNode = depthNode.node.left;
			TreeNode rigthNode = depthNode.node.right;
			if (leftNode == null && rigthNode == null) {
				max = depthNode.depth > max ? depthNode.depth : max;
			} else {
				if (null != leftNode) {
					deque.push(new DepthNode(leftNode, depthNode.depth+1));
				}
				if (null != rigthNode) {
					deque.push(new DepthNode(rigthNode, depthNode.depth+1));
				}
			}

		}
		return max;
	}

	public static void main(String[] args) {
//		TreeNode root = new TreeNode();
//		System.out.println(maxDepthNonRecursion(root));
//		root.left = new TreeNode();
//		System.out.println(maxDepthNonRecursion(root));
	}
}
