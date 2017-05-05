/*
    link: https://www.hackerrank.com/challenges/30-binary-numbers?h_r=next-challenge&h_v=zen
    point: 100/100
*/

import java.util.Scanner;

public class Main {
    static boolean debug = false;

    public static void main(String[] args) {
        new Main().run();
    }

    void run() {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String b = Integer.toBinaryString(n);
        int max = 0;
        int pos = 0;
        while (pos < b.length()) {
            int len = 0;
            while (pos < b.length() && b.charAt(pos) == '1') {
                pos++;
                len++;
                if (len > max)
                    max = len;
            }
            pos++;
        }

        System.out.println(max);
    }
}