/*
    link: https://www.hackerrank.com/challenges/30-dictionaries-and-maps?h_r=next-challenge&h_v=zen
    point: 100/100
*/

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    static boolean debug = false;

    public static void main(String[] args) {
        new Main().run();
    }

    void run() {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Map<String, Integer> map = new HashMap<>(n);
        for(int i = 0; i < n; i++){
            String name = in.next();
            int phone = in.nextInt();
            // Write code here
            map.put(name, phone);
        }
        while(in.hasNext()){
            String s = in.next();
            // Write code here
            System.out.println(map.containsKey(s) ? String.format("%s=%d", s, map.get(s)) : "Not found");
        }
        in.close();
    }
}