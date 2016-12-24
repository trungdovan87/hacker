/**
 * Chrismas String
 * @link: https://www.hackerearth.com/december-circuits-16/algorithm/christmas-string/
 * point: 10/100
 */

import java.util.*;
class Main {
	String s;
	int n;
	List<String> names;
	final char STAR = '*';

	void input() {
		Scanner scanner = new Scanner(System.in);
		s = scanner.next();
		n = scanner.nextInt();

		names = new ArrayList<String>(n);
		for (int i = 0; i < n; i++)
			names.add(scanner.next());
	}

	boolean match(int position, String second) {
		//thay * vao vi tri position
		for (int i = 0; i < second.length(); i++)
			if ((i != position) && (s.charAt(i) != STAR) && (s.charAt(i) != second.charAt(i)))
				return false;
		return true;
	}

	int calculateNumMatch(int position) {
		int result = 0;
		for (String s : names)
			if (match(position, s))
				result++;
		return result;
	}

	void process() {
		int max = 0;
		for (int i = -1; i < s.length(); i++) {
			int num = calculateNumMatch(i);
			if (max < num)
				max = num;
		}
		System.out.println(max);
	}

	void run() {
		input();
		process();
	}

	public static void main(String args[] ) throws Exception {
		new Main().run();
	}
}
