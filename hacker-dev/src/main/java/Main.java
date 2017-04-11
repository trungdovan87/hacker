/**
 * We use Coordinate System like this:
 *    0
 *    .--------->x
 *    |
 *    |
 *    |
 *    | y
 *
 * And we use 2 algorithm: Matrix Multiplication + Binary Search
 * - Complex of this Solution is: n * log(n) = L * log(S)
 * - In Worst Case, it take 500ms
 *
 * 
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
// set debug = true to log console
  static boolean debug = false;

  public static void main(String[] args) {
    new Main().run();
//    uncomment to test in Worst Case.
//    new Main().testWorstCase();
  }

  void run() {
    // INPUT
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

    //resolve
    new Problem().process(L, S);
  }

  /**
   * TEST for Worst Case.
   */
  void testWorstCase() {
    System.out.println("********** TEST for WORST CASE");
    System.out.println("-- generating INPUT....");

    int ten7 = 10000000; // 10^7
    int ten5 = 100000; // 10^5
//    ten5 = 100;
    List<Command> S = new ArrayList<>();

    List<Position> L = new ArrayList<>();
    for (int i = 0; i < ten5; i++) {
      S.add(new Command(0, 0, 2 * ten7));
      L.add(new Position(10 * 2, 20 * 2));
    }

    System.out.println("-- running...");
    long now = System.currentTimeMillis();
    new Problem().process(L, S);

    System.out.println("-- Done!!!!");
    System.out.println(String.format("-- Time: %d (ms)", (System.currentTimeMillis() - now)));
  }

  static class Position {
    int x, y;

    Position(int x, int y) {
      this.x = x;
      this.y = y;
    }

    /**
     * @param matrix Matrix Transformer.
     * @return new Position after transformation <br/>
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

    /**
     * create a Transformer Matrix from pivot(p, q)
     * @param (p,q) is pivot point
     * @return matrix for Transformation <br/>
     * 90 degree rotation of a point(x, y) about a pivot point(p, q) <br/>
     * | 0      1    0| <br/>
     * |-1      0    0| <br/>
     * |p+q   -p+q   1 |<br/>
     * <br/>
     * and |x y 1| * Matrix = |x' y' 1|
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

    /**
     * @param pivot of rotation
     * @return
     */
    static Matrix33 createMatrixWithPivot(Position pivot) {
      return createMatrixPQ(pivot.x, pivot.y);
    }

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
  }

  static class Problem {
    List<Matrix33> matrixList;
    List<Position> L;
    List<Command> S;

    // check whether position is in Square from cmd.
    private static boolean isInSquare(Position position, Command cmd) {
      return (position.x >= cmd.a &&  position.x <= cmd.a + cmd.d && position.y >= cmd.b && position.y <= cmd.b + cmd.d);
    }

    /**
     * a, b, d is always even.
     */
    private Position calculateCenter(Command command) {
      return new Position(command.a + command.d / 2, command.b + command.d / 2);
    }

    private void init(List<Position> L, List<Command> S) {
      this.matrixList = new ArrayList<>(S.size());
      if (!S.isEmpty()) {
        Command command = S.get(0);
        Position center = calculateCenter(command);
        matrixList.add(Matrix33.createMatrixWithPivot(center));
      }

      for (int i = 1; i < S.size(); i++) {
        Command command = S.get(i);
        Position center = calculateCenter(command);
        matrixList.add(matrixList.get(i - 1).multiple(Matrix33.createMatrixWithPivot(center)));
      }
    }

    void process(List<Position> L, List<Command> S) {
      this.L = L;
      this.S = S;
      init(L, S);
      L.forEach(position -> solve(position));
    }

    /**
     * Find the largest index of command, so that position is still in Square
     * @param position
     * @return
     */
    private int binarySearch(Position position) {
      int result = -1;
      int left = 0;
      int right = S.size() - 1;
      while (left <= right) {
        int mid = (left + right) / 2;
        Position next = position.applyMatrix(matrixList.get(mid));
        if (isInSquare(next, S.get(mid))) {
          result = mid;
          left = mid + 1;
        } else {
          right = mid - 1;
        }
      }
      return result;
    }

    /**
     * Calculate and Print result to console.
     * @param position
     */
    private void solve(Position position) {
      int index = binarySearch(position);
      if (debug) {
        System.out.println("index: " + index);
      }
      Position result = index < 0 ? position : position.applyMatrix(matrixList.get(index));
      System.out.println(String.format("%d %d", result.y / 2 + 1, result.x / 2 + 1));
    }
  }
}
