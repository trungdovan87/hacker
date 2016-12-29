/**
 * Intro to Tutorial Challenges
 * link: https://www.hackerrank.com/challenges/tutorial-intro
 * point: 100/100
 */

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int v = scanner.nextInt();
		int n = scanner.nextInt();
		for (int i = 0; i < n; i++)
			if (v == scanner.nextInt()) {
				System.out.println(i);
				return;
			}
	}
}
