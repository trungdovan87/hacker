/*
    link: https://www.hackerrank.com/contests/rookierank-3/challenges/find-the-bug
    point: 100/100
*/

import java.util.Scanner;

public class Main {
    static boolean debug = false;

    public static void main(String[] args) {
        new Main().run();
    }
    int[] findTheBug(String[] grid){
        for (int i = 0; i < grid.length; i++)
            for (int j = 0; j < grid[i].length(); j++)
                if (grid[i].charAt(j) == 'X')
                    return new int[]{i, j};
        return null;
    }

    void run() {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String[] grid = new String[n];
        for(int grid_i=0; grid_i < n; grid_i++){
            grid[grid_i] = in.next();
        }
        // Return an array containing [r, c]
        int[] result = findTheBug(grid);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + (i != result.length - 1 ? "," : ""));
        }
        System.out.println("");


    }
}