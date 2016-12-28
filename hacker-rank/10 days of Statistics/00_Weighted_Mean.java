/**
 * Day 0: Weighted Mean
 * link:https://www.hackerrank.com/challenges/s10-weighted-mean
 * point: 4/4
 */

import java.util.*;

public class Main {
	class Element {
		int x, w;
		Element(int x, int w) {
			this.x = x;
			this.w = w;
		}
	}

	float weightedMean(List<Element> list) {
		int a = list.stream().mapToInt(e -> e.x * e.w).sum();
		int b = list.stream().mapToInt(e -> e.w).sum();
		return a / (float)b;
	}

	void run() {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int[] arrayX = new int[n];
		int[] arrayW = new int[n];
		for (int i = 0; i < n; i++)
			arrayX[i] = scanner.nextInt();
		for (int i = 0; i < n; i++)
			arrayW[i] = scanner.nextInt();
		List<Element> list = new ArrayList<>(n);
		for (int i = 0; i < n; i++)
			list.add(new Element(arrayX[i], arrayW[i]));
		System.out.println(String.format("%.1f", weightedMean(list)));
	}

	public static void main(String[] args) {
		new Main().run();
	}
}