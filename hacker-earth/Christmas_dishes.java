/**
 * Christmas Dishes
 * link: https://www.hackerearth.com/december-circuits-16/approximate/christmas-dishes-2/
 * point: 100/100
 */

import java.util.Scanner;

public class Main {
	void run() {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int k = scanner.nextInt();

		if (n == k) {
			for (int i = 0; i < n; i++)
				System.out.print('a');
			System.out.println();
		} else {
			if (n != 2)
				System.out.println("No");
			else
				System.out.println("ab");
		}

	}

	public static void main(String args[]) throws Exception {
		new Main().run();
	}
}
