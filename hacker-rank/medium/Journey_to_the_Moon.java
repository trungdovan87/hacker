/**
 * Journey to the Moon
 * link: https://www.hackerrank.com/challenges/journey-to-the-moon
 * point: 100/100
 */

import java.util.*;

public class Main {
	int n;
	List<List<Integer>> adjacent;
	boolean[] visited;


	long dfs(int position) {
		long sum = 1;
		Deque<Integer> stack = new LinkedList<>();
		stack.addLast(position);
		visited[position] = true;
		while (!stack.isEmpty()) {
			int current = stack.pollLast();
			for (int i : adjacent.get(current)) {
				if (!visited[i]) {
					sum++;
					visited[i] = true;
					stack.addLast(i);
				}
			}
		}
		return sum;
	}

	void process() {
		visited = new boolean[n];
		long result = 0;
		long sumBefore = 0;
		for (int i = 0; i < n; i++)
			if (!visited[i]) {
				long tmp = dfs(i);
				result += sumBefore * tmp;
				sumBefore += tmp;
			}
		System.out.println(result);
	}

	void run() {
		Scanner scanner = new Scanner(System.in);
		n = scanner.nextInt();
		adjacent = new ArrayList<>(n);
		for (int i = 0; i < n; i++)
			adjacent.add(new LinkedList<>());
		int I = scanner.nextInt();
		for (int i = 0; i < I; i++) {
			int a = scanner.nextInt();
			int b = scanner.nextInt();
			adjacent.get(a).add(b);
			adjacent.get(b).add(a);
		}

		process();
	}
	public static void main(String[] args) {
		new Main().run();
	}
}
