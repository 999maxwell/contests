import java.util.Scanner;
import java.util.LinkedList;
import java.util.Arrays;
public class ccc08s3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		for (int i = 0; i < N; i++) {
			int R = sc.nextInt();
			int C = sc.nextInt();
			char[][] map = new char[R][C];
			sc.nextLine();
			for (int j = 0; j < R; j++) {
				String s = sc.nextLine();
				map[j] = s.toCharArray();
			}
			
			LinkedList<Integer> rQ = new LinkedList<Integer>();
			LinkedList<Integer> cQ = new LinkedList<Integer>();
			rQ.add(0);
			cQ.add(0);
			int step[][] = new int[R][C];
			for (int j = 0; j < R; j++) {
				Arrays.fill(step[j], Integer.MAX_VALUE);
			}
			step[0][0] = 1;

			while(!rQ.isEmpty()) {
				int r = rQ.poll();
				int c = cQ.poll();
				if (r - 1 >= 0 && step[r - 1][c] > step[r][c] + 1 && map[r - 1][c] != '*' &&
						(map[r][c] == '+' || map[r][c] == '|')) {
					rQ.add(r - 1);
					cQ.add(c);
					step[r - 1][c] = step[r][c] + 1;
				}
				if (c + 1 < C && step[r][c + 1] > step[r][c] + 1 && map[r][c + 1] != '*' &&
						(map[r][c] == '+' || map[r][c] == '-')) {
					rQ.add(r);
					cQ.add(c + 1);
					step[r][c + 1] = step[r][c] + 1;
				}
				if (r + 1 < R && step[r + 1][c] > step[r][c] + 1 && map[r + 1][c] != '*' &&
						(map[r][c] == '+' || map[r][c] == '|')) {
					rQ.add(r + 1);
					cQ.add(c);
					step[r + 1][c] = step[r][c] + 1;
				}
				if (c - 1 >= 0 && step[r][c - 1] > step[r][c] + 1 && map[r][c - 1] != '*' &&
						(map[r][c] == '+' || map[r][c] == '-')) {
					rQ.add(r);
					cQ.add(c - 1);
					step[r][c - 1] = step[r][c] + 1;
				}
			}

			if (step[R - 1][C - 1] == Integer.MAX_VALUE) {
				System.out.println(-1);
			} else {
				System.out.println(step[R - 1][C - 1]);
			}
		}
	}

}
