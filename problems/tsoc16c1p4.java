import java.util.Scanner;
import java.util.Arrays;
import java.util.LinkedList;
public class tsoc16c1p4 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int R = sc.nextInt();
		int C = sc.nextInt();
		sc.nextLine();
		char[][] map = new char[R][C];
		for (int i = 0; i < R; i++) {
			String s = sc.nextLine();
			map[i] = s.toCharArray();
		}
		
		LinkedList<Integer> rQ = new LinkedList<Integer>();
		LinkedList<Integer> cQ = new LinkedList<Integer>();
		int[][] step = new int[R][C];
		for (int i = 0; i < R; i++) {
			Arrays.fill(step[i], Integer.MAX_VALUE);
		}
		int count = 0;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] == 'M' && step[i][j] == Integer.MAX_VALUE) {
					count++;
					rQ.add(i);
					cQ.add(j);
					while (!rQ.isEmpty()) {
						int r = rQ.pop();
						int c = cQ.pop();
						if (r - 1 >= 0 && step[r - 1][c] > step[r][c] + 1 && map[r - 1][c] != '#') {
							rQ.add(r - 1);
							cQ.add(c);
							step[r - 1][c] = step[r][c] + 1;
						}
						if (c + 1 < C && step[r][c + 1] > step[r][c] + 1 && map[r][c + 1] != '#') {
							rQ.add(r);
							cQ.add(c + 1);
							step[r][c + 1] = step[r][c] + 1;
						}
						if (r + 1 < R && step[r + 1][c] > step[r][c] + 1 && map[r + 1][c] != '#') {
							rQ.add(r + 1);
							cQ.add(c);
							step[r + 1][c] = step[r][c] + 1;
						}
						if (c - 1 >= 0 && step[r][c - 1] > step[r][c] + 1 && map[r][c - 1] != '#') {
							rQ.add(r);
							cQ.add(c - 1);
							step[r][c - 1] = step[r][c] + 1;
						}
					}
				}
			}
		}
		
		System.out.println(count);
	}

}
