import java.util.Scanner;
import java.util.Arrays;
import java.util.LinkedList;
public class valday15p3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int w = sc.nextInt();
		int l = sc.nextInt();
		int h = sc.nextInt();
		boolean[][][] map = new boolean[w][l][h];
		int n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			int a = sc.nextInt() - 1;
			int b = sc.nextInt() - 1;
			int c = sc.nextInt() - 1;
			map[a][b][c] = true;
		}

		LinkedList<Integer> wQ = new LinkedList<Integer>();
		LinkedList<Integer> lQ = new LinkedList<Integer>();
		LinkedList<Integer> hQ = new LinkedList<Integer>();
		wQ.add(0);
		lQ.add(0);
		hQ.add(0);
		int[][][] step = new int[w][l][h];
		for (int i = 0; i < w; i++) {
			for (int j = 0; j < l; j++) {
				Arrays.fill(step[i][j], Integer.MAX_VALUE);
			}
		}
		step[0][0][0] = 0;

		while (!wQ.isEmpty()) {
			int x = wQ.poll();
			int y = lQ.poll();
			int z = hQ.poll();
			if (y + 1 < l) {
				if (!map[x][y + 1][z] && step[x][y + 1][z] > step[x][y][z] + 1) {
					wQ.add(x);
					lQ.add(y + 1);
					hQ.add(z);
					step[x][y + 1][z] = step[x][y][z] + 1;
				}
			}
			if (x + 1 < w) {
				if (!map[x + 1][y][z] && step[x + 1][y][z] > step[x][y][z] + 1) {
					wQ.add(x + 1);
					lQ.add(y);
					hQ.add(z);
					step[x + 1][y][z] = step[x][y][z] + 1;
				}
			}
			if (y - 1 >= 0) {
				if (!map[x][y - 1][z] && step[x][y - 1][z] > step[x][y][z] + 1) {
					wQ.add(x);
					lQ.add(y - 1);
					hQ.add(z);
					step[x][y - 1][z] = step[x][y][z] + 1;
				}
			}
			if (x - 1 >= 0) {
				if (!map[x - 1][y][z] && step[x - 1][y][z] > step[x][y][z] + 1) {
					wQ.add(x - 1);
					lQ.add(y);
					hQ.add(z);
					step[x - 1][y][z] = step[x][y][z] + 1;
				}
			}
			if (z + 1 < h) {
				if (!map[x][y][z + 1] && step[x][y][z + 1] > step[x][y][z] + 1) {
					wQ.add(x);
					lQ.add(y);
					hQ.add(z + 1);
					step[x][y][z + 1] = step[x][y][z] + 1;
				}
			}
			if (z - 1 >= 0) {
				if (!map[x][y][z - 1] && step[x][y][z - 1] > step[x][y][z] + 1) {
					wQ.add(x);
					lQ.add(y);
					hQ.add(z - 1);
					step[x][y][z - 1] = step[x][y][z] + 1;
				}
			}
		}
		int min = Integer.MAX_VALUE;
		for (int i = w - 3; i < w; i++) {
			for (int j = h - 3; j < h; j++) {
				if (min > step[i][l - 1][j]) {
					min = step[i][l - 1][j];
					
				}
			}
		}

		System.out.println(min);
	}
}
