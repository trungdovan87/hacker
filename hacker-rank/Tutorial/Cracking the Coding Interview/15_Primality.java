/**
 * Time Complexity: Primality
 * link: https://www.hackerrank.com/challenges/ctci-big-o
 * point: 10/10
 */

import java.util.*;

public class Main {
	static boolean isPrime(int n) {
		if (n == 1)
			return false;
		int loop = (int) Math.floor(Math.sqrt(n));
		for (int i = 2; i <= loop; i++)
			if (n % i == 0)
				return false;
		return  true;
	}
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int p = in.nextInt();
		for(int a0 = 0; a0 < p; a0++){
			int n = in.nextInt();
			if (isPrime(n))
				System.out.println("Prime");
			else
				System.out.println("Not prime");
		}
	}
}

