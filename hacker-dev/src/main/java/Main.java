/**
 * We
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

    /**
     * @param matrix Matrix Transformer.
     * @return next Position after transformation
     * idea: |x y 1| x Matrix = |x' y' 1|
     */
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
     *     | 0      1    0|
     *     |-1      0    0|
     *     |p+q   -p+q   1|
     *
     *    and |x y 1| * Matrix = |x' y' 1|
     */
    static Matrix33 createMatrixPQ(int p, int q) {
      Matrix33 matrix = new Matrix33();
      matrix.a[0][1] = 1;

      matrix.a[1][0] = -1;

      matrix.a[2][0] = p + q;
      matrix.a[2][1] = -p + q;
      matrix.a[2][2] = 1;
      return matrix;
    }

    static Matrix33 createMatrixPivot(Position center) {
      return createMatrixPQ(center.x, center.y);
    }
  }

  /**
   * a, b, d is always even.
   */
  Position calculateCenter(Command command){
    return new Position(command.a + command.d / 2, command.b + command.d / 2);
  }

  void process(int N, List<Position> L, List<Command> S) {
    List<Matrix33> matrixList = new ArrayList<>(S.size());
    if (!S.isEmpty()) {
      Command command = S.get(0);
      Position center = calculateCenter(command);
      matrixList.add(Matrix33.createMatrixPivot(center));
    }

    for (int i = 1; i < S.size(); i++) {
      Command command = S.get(0);
      Position center = calculateCenter(command);
      matrixList.add(matrixList.get(i - 1).multiple(Matrix33.createMatrixPivot(center)));
    }
  }

  void run() {
    Scanner scanner = new Scanner(System.in);
    int N = scanner.nextInt();
    int s = scanner.nextInt();
    List<Command> S = new ArrayList<>();
    for (int i = 0; i < s; i++) {
      int b = scanner.nextInt() - 1;
      int a = scanner.nextInt() - 1;
      int d = scanner.nextInt();
      a *= 2;
      b *= 2;
      d *= 2;
      if (debug) {
        System.out.println(String.format("a, b, d = %d, %d, %d", a, b, d));
      }
      S.add(new Command(a, b, d));
    }

    int l = scanner.nextInt();
    List<Position> L = new ArrayList<>();

    for (int i = 0; i < l; i++) {
      long next = scanner.nextLong();
      int x = (int) (next % N);
      int y = (int) (next / N);

      if (y >= N) {
        throw new IllegalArgumentException(String.format("l >= N^2 with (l = %d, N = %d)", next, N));
      }
      x *= 2;
      y *= 2;

      L.add(new Position(x, y));
      if (debug) {
        System.out.println(String.format("x, y = %d, %d", x, y));
      }
    }
    process(N, L, S);
  }

  void testMutipleMatrix() {
    Matrix33 matrix33 = Matrix33.createMatrixPQ(1000, 10);
    System.out.println(matrix33);
    for (int i = 0; i < 1000; i++) {
      matrix33 = matrix33.multiple(Matrix33.createMatrixPQ(1000, 10));
      System.out.println(matrix33);
    }
  }

  void testApplyMatrix() {
    Position position = new Position(5 * 2 , 1 * 2);
    System.out.println(position);
    Matrix33 m1 = Matrix33.createMatrixPQ(3 * 2, 2 * 2);
    Position position1 = position.applyMatrix(m1);
    System.out.println(position1);

    Matrix33 m2 = Matrix33.createMatrixPQ(7, 5);
    Position position2 = position1.applyMatrix(m2);
    System.out.println(position2);

    System.out.println("----- Final: " + position.applyMatrix(m1.multiple(m2)));
  }


  static boolean debug = true;

  public static void main(String[] args) {
    new Main().run();
//    new Main().testMutipleMatrix();
//    new Main().testApplyMatrix();
  }


}
