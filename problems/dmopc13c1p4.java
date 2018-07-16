import java.util.*;
public class dmopc13c1p4 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			int l = sc.nextInt();
			int w = sc.nextInt();
			sc.nextLine();
			char[][] map = new char[w][l];
			for (int j = 0; j < w; j++) {
				String s = sc.nextLine();
				map[j] = s.toCharArray();
			}
			
			LinkedList<Integer> rQ = new LinkedList<Integer>();
			LinkedList<Integer> cQ = new LinkedList<Integer>();
			int startR = 0;
			int startC = 0;
			int endR = 0;
			int endC = 0;
			for (int j = 0; j < w; j++) {
				for (int k = 0; k < l; k++) {
					if (map[j][k] == 'C') {
						startR = j;
						startC = k;
						rQ.add(startR);
						cQ.add(startC);
					} else if (map[j][k] == 'W') {
						endR = j;
						endC = k;
					}
				}
			}
			int[][] step = new int[w][l];
			for (int j = 0; j < w; j++) {
				Arrays.fill(step[j], Integer.MAX_VALUE);
			}
			step[startR][startC] = 0;
			
			while (!rQ.isEmpty()) {
				int r = rQ.pop();
				int c = cQ.pop();
				if (r - 1 >= 0) {
					if (map[r - 1][c] != 'X' && step[r - 1][c] > step[r][c] + 1) {
						rQ.add(r - 1);
						cQ.add(c);
						step[r - 1][c] = step[r][c] + 1;
					}
				}
				if (c + 1 < l) {
					if (map[r][c + 1] != 'X' && step[r][c + 1] > step[r][c] + 1) {
						rQ.add(r);
						cQ.add(c + 1);
						step[r][c + 1] = step[r][c] + 1;
					}
				}
				if (r + 1 < w) {
					if (map[r + 1][c] != 'X' && step[r + 1][c] > step[r][c] + 1) {
						rQ.add(r + 1);
						cQ.add(c);
						step[r + 1][c] = step[r][c] + 1;
					}
				}
				if (c - 1 >= 0) {
					if (map[r][c - 1] != 'X' && step[r][c - 1] > step[r][c] + 1) {
						rQ.add(r);
						cQ.add(c - 1);
						step[r][c - 1] = step[r][c] + 1;
					}
				}
			}
			
			if (step[endR][endC] >= 60) {
				System.out.println("#notworth");
			} else {
				System.out.println(step[endR][endC]);
			}
		}
	}

}
