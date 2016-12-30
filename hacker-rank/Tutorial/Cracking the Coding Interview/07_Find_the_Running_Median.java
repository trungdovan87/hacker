/**
 * Heaps: Find the Running Median
 * link: https://www.hackerrank.com/challenges/ctci-find-the-running-median
 * point: 10/10
 */

import java.util.*;

public class Main {
	void run() {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] a = new int[n];
		for (int a_i = 0; a_i < n; a_i++) {
			a[a_i] = in.nextInt();
		}

		float median;
		//lower poll: get max
		PriorityQueue<Integer> lower = new PriorityQueue<Integer>(10000, Comparator.reverseOrder());


		//higher poll: get min
		PriorityQueue<Integer> higher = new PriorityQueue<Integer>();

		for (int c : a) {
			if (lower.isEmpty())
				lower.add(c);
			else {
				// lower.size chi co the bang: highger.size hoac highger.size + 1
				if (lower.size() > higher.size()) {
					// lower is bigger
					if (lower.peek() <= c) {
						higher.add(c);
					} else {
						// Balance - Take highest from lower, put it in higher
						higher.add(lower.poll());
						lower.add(c);
					}

				} else {
					// higher is bigger, or equal
					if (higher.isEmpty())
						lower.add(c);
					else if (higher.peek() >= c) {
						lower.add(c);
					} else {
						// Remove one from higher
						lower.add(higher.poll());
						higher.add(c);
					}

				}
			}
			int s = lower.size() + higher.size();
			if (s % 2 == 0) {
				median = (lower.peek() + higher.peek()) / 2.0f;
			} else {
				median = (float) lower.peek();
			}
			System.out.println(median);

		}
	}


	public static void main(String args[]) throws Exception {
		new Main().run();
	}
}
