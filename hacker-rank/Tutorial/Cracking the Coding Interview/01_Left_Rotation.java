/**
 * Left Rotation
 * https://www.hackerrank.com/challenges/ctci-array-left-rotation
 * point: 10/10
 */

import java.util.*;

public class Main {

	void run() {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int k = in.nextInt();
		int a[] = new int[n];
		for(int a_i=0; a_i < n; a_i++){
			a[a_i] = in.nextInt();
		}
		for (int i = 0; i < n; i++)
			System.out.print(a[ (i + k) % n] + " ");
	}
	static boolean debug = false;

	public static void main(String args[]) throws Exception {
		new Main().run();
	}
}
