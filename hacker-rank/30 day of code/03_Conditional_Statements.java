/**
 * Day 3: Intro to Conditional Statements
 * link: https://www.hackerrank.com/challenges/30-conditional-statements
 */

import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		if (n % 2 == 1)
			weird(true);
		else {
			if (n >= 2 && n <= 5)
				weird(false);
			else if (n >= 6 && n <= 20)
				weird(true);
			else if (n > 10)
				weird(false);
		}
	}

	private static void weird(boolean b) {
		if (b)
			System.out.println("Weird");
		else
			System.out.println("Not Weird");
	}
}
