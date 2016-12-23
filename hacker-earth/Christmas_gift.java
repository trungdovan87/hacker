// Christmas gifts
// @link: https://www.hackerearth.com/december-circuits-16/approximate/christmas-gifts/

import java.util.*;

class Main {
	int n;
	int m;
	List<List<Integer>> adjacent;
	Queue<Integer> queue;
	List<Boolean> visited;

	//colors[i] = true if colors[i] == 1
	List<Boolean> colors;


	void input() {
		Scanner scanner = new Scanner(System.in);
		n = scanner.nextInt();
		m = scanner.nextInt();

		adjacent = new ArrayList<>(n);

		for (int i = 0; i < n; i++) {
			adjacent.add(new ArrayList<>());
		}

		for (int i = 0; i < m; i++) {
			int x = scanner.nextInt() - 1;
			int y = scanner.nextInt() - 1;
			adjacent.get(x).add(y);
			adjacent.get(y).add(x);
		}
	}

	void init() {
		queue = new LinkedList<>();
		visited = new ArrayList<>(n);
		colors = new ArrayList<>(n);
		for (int i = 0; i < n; i++) {
			visited.add(false);
			colors.add(false);
		}

		queue.add(0);
		colors.set(0, true);
		visited.set(0, true);
	}

	void solution() {
		while (!queue.isEmpty()) {
			int point = queue.poll();
			for (int next : adjacent.get(point)) {
				// neu colors cua point va next deu la 1, va next da duoc visit, thi doi colors cua next ve 0
				if (visited.get(next) && colors.get(next) && colors.get(point)) {
					colors.set(next, false);
				}
				// neu next chua duoc visit, add vao queue, va set color nguoc lai voi point
				if (!visited.get(next)) {
					visited.set(next, true);
					colors.set(next, !colors.get(point));
					queue.add(next);
				}
			}
		}

		for (Boolean kq : colors) {
			System.out.print( (kq ? 1 : 0) + " ");
		}
	}

	void process() {
		input();
		init();
		solution();
	}

	public static void main(String args[]) throws Exception {
		new Main().process();
	}
}
