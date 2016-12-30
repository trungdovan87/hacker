/**
 * Day 1: Data Types
 * https://www.hackerrank.com/challenges/30-data-types
 * point: 2/2
 */

import java.util.*;

public class Main {

	void run() {
		int i = 4;
		double d = 4.0;
		String s = "HackerRank ";

		Scanner scan = new Scanner(System.in);

		System.out.println(i + scan.nextInt());
		System.out.println(d + scan.nextDouble());
		scan.nextLine();
		System.out.println(s + scan.nextLine());

		scan.close();
	}
	static boolean debug = false;

	public static void main(String args[]) throws Exception {
		new Main().run();
	}
}
