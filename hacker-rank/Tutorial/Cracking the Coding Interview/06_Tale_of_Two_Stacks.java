/**
 * Queues: A Tale of Two Stacks
 * link: https://www.hackerrank.com/challenges/ctci-queue-using-two-stacks
 * point: 16/16
 */

import java.util.*;

public class Main {

	void run() {
		Queue<Integer> queue = new LinkedList<>();

		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();

		for (int i = 0; i < n; i++) {
			int operation = scan.nextInt();
			if (operation == 1) { // enqueue
				queue.add(scan.nextInt());
			} else if (operation == 2) { // dequeue
				queue.poll();
			} else if (operation == 3) { // print/peek
				System.out.println(queue.peek());
			}
		}
		scan.close();
	}


	public static void main(String args[]) throws Exception {
		new Main().run();
	}
}
