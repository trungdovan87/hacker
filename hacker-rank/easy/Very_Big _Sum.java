/**
 * A Very Big Sum
 * https://www.hackerrank.com/challenges/a-very-big-sum
 * point: 2/2
 */

import java.util.*;

public class Main {

	void run() {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		long sum = 0;;
		for (int i = 0; i < n; i++) {
			sum += scan.nextInt();
		}
		System.out.println(sum);
		scan.close();
	}
	static boolean debug = false;

	public static void main(String args[]) throws Exception {
		new Main().run();
	}
}
