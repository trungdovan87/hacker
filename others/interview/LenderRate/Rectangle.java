/*
Tinh dien tich bao trum cua 1 day cac hinh chu nhat (co canh song song voi truc Ox, Oy)
 */


import java.util.*;

public class Main {
    // set debug = true to log console
    static boolean debug = false;

    public static void main(String[] args) {
        new Main().run();
    }

    void run() {
        Rectangle[] rs = new Rectangle[]{
                new Rectangle(1, 2, 5, 5),
                new Rectangle(3, 1, 8, 4),
                new Rectangle(4, 3, 7, 6)
        };
        System.out.println(calculateArea(rs));
    }

    class Rectangle {
        double x1, x2; // x1 < x2;
        double y1, y2; // y1 < y2;

        Rectangle(double x1, double y1, double x2, double y2) {
            this.x1 = x1;
            this.x2 = x2;
            this.y1 = y1;
            this.y2 = y2;

        }

        double getX1() {
            return x1;
        }

        double getX2() {
            return x2;
        }

        double getY1() {
            return y1;
        }

        double getY2() {
            return y2;
        }
    }


    // complex is O(n^2), can run with n = 10^4
    double calculateArea(Rectangle[] rs) {
        // return the area covered by any of the rectangles
        int n = rs.length;
        List<Double> xList = new ArrayList();
        List<Double> yList = new ArrayList();
        for (Rectangle r : rs) {
            xList.add(r.getX1());
            xList.add(r.getX2());
            yList.add(r.getY1());
            yList.add(r.getY2());
        }
        Collections.sort(xList);
        Collections.sort(yList);

        boolean[][] a = new boolean[2 * n][2 * n];
        for (Rectangle r : rs) {
            int x1 = Collections.binarySearch(xList, r.getX1());
            int x2 = Collections.binarySearch(xList, r.getX2());

            int y1 = Collections.binarySearch(yList, r.getY1());
            int y2 = Collections.binarySearch(yList, r.getY2());

            for (int i = x1; i < x2; i++)
                for (int j = y1; j < y2; j++) {
                    a[i][j] = true;
                }
        }

        double result = 0;
        for (int i = 0; i < 2 * n; i++)
            for (int j = 0; j < 2 * n; j++) {
                if (a[i][j]) {
                    double x = xList.get(i + 1) - xList.get(i);
                    double y = yList.get(j + 1) - yList.get(j);
                    result += x * y;
                }
            }

        return result;
    }
}
