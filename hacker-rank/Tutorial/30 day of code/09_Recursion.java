/*
    link: https://www.hackerrank.com/challenges/30-recursion?h_r=next-challenge&h_v=zen
    point: 100/100
*/

import java.util.Scanner;

public class Main {
    static boolean debug = false;

    public static void main(String[] args) {
        new Main().run();
    }

    int f(int n) {
        if (n <= 1) return 1;
        return n * f(n - 1);
    }

    void run() {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        System.out.println(f(n));
    }
}