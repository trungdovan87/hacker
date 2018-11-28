/*
    title: tong so duong di qua it nhat 2 loai nam
    link:
    point: 100/100
*/

import java.util.Scanner;

public class Main {
    int ten5 = 100000;

    @FunctionalInterface
    interface Condition {
        boolean ifTrue(int x);
    }

    int m, n;
    int[][] a;

    void input() {
        Scanner scanner = new Scanner(System.in);
        m = scanner.nextInt();
        n = scanner.nextInt();
        a = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                a[i][j] = scanner.nextInt();
            }
        }
    }

    int calculate(Condition condition) {
        int[][] q = new int[m + 1][n + 1];
        q[0][1] = 1;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (condition.ifTrue(a[i][j])) {
                    q[i][j] = (q[i - 1][j] + q[i][j - 1]) % ten5;
                }
            }
        }
        return q[m][n];
    }

    void process() {
        int all = calculate(x -> x != 0);
        int only1 = calculate(x -> x == 1 || x == 9);
        int only2 = calculate(x -> x == 2 || x == 9);
        int only3 = calculate(x -> x == 3 || x == 9);
        int result = (3 * ten5 + all - only1 - only2 - only3) % ten5;
        System.out.println(result);
    }

    void run() {
        input();
        process();
    }

    public static void main(String[] args) {
        new Main().run();
    }
}
/*
input:
3 4
9 1 1 2
3 1 1 2
1 0 1 9

output:
5
 */