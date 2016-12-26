/**
 * Two Robot
 * https://www.hackerrank.com/challenges/two-robots
 * point: 11/15
 */

import java.util.*;

public class Main {

	class Point2D {
		int x;
		int y;

		Point2D(int x, int y){
			this.x = x;
			this.y = y;
		}

		@Override
		public int hashCode() {
			if (x <= y)
				return x << 10 + y;
			else
				return y << 10 + x;
		}

		@Override
		public boolean equals(Object obj) {
			Point2D point = (Point2D) obj;
			return (this.x == point.x && this.y == point.y) || (this.x == point.y && this.y == point.x);
		}
	}

	int t, m, n, result;

	int distance(int a, int b) {
		if (a == 0)
			return 0;
		else
			return Math.abs(a - b);
	}

	void putNew(Map<Point2D, Integer> next, Point2D point, int value) {
		Integer oldValue = next.get(point);
		if (oldValue == null)
			next.put(point, value);
		else {
			if (oldValue > value)
				next.put(point, value);
		}
	}

	private Map<Point2D,Integer> calculateNext(Map<Point2D, Integer> current, Point2D move) {
		Map<Point2D, Integer> next = new HashMap();
		current.keySet().forEach( key -> {
			int f = current.get(key);
			// f(b, y) = f(x, y) + distance(x, a)
			putNew(next, new Point2D(move.y, key.y), f + distance(key.x, move.x) );

			// f(x, b) = f(x, y) + distance(y, a)
			putNew(next, new Point2D(key.x, move.y), f + distance(key.y, move.x));
		});
		return next;
	}

	void run() {

		Scanner scan = new Scanner(System.in);
		t = scan.nextInt();
		for (int l1 = 0; l1 < t; l1++) {
			m = scan.nextInt();
			n = scan.nextInt();
			result = 0;
			Map<Point2D, Integer> current;
			current = new HashMap<>();
			current.put(new Point2D(0,0 ), 0);

			for (int i = 0; i < n; i++) {
				int a = scan.nextInt();
				int b = scan.nextInt();
				result += Math.abs(a - b);
				current = calculateNext(current, new Point2D(a, b));
			}
			int min = Collections.min(current.values());
			System.out.println(min + result);
		}

		scan.close();
	}

	static boolean debug = false;

	public static void main(String args[]) throws Exception {
		long now = System.currentTimeMillis();
		new Main().run();
		if (debug)
			System.out.println("time (ms): " + (System.currentTimeMillis() - now));
	}
}
