/**
 * Recursion: Fibonacci Numbers
 * link: https://www.hackerrank.com/challenges/ctci-fibonacci-numbers
 * point: 4/4
 */

import java.util.*;

public class Main {

	public static int fibonacci(int n) {

		// Complete the function.
		if (n == 0)
			return 0;
		if (n == 1)
			return 1;
		int f0 = 0;
		int f1 = 1;
		int f2 = 0;
		for (int i = 2; i <= n; i++) {
			f2 = f0 + f1;
			f0 = f1;
			f1 = f2;
		}
		return f2;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		scanner.close();
		System.out.println(fibonacci(n));
	}
}

