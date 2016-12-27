/**
 * Hash Tables: Ransom Note
 * https://www.hackerrank.com/challenges/ctci-ransom-note
 * point: 20/20
 */

import java.util.*;

public class Main {
	Map<String, Integer> magazine, ransom;

	void inputWords(Scanner scanner, int n, Map<String, Integer> map) {
		for (int i = 0; i < n; i++) {
			String s = scanner.next();
			if (!map.containsKey(s))
				map.put(s, 1);
			else
				map.put(s, map.get(s) + 1);
		}
	}

	void answer(boolean yes) {
		if (yes)
			System.out.println("Yes");
		else
			System.out.println("No");
		System.exit(0);
	}

	void run() {
		Scanner in = new Scanner(System.in);
		int m = in.nextInt();
		int n = in.nextInt();

		magazine = new HashMap<>(m);
		ransom = new HashMap<>(n);

		inputWords(in, m, magazine);
		inputWords(in, n, ransom);

		for (Map.Entry<String, Integer> entry : ransom.entrySet())
		{
			Integer value = magazine.get(entry.getKey());
			int num = (value == null) ? 0 : value;
			if (num < entry.getValue())
				answer(false);
		}
		answer(true);
	}


	static boolean debug = false;

	public static void main(String args[]) throws Exception {
		new Main().run();
	}
}
