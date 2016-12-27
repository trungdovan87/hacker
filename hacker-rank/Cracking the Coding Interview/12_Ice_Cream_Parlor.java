/**
 * Binary Search: Ice Cream Parlor
 * link: https://www.hackerrank.com/challenges/ctci-ice-cream-parlor
 * point: 3/3
 */

import java.util.*;

public class Main {
	public static int[] twoSum(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			map.put(nums[i], i);
		}
		for (int i = 0; i < nums.length; i++) {
			int complement = target - nums[i];
			if (map.containsKey(complement) && map.get(complement) != i) {
				return new int[] { i, map.get(complement) };
			}
		}
		throw new IllegalArgumentException("No two sum solution");
	}
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for(int a0 = 0; a0 < t; a0++){
			int m = in.nextInt();
			int n = in.nextInt();
			int a[] = new int[n];
			for(int a_i=0; a_i < n; a_i++){
				a[a_i] = in.nextInt();
			}
			int[] result = twoSum(a, m);
			result[0]++;
			result[1]++;
			if (result[0] < result[1])
				System.out.println(result[0] + " " + result[1]);
			else
				System.out.println(result[1] + " " + result[0]);
		}
	}
}
