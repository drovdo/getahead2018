package com.google.getahead.week3;

public class Tree {

	private TreeNode root;

	public Tree() {
		root = null;
	}

	public Tree(TreeNode root) {
		this.root = root;
	}

	public int getLongestConsecutivePathLength() {
		if (root == null) {
			return 0;
		}

		IntegerHolder longestPath = new IntegerHolder(0);
		walk(root, longestPath);
		return longestPath.getInteger();
	}

	private void walk(TreeNode node, IntegerHolder longestPath) {
		for(TreeNode child : node.getChildren()) {
			if(child.getValue() == node.getValue() + 1) {
				child.incrementCurrentPathLength(node.getCurrentPathLength());
				if(longestPath.getInteger() < child.getCurrentPathLength()) {
					longestPath.setInteger(child.getCurrentPathLength());
				}
			}
			walk(child, longestPath);
		}
	}
}
