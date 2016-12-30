/**
 * DP: Coin Change
 * link: https://www.hackerrank.com/challenges/ctci-coin-change
 * point: 17/17
 */

import java.util.*;

public class Main {
	int n, m;
	int[] coins;

	/**
	 * thuat toan:
	 * c[i, j] = c[i-1, j] + c[i, j - coins[i]]
	 */
	void dynamic() {
		long[] c = new long[n + 1];
		c[0] = 1;
		for (int i = 0; i < m; i++)
			for (int j = 1; j <=n; j++) {
				if (j >= coins[i])
					c[j] += c[j - coins[i]];
			}
		System.out.println(c[n]);
	}

	void run() {
		Scanner in = new Scanner(System.in);
		n = in.nextInt();
		m = in.nextInt();
		coins = new int[m];
		for(int coins_i=0; coins_i < m; coins_i++){
			coins[coins_i] = in.nextInt();
		}
		dynamic();
	}
	public static void main(String[] args) {
		new Main().run();
	}
}

