/**
 * DFS: Connected Cell in a Grid
 * link: https://www.hackerrank.com/challenges/ctci-connected-cell-in-a-grid
 * point: 7/7
 */

import java.util.*;

public class Main {
	int[][] grid;
	boolean[][] visited;
	int n, m;

	class Position {
		int row, column;
		Position(int row, int column) {
			this.row = row;
			this.column = column;
		}
	}

	int[] drow = new int[]{-1, -1, -1, 0, 0, 1, 1, 1};
	int[] dcol = new int[]{-1, 0, 1, -1, 1, -1, 0, 1};

	private int dfs(int i, int j) {
		int s = 1;
		Deque<Position> stack = new LinkedList<>();
		stack.addLast(new Position(i, j));
		visited[i][j] = true;

		while (!stack.isEmpty()) {
			Position last =  stack.pollLast();
			for (int tmp = 0; tmp < 8; tmp++) {
				int nrow = last.row + drow[tmp];
				int ncol = last.column + dcol[tmp];
				if (!visited[nrow][ncol] && grid[nrow][ncol] == 1) {
					s++;
					visited[nrow][ncol] = true;
					stack.addLast(new Position(nrow, ncol));
				}
			}
		}
		return s;
	}

	void process() {
		int max = 0;
		for (int i = 1; i <= n; i++)
			for (int j = 1; j <= m; j++) {
				if (!visited[i][j] && grid[i][j] == 1) {
					int s = dfs(i, j);
					if (max < s)
						max = s;
				}
			}
		System.out.println(max);
	}

	void run() {
		Scanner in = new Scanner(System.in);
		n = in.nextInt();
		m = in.nextInt();
		grid = new int[n + 2][m + 2];
		visited = new boolean[n + 2][m + 2];

		for(int grid_i=1; grid_i <= n; grid_i++){
			for(int grid_j=1; grid_j <= m; grid_j++){
				grid[grid_i][grid_j] = in.nextInt();
			}
		}
		process();
	}

	public static void main(String[] args) {
		new Main().run();
	}
}

