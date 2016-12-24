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

	boolean match(String first, String second) {
		int length = first.length();
		for (int i = 0; i < length; i++)
			if ((first.charAt(i) != STAR) && first.charAt(i) != second.charAt(i))
				return false;
		return true;
	}

	int calculateNumMatch(String str) {
		int result = 0;
		for (String s : names)
			if (match(str, s))
				result++;
		return result;
	}

	void process() {
		int max = calculateNumMatch(s);
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) != STAR) {
				StringBuilder builder = new StringBuilder(s.length());
				for (int tmp = 0; tmp < s.length(); tmp++)
					if (i != tmp)
						builder.append(s.charAt(tmp));
					else
						builder.append(STAR);
				String test = builder.toString();
				int num = calculateNumMatch(test);
				if (max < num)
					max = num;
			}
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
