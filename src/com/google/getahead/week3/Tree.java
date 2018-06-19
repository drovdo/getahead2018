package com.google.getahead.week3;

public class Tree {

	private class IntegerHolder {
		private int integer;

		public IntegerHolder(int integer) {
			this.integer = integer;
		}
	}


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
		return longestPath.integer;
	}

	private void walk(TreeNode node, IntegerHolder longestPath) {
		for(TreeNode child : node.getChildren()) {
			if(child.getValue() == node.getValue() + 1) {
				child.incrementCurrentPathLength(node.getCurrentPathLength());
				if(longestPath.integer < child.getCurrentPathLength()) {
					longestPath.integer = child.getCurrentPathLength();
				}
			}
			walk(child, longestPath);
		}
	}
}
