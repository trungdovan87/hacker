/**
 * Christmas Divisors
 * link: https://www.hackerearth.com/problem/approximate/christmas-divisors/
 * point: 100/100
 */

import java.util.Scanner;

public class Main {
	int k;
	long[] p;
	int[] a;
	int[] flag, start;

	void input() {
		Scanner scanner = new Scanner(System.in);
		k = scanner.nextInt();
		p = new long[k];
		a = new int[k];
		for (int i = 0; i < k; i++) {
			p[i] = scanner.nextLong();
			a[i] = scanner.nextInt();
		}
	}

	void init() {
		flag = new int[k];
		start = new int[k];
		for (int i = 0; i < k; i++) {
			flag[i] = 1;
			start[i] = 0;
		}
	}

	long power(long a, int k) {
		long result = 1;
		for (int i = 0; i < k; i++)
			result *= a;
		return result;
	}

	void recursive(long value, int i) {
		if (i == k) {
			System.out.print(value + " ");
			return;
		}
		if (flag[i] == -1) {
			start[i] = a[i];
		} else {
			start[i] = 0;
		}
		for (int r = start[i]; r <= a[i] && r >= 0; r = r + flag[i]) {
			recursive(power(p[i], r) * value, i + 1);
		}
		flag[i] = -flag[i];
	}

	void run() {
		input();
		init();
		recursive(1, 0);
	}

	public static void main(String args[]) throws Exception {
		new Main().run();
	}
}
