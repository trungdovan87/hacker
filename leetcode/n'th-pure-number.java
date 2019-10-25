/*
    title: Find only one N'th pure numbers
    link: https://leetcode.com/problems/palindrome-number/description/
    point: 100/100
*/

public class Main {
    String calculate(long n) {
        long begin = 0;
        long exp = 2;
        long k = 1;
        while (begin + exp <= n) {
            k++;
            begin += exp;
            exp *= 2;
        }
        String result;
        long no;
        if (n < begin + exp / 2) {
           result = "0";
           no = n - begin;
        } else {
            result = "1";
            no = n - (begin + exp / 2);
        }
        String binary = Long.toBinaryString(no);
        String fill = fillZero(binary, k - 1);
        result += fill;

        result = result.replace("0", "4").replace("1", "5");
        result += new StringBuilder(result).reverse().toString();
        return result;
    }

    String fillZero(String binary, long length) {
        while (binary.length() < length) {
            binary = "0" + binary;
        }
        return binary;
    }

    void run() {
        long n = 1_000_000_000_000_000_000L;
        System.out.println(calculate(n - 1));
    }

    public static void main(String[] args) {
        new Main().run();
    }
}