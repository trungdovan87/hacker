/**
 * Project Euler #6: Sum square difference
 * link: https://www.hackerrank.com/contests/projecteuler/challenges/euler006/submissions/code/8309303
 * point: 100/100
 */

import java.util.*;

public class Main {
	final int MAX_N = 10000;
	List<Long> result;

	void calculate() {
		result = new ArrayList<>();
		long sum = 0;
		long sumSquare = 0;
		result.add(0l);
		for (int i = 1; i <= MAX_N; i++) {
			sum += i;
			sumSquare += i * i;
			result.add(sum * sum - sumSquare);
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
