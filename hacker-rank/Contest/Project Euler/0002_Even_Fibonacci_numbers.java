/**
 * Project Euler #2: Even Fibonacci numbers
 * link: https://www.hackerrank.com/contests/projecteuler/challenges/euler002
 * point: 100/100
 */

import java.util.*;

public class Main {

	long MAX_N = 40000000000000000l; //4 * 10 ^ 6

	List<Long> e = new ArrayList<>();
	List<Long> sum = new ArrayList<>();

	// E(n) = 4 E(n-1) + E(n)
	// E(0) = 2, E(1) = 8]
	void caculate() {
		e.add(2l);
		e.add(8l);
		sum.add(2l);
		sum.add(10l);

		while (e.get(e.size() - 1) <= MAX_N) {
			long tmp = 4 * e.get(e.size() - 1) + e.get(e.size() - 2);
			e.add(tmp);
			sum.add(tmp + sum.get(sum.size() - 1));
		}
	}

	long result(long n) {
		for (int i = e.size() - 1; i >= 0; i--) {
			if (e.get(i) <= n)
				return sum.get(i);
		}
		return 0;
	}

	void run() {
		caculate();
		Scanner scanner = new Scanner(System.in);
		int t = scanner.nextInt();
		for (int i = 0; i < t; i++) {
			System.out.println(result(scanner.nextLong()));
		}

		scanner.close();
	}

	public static void main(String[] args) {
		new Main().run();
	}
}
