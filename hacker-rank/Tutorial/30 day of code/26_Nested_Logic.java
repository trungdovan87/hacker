/*
    link: https://www.hackerrank.com/challenges/30-nested-logic?h_r=next-challenge&h_v=zen
    point: 100/100
*/

import java.util.*;

public class Main {
    static boolean debug = false;

    public static void main(String[] args) {
        new Main().run();
    }

    int cal(int d1, int m1, int y1, int d2, int m2, int y2) {
        if (y1 > y2)
            return 10000;
        if (y1 < y2)
            return 0;
        if (y1 == y2) {
            if (m1 > m2)
                return 500 * (m1 - m2);
            if (m1 < m2)
                return 0;
            if (d1 > d2)
                return 15 * (d1 - d2);
            if (d1 <= d2)
                return 0;
        }
        return -1;
    }

    void run() {
        Scanner in = new Scanner(System.in);
        int d1 = in.nextInt();
        int m1 = in.nextInt();
        int y1 = in.nextInt();

        int d2 = in.nextInt();
        int m2 = in.nextInt();
        int y2 = in.nextInt();

        System.out.println(cal(d1, m1, y1, d2, m2, y2));

    }
}
