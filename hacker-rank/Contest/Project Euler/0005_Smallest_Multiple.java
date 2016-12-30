/**
 * Project Euler #5: Smallest multiple
 * link: https://www.hackerrank.com/contests/projecteuler/challenges/euler005
 * point: 100/100
 */

import java.util.*;

public class Main {
	List<Long> result;

	long smallestMultiple(long a, long b) {
		for (int i = 1; i <= b; i++) {
			if ((a * i) % b == 0)
				return a * i;
		}
		return -1;
	}

	void calculate() {
		result = new ArrayList<>();
		result.add(1l);
		for (long i = 1; i <= 40; i++) {
			result.add(smallestMultiple(result.get((int) i - 1), i));
		}
	}

	void run() {
		calculate();
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for (int a0 = 0; a0 < t; a0++) {
			int n = in.nextInt();
			System.out.println(result.get(n));
		}
	}

	public static void main(String[] args) {
		new Main().run();
	}
}
