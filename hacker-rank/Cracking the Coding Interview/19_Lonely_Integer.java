/**
 * Bit Manipulation: Lonely Integer
 * link: https://www.hackerrank.com/challenges/ctci-lonely-integer
 * point: 9/9
 */

import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		Set<Integer> set = new HashSet<>(n);
		for(int a_i=0; a_i < n; a_i++){
			int a = in.nextInt();
			if (set.contains(a))
				set.remove(a);
			else
				set.add(a);
		}
		System.out.println(set.iterator().next());
	}
}

