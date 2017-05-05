/*
    link: https://www.hackerrank.com/challenges/30-review-loop?h_r=next-challenge&h_v=zen
    point: 100/100
*/

import java.util.Scanner;

public class Main {
    static boolean debug = false;

    public static void main(String[] args) {
        new Main().run();
    }

    void run() {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int i = 0; i < T; i++) {
            String s = scanner.next();
            StringBuilder builder = new StringBuilder();
            for (int even = 0; even < s.length(); even +=2)
                builder.append(s.charAt(even));
            String s1 = builder.toString();
            builder = new StringBuilder();
            for (int odd = 1; odd < s.length(); odd +=2)
                builder.append(s.charAt(odd));
            String s2 = builder.toString();

            System.out.println(s1 + " " + s2);
        }
    }
}