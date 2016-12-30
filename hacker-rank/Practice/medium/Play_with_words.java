/**
 * Play with words
 * link: https://www.hackerrank.com/challenges/strplay
 * point: 15/15
 */

import java.util.Scanner;

public class Main {
	static int solution(String seq)
	{
		int n = seq.length();
		int i, j, cl;
		int L[][] = new int[n][n];
		for (i = 0; i < n; i++)
			L[i][i] = 1;

		for (cl=2; cl<=n; cl++)
		{
			for (i=0; i<n-cl+1; i++)
			{
				j = i+cl-1;
				if (seq.charAt(i) == seq.charAt(j) && cl == 2)
					L[i][j] = 2;
				else if (seq.charAt(i) == seq.charAt(j))
					L[i][j] = L[i+1][j-1] + 2;
				else
					L[i][j] = Math.max(L[i][j-1], L[i+1][j]);
			}
		}
		int max = 0;
		for (int tmp = 1; tmp < n; tmp++) {
			int lt = L[0][tmp - 1] * L[tmp][n - 1];
			if (max < lt)
				max = lt;
		}
		return  max;
	}


	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String s = scanner.next();
		System.out.println(solution(s));
	}
}
