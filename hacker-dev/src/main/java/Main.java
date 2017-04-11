/**
 * Project Euler #174: Counting the number of "hollow" square laminae that can form one, two, three, ... distinct arrangements
 * https://www.hackerrank.com/challenges/recursive-digit-sum
 * point: 100/100
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {

  static class Position {
    int x, y;

    Position(int x, int y) {
      this.x = x;
      this.y = y;
    }

    Position applyMatrix(Matrix33 matrix) {
      int x = this.x * matrix.a[0][0] + this.y * matrix.a[1][0] + matrix.a[2][0];
      int y = this.x * matrix.a[0][1] + this.y * matrix.a[1][1] + matrix.a[2][1];
      return new Position(x, y);
    }

    @Override
    public String toString() {
      return String.format("(%d, %d)", x, y);
    }
  }

  static class Command {
    int a, b, d;

    Command(int a, int b, int d) {
      this.a = a;
      this.b = b;
      this.d = d;
    }
  }

  static class Matrix33 {
    int[][] a = new int[3][3];

    Matrix33 multiple(Matrix33 matrix) {
      Matrix33 result = new Matrix33();
      for (int i = 0; i < 3; i++)
        for (int j = 0; j < 3; j++) {
          int tmp = 0;
          for (int p = 0; p < 3; p++) {
            tmp += this.a[i][p] * matrix.a[p][j];
          }
          result.a[i][j] = tmp;
        }
      return result;
    }

    @Override
    public String toString() {
      StringBuilder builder = new StringBuilder();
      builder.append("[");
      IntStream.range(0, 3).forEach(i -> {
        builder.append("{");
        IntStream.range(0, 3).forEach(j -> {
          builder.append(this.a[i][j] + " ");
        });
        builder.append("} ");
      });

      builder.append("]\n");
      return builder.toString();
    }

    /**
     *
     * @param (p, q) is pivot point
     * @return matrix for Composite Transformation:
     *    90 degree rotation of a point(x, y) about a pivot point(p, q)
          | 0      1    0|
          |-1      0    0|
          |p+q   -p+q   1|

     and |x y 1| * Matrix = |x' y' 1|
     */
    static Matrix33 createMatrixK(int p, int q) {
      Matrix33 matrix = new Matrix33();
      matrix.a[0][1] = 1;

      matrix.a[1][0] = -1;

      matrix.a[2][0] = p + q;
      matrix.a[2][1] = -p + q;
      matrix.a[2][2] = 1;
      return matrix;
    }
  }

  void process(int N, List<Position> L, List<Command> S) {
  }

  void run() {
    Scanner scanner = new Scanner(System.in);
    int N = scanner.nextInt();
    int s = scanner.nextInt();
    List<Command> S = new ArrayList<>();
    for (int i = 0; i < s; i++) {
      int a = scanner.nextInt() - 1;
      int b = scanner.nextInt() - 1;
      int d = scanner.nextInt();
      S.add(new Command(a, b, d));
    }

    int l = scanner.nextInt();
    List<Position> L = new ArrayList<>();

    for (int i = 0; i < l; i++) {
      long next = scanner.nextLong();
      int x = (int) (next % N);
      int y = (int) (next / N);
      L.add(new Position(x, y));
      if (debug) {
        System.out.println("x, y = " + x + " " + y);
      }
    }
    process(N, L, S);
  }

  void testMutipleMatrix() {
    Matrix33 matrix33 = Matrix33.createMatrixK(1000, 10);
    System.out.println(matrix33);
    for (int i = 0; i < 1000; i++) {
      matrix33 = matrix33.multiple(Matrix33.createMatrixK(1000, 10));
      System.out.println(matrix33);
    }
  }

  void testApplyMatrix() {
    Position position = new Position(4 , 3);
    System.out.println(position.applyMatrix(Matrix33.createMatrixK(3, 2)));
  }


  static boolean debug = true;

  public static void main(String[] args) {
//    new Main().run();
//    new Main().testMutipleMatrix();
    new Main().testApplyMatrix();
  }


}
