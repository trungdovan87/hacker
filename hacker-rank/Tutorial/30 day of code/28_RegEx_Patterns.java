/*
    link: https://www.hackerrank.com/challenges/30-regex-patterns
    point: 100/100
*/

import java.util.*;

public class Main {
    static boolean debug = false;

    public static void main(String[] args) {
        new Main().run();
    }

    void run() {
        Scanner in = new Scanner(System.in);
        List<String> list = new ArrayList<>();
        int n = in.nextInt();
        for (int i = 0; i < n; i++) {
            String name = in.next();
            String email = in.next();
            if (email.endsWith("@gmail.com"))
                list.add(name);
        }
        Collections.sort(list);
        list.forEach(System.out::println);
    }
}
