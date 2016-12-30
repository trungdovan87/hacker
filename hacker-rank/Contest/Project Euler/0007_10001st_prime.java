/**
 * Project Euler #7: 10001st prime
 * https://www.hackerrank.com/contests/projecteuler/challenges/euler007
 * point: 100/100
 */

import java.util.*;

public class Main {
	final int MAX_N = 10000;
	List<Long> primes;

	void calculate() {
		primes = new ArrayList<>(MAX_N);
		primes.add(2l);
		for (int i = 1; i < MAX_N; i++) {
			long tmp = primes.get(primes.size() - 1) + 1;
			while (true) {
				boolean isPrime = true;
				for (long element : primes)
					if (tmp % element == 0) {
						isPrime = false;
						break;
					}
				if (isPrime) {
					primes.add(tmp);
					break;
				} else {
					tmp++;
				}
			}
		}
	}

	void run() {
		calculate();
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for (int a0 = 0; a0 < t; a0++) {
			int n = in.nextInt();
			System.out.println(primes.get(n - 1));
		}
	}

	public static void main(String[] args) {
		new Main().run();
	}
}
