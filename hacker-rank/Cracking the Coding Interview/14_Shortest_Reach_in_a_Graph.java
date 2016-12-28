/**
 * BFS: Shortest Reach in a Graph
 * link: https://www.hackerrank.com/challenges/ctci-bfs-shortest-reach
 * point: 7/7
 */

import java.util.*;

public class Main {
	int n, m, s;
	List<List<Integer>> adjacent;

	void process() {
		int[] result = new int[n];
		for (int i = 0; i < result.length; i++)
			result[i] = -1;
		Queue<Integer> queue = new LinkedList<>();
		queue.add(s);
		result[s] = 0;
		while (!queue.isEmpty()) {
			int current = queue.poll();
			adjacent.get(current).forEach(next -> {
				if (result[next] == -1) {
					queue.add(next);
					result[next] = result[current] + 1;
				}
			});
		}
		for (int i : result) {
			if (i == -1)
				System.out.print(i + " ");
			else if (i != 0)
				System.out.print(i * 6 + " ");
		}
		System.out.println();
	}

	void run() {
		Scanner in = new Scanner(System.in);
		int q = in.nextInt();
		for (int l1 = 0; l1 < q; l1++) {
			n = in.nextInt();
			m = in.nextInt();
			adjacent = new ArrayList<>(n);
			for (int i = 0; i < n; i++)
				adjacent.add(new LinkedList<>());
			for (int i = 0; i < m; i++) {
				int u = in.nextInt() - 1;
				int v = in.nextInt() - 1;

				adjacent.get(u).add(v);
				adjacent.get(v).add(u);
			}
			s = in.nextInt() - 1;

			process();
		}
	}

	public static void main(String[] args) {
		new Main().run();
	}
}

