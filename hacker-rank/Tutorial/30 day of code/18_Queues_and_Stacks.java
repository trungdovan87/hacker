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

    public class Solution {
        // Write your code here.
        final int MAX = 10000;
        char[] stack = new char[MAX];
        char[] queue = new char[MAX];
        int sl = -1;
        int qf = 0;
        int ql = -1;


        void pushCharacter(char ch) {
            sl++;
            stack[sl] = ch;
        }

        void enqueueCharacter(char ch) {
            ql++;
            queue[ql] = ch;
        }

        char popCharacter() {
            return stack[sl--];

        }
        char dequeueCharacter() {
            return queue[qf++];
        }

    }

    void run() {

    }

}