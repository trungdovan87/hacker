/*
    link: https://leetcode.com/problems/palindrome-number/description/
    point: 100/100
*/

import java.util.*;

public class Main {
    int sum(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
        }
        return sum;
    }

    void run() {
        System.out.println("calculate sum from 1 to n");
        System.out.println("input n:");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println("sum is: " + sum(n));
    }

    public static void main(String[] args) {
        new Main().run();
    }
}