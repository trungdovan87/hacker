/**
 * Recursion: Davis' Staircase
 * link: https://www.hackerrank.com/challenges/ctci-recursive-staircase
 * point: 9/9
 */

import java.util.*;

public class Main {
	public static void main(String[] args) {
		// f(n) = f(n-3) + f(n-2) + f(n-1)

		int MAX_N = 36;
		int[] result = new int[MAX_N + 1];
		result[0] = 1;
		result[1] = 1;
		result[2] = 2;
		for (int i = 3; i < result.length; i++)
			result[i] = result[i - 3] + result[i - 2] + result[i - 1];

		Scanner in = new Scanner(System.in);
		int s = in.nextInt();
		for(int a0 = 0; a0 < s; a0++){
			int n = in.nextInt();
			System.out.println(result[n]);
		}
	}
}

