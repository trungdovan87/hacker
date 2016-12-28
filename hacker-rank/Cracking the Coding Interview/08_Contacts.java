/**
 * Tries: Contacts
 * link: https://www.hackerrank.com/challenges/ctci-contacts
 * point: 14/14
 */

import java.util.*;

public class Main {
	void run() {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();

		SortedSet<String> tree = new TreeSet<>();

		for(int a0 = 0; a0 < n; a0++){
			String op = in.next();
			String contact = in.next();
			switch (op) {
				case "find":
					String to = contact + (char)('z' + 1);
					System.out.println(tree.subSet(contact, to).size());
					break;
				case "add":
					tree.add(contact);
					break;
			}
		}
	}
	public static void main(String[] args) {
		new Main().run();
	}
}

