/*
    link: https://leetcode.com/problems/palindrome-number/description/
    point: 100/100
*/

import java.util.*;

public class Main {

    public boolean isPalindrome(int x) {
        String s = String.valueOf(x);
        String reverse = new StringBuilder(s).reverse().toString();
        return s.equals(reverse);
    }

    public static void main(String[] args) {
        boolean result = new Main().isPalindrome(-12321);
        System.out.println(result);
    }
}