/*
    link: https://leetcode.com/problems/two-sum/description/
    point: 100/100
*/

import java.util.*;

public class Main {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int x = target - nums[i];
            if (map.containsKey(x)) {
                return new int[]{map.get(x), i};
            } else {
                map.put(nums[i], i);
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2, 7, 11, 15};
        int[] result = new Main().twoSum(arr, 9);
        System.out.println(result[0] + " " + result[1]);
    }
}