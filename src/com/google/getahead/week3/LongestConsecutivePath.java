package com.google.getahead.week3;

/**
 Write a function that computes the length of the longest path of consecutive integers in a tree.

 A node in the tree has a value and a set of children nodes. A tree has no cycles and each node has exactly one parent.
 A path where each node has a value 1 greater than its parent is a path of consecutive integers (e.g. 1,2,3 not 1,3,5).

 A few things to clarify:
 - Integers are all positive
 - Integers appear only once in the tree

 Test Cases
 Note that there may be other valid answers.
 For the below tree, the length of the longest path is 2 (for path 1->2)
 1 -> 2 -> 4
   -> 3
 For the below tree, the max length is 4
 5 -> 6
   -> 7 -> 12
        -> 8 -> 9 -> 15
                  -> 10
 *
 */

public class LongestConsecutivePath {

	private static void test(Tree tree, int expectedAnswer) {
		int answer = tree.getLongestConsecutivePathLength();
		if(answer != expectedAnswer) {
			throw new RuntimeException("Validation failed, expected " + expectedAnswer + " but found " + answer);
		}
	}

	private static void test1() {
		TreeNode leaf = new TreeNode(4);
		TreeNode node1 = new TreeNode(2);
		node1.addChild(leaf);
		TreeNode node2 = new TreeNode(3);
		TreeNode root = new TreeNode(1);
		root.addChild(node1);
		root.addChild(node2);

		Tree tree = new Tree(root);
		test(tree, 2);

	}

	private static void test2() {
		TreeNode leaf1 = new TreeNode(15);
		TreeNode leaf2 = new TreeNode(10);
		TreeNode node1 = new TreeNode(9);
		node1.addChild(leaf1);
		node1.addChild(leaf2);
		TreeNode node2 = new TreeNode(8);
		node2.addChild(node1);
		TreeNode node3 = new TreeNode(7);
		node3.addChild(new TreeNode(12));
		node3.addChild(node2);
		TreeNode root = new TreeNode(5);
		root.addChild(node3);
		root.addChild(new TreeNode(6));

		Tree tree = new Tree(root);
		test(tree, 4);

	}

	public static void main(String[] args) {
		test1();
		test2();
	}
}
