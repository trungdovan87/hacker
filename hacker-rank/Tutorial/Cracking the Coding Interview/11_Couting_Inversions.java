/**
 * Merge Sort: Counting Inversions
 * link: https://www.hackerrank.com/challenges/ctci-merge-sort
 * point: 14/14
 */

import java.util.*;

public class Main {
	private static long countInversions(int[] arr) {
		int[] aux = arr.clone();
		return countInversions(arr, 0, arr.length - 1, aux);
	}

	private static long countInversions(int[] arr, int lo, int hi, int[] aux) {
		if (lo >= hi) return 0;

		int mid = lo + (hi - lo) / 2;

		long count = 0;
		count += countInversions(aux, lo, mid, arr);
		count += countInversions(aux, mid + 1, hi, arr);
		count += merge(arr, lo, mid, hi, aux);

		return count;
	}

	private static long merge(int[] arr, int lo, int mid, int hi, int[] aux) {
		long count = 0;
		int i = lo, j = mid + 1, k = lo;
		while (i <= mid || j <= hi) {
			if (i > mid) {
				arr[k++] = aux[j++];
			} else if (j > hi) {
				arr[k++] = aux[i++];
			} else if (aux[i] <= aux[j]) {
				arr[k++] = aux[i++];
			} else {
				arr[k++] = aux[j++];
				count += mid + 1 - i;
			}
		}

		return count;
	}
	private static void run() {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for(int a0 = 0; a0 < t; a0++){
			int n = in.nextInt();
			int arr[] = new int[n];
			for(int arr_i=0; arr_i < n; arr_i++){
				arr[arr_i] = in.nextInt();
			}
			System.out.println(countInversions(arr));
		}
	}


	public static void main(String args[]) throws Exception {
		run();
	}
}
