/**
 * Plus Minus
 * https://www.hackerrank.com/challenges/plus-minus
 * point: 100/100
 */

import java.util.Scanner;

public class Main {

	String format(float f){
		return String.format("%.6f", f);
	}
	void run() {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int[] counts = new int[3];
		for (int i = 0; i < n; i++) {
			int value = scanner.nextInt();
			if (value > 0)
				counts[0]++;
			else if (value < 0)
				counts[1]++;
			else
				counts[2]++;
		}
		float tmp = n;
		System.out.println( format(counts[0] / tmp));
		System.out.println( format(counts[1] / tmp));
		System.out.println( format(counts[2] / tmp));

	}
	public static void main(String args[]) throws Exception {
		new Main().run();
	}
}
