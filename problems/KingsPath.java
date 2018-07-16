//NOT USABLE BECAUSE MEMORY (ORIGINAL QUESTION 10^9 X 10^9 BOARD)
import java.util.*;
public class KingsPath {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = 1000;
		boolean[][] allowed = new boolean[N][N];
		int x1 = sc.nextInt() - 1;
		int y1 = sc.nextInt() - 1;
		int x2 = sc.nextInt() - 1;
		int y2 = sc.nextInt() - 1;
		int n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			int row = sc.nextInt() - 1;
			int a = sc.nextInt() - 1;
			int b = sc.nextInt() - 1;
			for (int k = a; k <= b; k++) {
				allowed[row][k] = true;
			}

		}
		int[][] step = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				step[i][j] = Integer.MAX_VALUE;
			}
		}
		LinkedList<Integer> nextRow = new LinkedList<Integer>();
		LinkedList<Integer> nextCol = new LinkedList<Integer>();

		step[x1][y1] = 0;
		nextRow.add(x1);
		nextCol.add(y1);

		while(!nextRow.isEmpty()) {
			int r = nextRow.poll();
			int c = nextCol.poll();
			if (r - 1 >= 0 && c - 1 >= 0 && allowed[r - 1][c - 1] && step[r - 1][c - 1] > step[r][c] + 1) {
				nextRow.add(r - 1);
				nextCol.add(c - 1);
				step[r - 1][c - 1] = step[r][c] + 1;
			}
			if (r - 1 >= 0 && allowed[r - 1][c] && step[r - 1][c] > step[r][c] + 1) {
				nextRow.add(r - 1);
				nextCol.add(c);
				step[r - 1][c] = step[r][c] + 1;
			}
			if (r - 1 >= 0 && c + 1 < N && allowed[r - 1][c + 1] && step[r - 1][c + 1] > step[r][c] + 1) {
				nextRow.add(r - 1);
				nextCol.add(c + 1);
				step[r - 1][c + 1] = step[r][c] + 1;
			}
			if (c - 1 >= 0 && allowed[r][c - 1] && step[r][c - 1] > step[r][c] + 1) {
				nextRow.add(r);
				nextCol.add(c - 1);
				step[r][c - 1] = step[r][c] + 1;
			}
			if (c + 1 < N && allowed[r][c + 1] && step[r][c + 1] > step[r][c] + 1) {
				nextRow.add(r);
				nextCol.add(c + 1);
				step[r][c + 1] = step[r][c] + 1;
			}
			if (r + 1 < N && c - 1 >= 0 && allowed[r + 1][c - 1] && step[r + 1][c - 1] > step[r][c] + 1) {
				nextRow.add(r + 1);
				nextCol.add(c - 1);
				step[r + 1][c - 1] = step[r][c] + 1;
			}
			if (r + 1 < N && allowed[r + 1][c] && step[r + 1][c] > step[r][c] + 1) {
				nextRow.add(r + 1);
				nextCol.add(c);
				step[r + 1][c] = step[r][c] + 1;
			}
			if (r + 1 < N && c + 1 < N && allowed[r + 1][c + 1] && step[r + 1][c + 1] > step[r][c] + 1) {
				nextRow.add(r + 1);
				nextCol.add(c + 1);
				step[r + 1][c + 1] = step[r][c] + 1;
			}
		}

		if (step[x2][y2] == Integer.MAX_VALUE) {
			System.out.println(-1);
		} else {
			System.out.println(step[x2][y2]);
		}
	}

}
