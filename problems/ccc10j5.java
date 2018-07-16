import java.util.*;
public class ccc10j5 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean[][] map = new boolean[8][8];
		int horiStart = sc.nextInt() - 1;
		int vertStart = sc.nextInt() - 1;
		int horiEnd = sc.nextInt() - 1;
		int vertEnd = sc.nextInt() - 1;
		
		LinkedList<Integer> horiQ = new LinkedList<Integer>();
		LinkedList<Integer> vertQ = new LinkedList<Integer>();
		horiQ.add(horiStart);
		vertQ.add(vertStart);
		int[][] step = new int[8][8];
		for (int i = 0; i < 8; i++) {
			Arrays.fill(step[i], Integer.MAX_VALUE);
		}
		step[horiStart][vertStart] = 0;
		
		while (!horiQ.isEmpty()) {
			int x = horiQ.pop();
			int y = vertQ.pop();
			if (x - 2 >= 0) {
				if (y + 1 < 8) {
					if (step[x - 2][y + 1] > step[x][y] + 1) {
						horiQ.add(x - 2);
						vertQ.add(y + 1);
						step[x - 2][y + 1] = step[x][y] + 1;
					}
				}
				if (y - 1 >= 0) {
					if (step[x - 2][y - 1] > step[x][y] + 1) {
						horiQ.add(x - 2);
						vertQ.add(y - 1);
						step[x - 2][y - 1] = step[x][y] + 1;
					}
				}
			}
			if (x - 1 >= 0) {
				if (y + 2 < 8) {
					if (step[x - 1][y + 2] > step[x][y] + 1) {
						horiQ.add(x - 1);
						vertQ.add(y + 2);
						step[x - 1][y + 2] = step[x][y] + 1;
					}
				}
				if (y - 2 >= 0) {
					if (step[x - 1][y - 2] > step[x][y] + 1) {
						horiQ.add(x - 1);
						vertQ.add(y - 2);
						step[x - 1][y - 2] = step[x][y] + 1;
					}
				}
			}
			if (x + 1 < 8) {
				if (y + 2 < 8) {
					if (step[x + 1][y + 2] > step[x][y] + 1) {
						horiQ.add(x + 1);
						vertQ.add(y + 2);
						step[x + 1][y + 2] = step[x][y] + 1;
					}
				}
				if (y - 2 >= 0) {
					if (step[x + 1][y - 2] > step[x][y] + 1) {
						horiQ.add(x + 1);
						vertQ.add(y - 2);
						step[x + 1][y - 2] = step[x][y] + 1;
					}
				}
			}
			if (x + 2 < 8) {
				if (y + 1 < 8) {
					if (step[x + 2][y + 1] > step[x][y] + 1) {
						horiQ.add(x + 2);
						vertQ.add(y + 1);
						step[x + 2][y + 1] = step[x][y] + 1;
					}
				}
				if (y - 1 >= 0) {
					if (step[x + 2][y - 1] > step[x][y] + 1) {
						horiQ.add(x + 2);
						vertQ.add(y - 1);
						step[x + 2][y - 1] = step[x][y] + 1;
					}
				}
			}
		}
		
		System.out.println(step[horiEnd][vertEnd]);
	}

}
