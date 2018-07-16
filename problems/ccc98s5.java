import java.util.Scanner;
import java.util.LinkedList;
public class ccc98s5 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int i = 0; i < T; i++) {
			int N = sc.nextInt();
			int[][] map = new int[N][N];
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < N; k++) {
					map[j][k] = sc.nextInt();
				}
			}

			LinkedList<Integer> rQ = new LinkedList<Integer>();
			LinkedList<Integer> cQ = new LinkedList<Integer>();
			rQ.add(0);
			cQ.add(0);
			int[][] step = new int[N][N];
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < N; k++) {
					step[j][k] = Integer.MAX_VALUE;
				}
			}
			step[0][0] = 0;

			while (!rQ.isEmpty()) {
				int r = rQ.poll();
				int c = cQ.poll();
				if (r - 1 >= 0 && step[r - 1][c] > step[r][c] + 1 && Math.abs(map[r - 1][c] - map[r][c]) <= 2) {
					rQ.add(r - 1);
					cQ.add(c);
					if (map[r - 1][c] > map[0][0] || map[r][c] > map[0][0]) {
						step[r - 1][c] = step[r][c] + 1;
					} else {
						step[r - 1][c] = step[r][c];
					}
				}
				if (c + 1 < N && step[r][c + 1] > step[r][c] + 1 && Math.abs(map[r][c + 1] - map[r][c]) <= 2) {
					rQ.add(r);
					cQ.add(c + 1);
					step[r][c + 1] = step[r][c] + 1;
					if (map[r][c + 1] > map[0][0] || map[r][c] > map[0][0]) {
						step[r][c + 1] = step[r][c] + 1;
					} else {
						step[r][c + 1] = step[r][c];
					}
				}
				if (r + 1 < N && step[r + 1][c] > step[r][c] + 1 && Math.abs(map[r + 1][c] - map[r][c]) <= 2) {
					rQ.add(r + 1);
					cQ.add(c);
					step[r + 1][c] = step[r][c] + 1;
					if (map[r + 1][c] > map[0][0] || map[r][c] > map[0][0]) {
						step[r + 1][c] = step[r][c] + 1;
					} else {
						step[r + 1][c] = step[r][c];
					}
				}
				if (c - 1 >= 0 && step[r][c - 1] > step[r][c] + 1 && Math.abs(map[r][c - 1] - map[r][c]) <= 2) {
					rQ.add(r);
					cQ.add(c - 1);
					step[r][c - 1] = step[r][c] + 1;
					if (map[r][c - 1] > map[0][0] || map[r][c] > map[0][0]) {
						step[r][c - 1] = step[r][c] + 1;
					} else {
						step[r][c - 1] = step[r][c];
					}
				}
			}

			if (step[N - 1][N - 1] != Integer.MAX_VALUE) {
				System.out.println(step[N - 1][N - 1]);
			} else {
				System.out.println("CANNOT MAKE THE TRIP");
			}

		}
	}

}
