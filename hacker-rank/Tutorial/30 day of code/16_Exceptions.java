/*
    link: https://www.hackerrank.com/challenges/30-exceptions-string-to-integer?h_r=next-challenge&h_v=zen
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
        String s = in.next();
        try {
           int value = Integer.parseInt(s);
           System.out.println(value);
        } catch (NumberFormatException e) {
            System.out.println("Bad String");
        }
    }

}