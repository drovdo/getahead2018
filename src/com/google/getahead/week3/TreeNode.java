package com.google.getahead.week3;

import java.util.ArrayList;
import java.util.List;

public class TreeNode {
	private int value;
	private int currentPathLength;
	private List<TreeNode> children;

	public TreeNode(int value) {
		this.value = value;
		currentPathLength = 1;
		children = new ArrayList<>();
	}

	public int getValue() {
		return value;
	}

	public int getCurrentPathLength() {
		return currentPathLength;
	}

	public List<TreeNode> getChildren() {
		return children;
	}

	public void incrementCurrentPathLength(int value) {
		currentPathLength += value;
	}

	public void addChild(TreeNode node) {
		children.add(node);
	}
}
