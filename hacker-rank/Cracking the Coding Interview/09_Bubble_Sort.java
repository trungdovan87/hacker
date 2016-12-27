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
		int num = 0;
		for (int i = 0; i < n; i++) {
			// Track number of elements swapped during a single array traversal
			int numberOfSwaps = 0;

			for (int j = 0; j < n - 1; j++) {
				// Swap adjacent elements if they are in decreasing order
				if (a[j] > a[j + 1]) {
					int tmp = a[j];
					a[j] = a[j + 1];
					a[j + 1] = tmp;
					numberOfSwaps++;
				}
			}
			num += numberOfSwaps;
			// If no elements were swapped during a traversal, array is sorted
			if (numberOfSwaps == 0) {
				break;
			}
		}
		System.out.println(String.format("Array is sorted in %d swaps.", num));
		System.out.println(String.format("First Element: %d", a[0]));
		System.out.println(String.format("Last Element: %d", a[a.length - 1]));
	}


	public static void main(String args[]) throws Exception {
		new Main().run();
	}
}
