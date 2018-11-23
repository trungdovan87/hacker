/*
    title: The Coin Change Problem
    link: https://www.hackerrank.com/challenges/coin-change/problem
    point: 100/100
*/

import java.util.*;

public class Main {
    int n, m;
    int[] c;
    long[][] q;

    void run() {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        c = new int[m + 1];
        c[0] = 0;
        for (int i = 0; i < m; i++) {
            c[i + 1] = scanner.nextInt();
        }

        q = new long[m + 1][n + 1];
        q[0][0] = 1;

        for (int i = 1; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                q[i][j] = q[i - 1][j];
                if (j - c[i] >= 0) {
                    q[i][j] += q[i][j - c[i]];
                }
            }
        }
        System.out.println(q[m][n]);
    }

    public static void main(String[] args) {
        new Main().run();
    }
}