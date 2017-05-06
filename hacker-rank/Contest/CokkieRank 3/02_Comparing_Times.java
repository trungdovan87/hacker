/*
    link  : https://www.hackerrank.com/contests/rookierank-3/challenges/comparing-times
    point : 100/100
*/

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {
    static boolean debug = false;

    public static void main(String[] args) {
        new Main().run();
    }

    Date convertDate(String input) {
        DateFormat df = new SimpleDateFormat("hh:mmaa");
        try {
            return df.parse(input);
        } catch (ParseException pe) {
            throw new RuntimeException(pe);
        }
    }

    String timeCompare(String t1, String t2) {
        // Complete this function
        Date d1 = convertDate(t1);
        Date d2 = convertDate(t2);
        return d1.before(d2) ? "First" : "Second";
    }


    void run() {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for (int a0 = 0; a0 < q; a0++) {
            String t1 = in.next();
            String t2 = in.next();
            String result = timeCompare(t1, t2);
            System.out.println(result);
        }
    }
}
