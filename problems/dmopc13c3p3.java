import java.util.Scanner;
import java.util.Arrays;
import java.util.LinkedList;
public class dmopc13c3p3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int h = sc.nextInt();
		int[][] map = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		LinkedList<Integer> rQ = new LinkedList<Integer>();
		LinkedList<Integer> cQ = new LinkedList<Integer>();
		rQ.add(0);
		cQ.add(0);
		int[][] step = new int[n][n];
		for (int i = 0; i < n; i++) {
			Arrays.fill(step[i], Integer.MAX_VALUE);
		}
		step[0][0] = 0;
		
		while (!rQ.isEmpty()) {
			int r = rQ.pop();
			int c = cQ.pop();
			if (r - 1 >= 0 && step[r - 1][c] > step[r][c] + 1 && Math.abs(map[r - 1][c] - map[r][c]) <= h) {
				step[r - 1][c] = step[r][c] + 1;
				rQ.add(r - 1);
				cQ.add(c);
			}
			if (c + 1 < n && step[r][c + 1] > step[r][c] + 1 && Math.abs(map[r][c + 1] - map[r][c]) <= h) {
				step[r][c + 1] = step[r][c] + 1;
				rQ.add(r);
				cQ.add(c + 1);
			}
			if (r + 1 < n && step[r + 1][c] > step[r][c] + 1 && Math.abs(map[r + 1][c] - map[r][c]) <= h) {
				step[r + 1][c] = step[r][c] + 1;
				rQ.add(r + 1);
				cQ.add(c);
			}
			if (c - 1 >= 0 && step[r][c - 1] > step[r][c] + 1 && Math.abs(map[r][c - 1] - map[r][c]) <= h) {
				step[r][c - 1] = step[r][c] + 1;
				rQ.add(r);
				cQ.add(c - 1);
			}
		}
		
		if (step[n - 1][n - 1] == Integer.MAX_VALUE) {
			System.out.println("no");
		} else {
			System.out.println("yes");
		}
	}

}
