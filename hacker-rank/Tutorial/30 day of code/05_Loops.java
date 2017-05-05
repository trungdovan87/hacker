/*
    link: https://www.hackerrank.com/challenges/30-loops
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
        int n = scanner.nextInt();
        for (int i = 1; i <= 10; i++) {
            System.out.println(String.format("%d x %d = %d", n, i, n * i));
        }
    }
}