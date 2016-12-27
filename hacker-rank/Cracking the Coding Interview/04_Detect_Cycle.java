/**
 * Linked Lists: Detect a Cycle
 * https://www.hackerrank.com/challenges/ctci-linked-list-cycle
 * point: 2/2
 */

import java.util.*;

public class Main {
	class Node {
		int data;
		Node next;
	}

	boolean hasCycle(Node head) {
		Set<Node> nodeSet = new HashSet<>(100);
		Node node = head;
		while (node != null){
			if (!nodeSet.contains(node))
				nodeSet.add(node);
			else
				return true;
			node = node.next;
		}
		return false;
	}

	void run() {
	}


	public static void main(String args[]) throws Exception {
		new Main().run();
	}
}
