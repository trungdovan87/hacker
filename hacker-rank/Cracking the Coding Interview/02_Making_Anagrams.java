/**
 * Strings: Making Anagrams
 * https://www.hackerrank.com/challenges/ctci-making-anagrams
 * point: 15/15
 */

import java.util.*;

public class Main {
	final int NUM_LETTER =  'z' - 'a' + 1;
	int[] calculateFrequency(String a) {
		int[] result = new int[NUM_LETTER];
		for (int i = 0; i < a.length(); i++)
			result[ a.charAt(i) - 'a' ]++;
		return result;
	}

	int numberNeeded(String a, String b) {
		int[] arrA = calculateFrequency(a);
		int[] arrB = calculateFrequency(b);
		int result = 0;
		for (int i = 0; i < NUM_LETTER; i++)
			result += Math.abs(arrA[i] - arrB[i]);
		return result;
	}

	void run() {
		Scanner in = new Scanner(System.in);
		String a = in.next();
		String b = in.next();
		System.out.println(numberNeeded(a, b));
	}

	static boolean debug = false;

	public static void main(String args[]) throws Exception {
		new Main().run();
	}
}
