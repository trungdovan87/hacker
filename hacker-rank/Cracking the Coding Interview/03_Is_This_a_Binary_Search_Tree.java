/**
 * Trees: Is This a Binary Search Tree
 * https://www.hackerrank.com/challenges/ctci-is-binary-search-tree
 * point: 20/20
 */

import java.util.*;

public class Main {

	class Node {
		int data;
		Node left;
		Node right;
	}

	boolean checkBST(Node root) {
		if (root.left == null && root.right == null)
			return true;
		if (root.left != null) {
			if (!checkBST(root.left))
				return false;
			Node rightest = rightestNode(root.left);
			if (root.data <= rightest.data)
				return false;
		}

		if (root.right != null) {
			if (!checkBST(root.right))
				return false;
			Node leftest = leftestNode(root.right);
			if (root.data >= leftest.data)
				return false;
		}
		return true;
	}

	private Node leftestNode(Node root) {
		Node node = root;
		while (node.left != null)
			node = node.left;
		return node;
	}

	private Node rightestNode(Node root) {
		Node node = root;
		while (node.right != null)
			node = node.right;
		return node;
	}

	static boolean debug = false;

	public static void main(String args[]) throws Exception {
		//new Main().run();
	}
}
