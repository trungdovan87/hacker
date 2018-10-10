/*
    link: https://leetcode.com/problems/reverse-integer/description/
    point: 100/100
*/

import java.util.*;

public class Main {

    public int reverse(int x) {
        try {
            int a = Integer.valueOf(new StringBuilder(String.valueOf(Math.abs(x))).reverse().toString());
            return x < 0 ? -a : a;
        } catch (Exception ex) {
            return 0;
        }
    }

    public static void main(String[] args) {
        int result = new Main().reverse(-1234567);
        System.out.println(result);
    }
}
