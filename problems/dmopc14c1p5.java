import java.util.Scanner;
import java.util.Arrays;
import java.util.LinkedList;
public class dmopc14c1p5 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int rows = sc.nextInt();
		int cols = sc.nextInt();
		char[][] map = new char[rows][cols];
		int startR = sc.nextInt();
		int startC = sc.nextInt();
		int endR = sc.nextInt();
		int endC = sc.nextInt();
		sc.nextLine();
		for (int i = 0; i < rows; i++) {
			String s = sc.nextLine();
			map[i] = s.toCharArray();
		}
		int t = sc.nextInt();
		for (int i = 0; i < t; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			map[a][b] = 'T';
		}
		
		LinkedList<Integer> rQ = new LinkedList<Integer>();
		LinkedList<Integer> cQ = new LinkedList<Integer>();
		rQ.add(startR);
		cQ.add(startC);
		int[][] step = new int[rows][cols];
		for (int i = 0; i < rows; i++) {
			Arrays.fill(step[i], Integer.MAX_VALUE);
		}
		step[startR][startC] = 0;
		
		int minPath = Integer.MAX_VALUE;
		while (!rQ.isEmpty()) {
			int r = rQ.pop();
			int c = cQ.pop();
			if (r - 1 >= 0 && map[r - 1][c] != 'X' && step[r - 1][c] > step[r][c] + 1) {
				rQ.add(r - 1);
				cQ.add(c);
				step[r - 1][c] = step[r][c] + 1;
			}
			if (c + 1 < cols && map[r][c + 1] != 'X' && step[r][c + 1] > step[r][c] + 1) {
				rQ.add(r);
				cQ.add(c + 1);
				step[r][c + 1] = step[r][c] + 1;
			}
			if (r + 1 < rows && map[r + 1][c] != 'X' && step[r + 1][c] > step[r][c] + 1) {
				rQ.add(r + 1);
				cQ.add(c);
				step[r + 1][c] = step[r][c] + 1;
			}
			if (c - 1 >= 0 && map[r][c - 1] != 'X' && step[r][c - 1] > step[r][c] + 1) {
				rQ.add(r);
				cQ.add(c - 1);
				step[r][c - 1] = step[r][c] + 1;
			}
			if (map[r][c] == 'T') {
				if (minPath > step[r][c]) {
					minPath = step[r][c];
				}
			}
		}
		int output = 0;
		output = step[endR][endC] - minPath;
		if (minPath < 0) {
			System.out.println(0);
		} else {
			System.out.println(output);
		}
	}

}
