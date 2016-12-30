/**
 * Project Euler #4: Largest palindrome product
 * link: https://www.hackerrank.com/contests/projecteuler/challenges/euler004/submissions/code/8309257
 * point: 100/100
 */

import java.util.*;

public class Main {
	SortedSet<Integer> generatePalindromes() {
		SortedSet<Integer> set = new TreeSet<>();
		for (int i = 100; i < 1000; i++)
			for (int j = 100; j < 1000; j++)
				if (isPalindrome(i * j))
					set.add(i * j);
		return set;
	}

	boolean isPalindrome(int n) {
		String s = String.valueOf(n);
		for (int i = 0; i < s.length() / 2; i++)
			if (s.charAt(i) != s.charAt(s.length() - 1 -i))
				return false;
		return true;
	}

	void run() {
		SortedSet<Integer> set = generatePalindromes();

		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for(int a0 = 0; a0 < t; a0++){
			int n = in.nextInt();
			System.out.println(set.headSet(n - 1).last());
		}
	}

	public static void main(String[] args) {
		new Main().run();
	}
}
