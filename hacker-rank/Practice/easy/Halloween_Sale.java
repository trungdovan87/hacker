/*
    link: https://www.hackerrank.com/contests/hourrank-23/challenges/halloween-sale/submissions
    point: 100/100
*/

import java.util.*;

public class Main {
    static boolean debug = false;

    static int howManyGames(int p, int d, int m, int s) {
        // Return the number of games you can buy
        int count = 0;
        int sum = 0;
        int now = p;
        while (true) {
            if (sum + now <= s) {
                count++;
                sum = sum + now;
                now = now - d < m ? m : now -d;
            } else {
                break;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int p = in.nextInt();
        int d = in.nextInt();
        int m = in.nextInt();
        int s = in.nextInt();
        int answer = howManyGames(p, d, m, s);
        System.out.println(answer);
        in.close();
    }
}