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

	// 0..size: chi khac nhau duy nhat 1 cho tai do
	// -1: giong het nhau
	// -2: nhieu hon 2 cho khac nhau
	int calculateDiffer(String first, String second) {
		int result = -3; // chua co diem khac nhau
		for (int i = 0; i < first.length(); i++) {
			//neu co them 1 diem khac nhau
			if (first.charAt(i) != STAR && first.charAt(i) != second.charAt(i)) {
				// neu khong co diem khac nhau, thi result = i, co 1 vi tri khac nhau
				if (result == -3) {
					result = i;
				} else if (result >= 0) {
					//neu da co 1 diem khac nhau, return -2: co nhieu hon 2  cho khac nhau
					return -2;
				}
			}
		}
		//khong co diem khac nhau
		if (result == -3)
			return -1;
		else
			// co duy nhat 1 diem khac nhau
			return result;
	}

	void process() {
		int[] differ = new int[n];
		for (int i = 0; i < n; i++)
			differ[i] = calculateDiffer(s, names.get(i));
		if (debug) {
			for (int i = 0; i < differ.length; i++)
				System.out.print(", " + differ[i]);
			System.out.println("----");
		}

		int max = 0;
		for (int i = 0; i < s.length(); i++) {
			int match = 0;
			for (int j = 0; j < n; j++) {
				// neu giong het nhau, hoac khac nhau duy nhat tai diem i, thi match
				if (differ[j] == -1 || differ[j] == i)
					match++;
			}
			if (max < match)
				max = match;
		}
		System.out.println(max);
	}

	void run() {
		input();
		process();
	}

	static boolean debug = false;
	public static void main(String args[] ) throws Exception {
		new Main().run();
	}
}
