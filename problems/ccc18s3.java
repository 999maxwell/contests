import java.util.*;
public class ccc18s3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int rows = sc.nextInt();
		int cols = sc.nextInt();
		sc.nextLine();
		char[][] map = new char[rows][cols];
		for (int i = 0; i < rows; i++) {
			map[i] = sc.nextLine().toCharArray();
		}
		boolean[][] camera = new boolean[rows][cols];
		LinkedList<Integer> rCamStart = new LinkedList<Integer>();
		LinkedList<Integer> cCamStart = new LinkedList<Integer>();
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (map[i][j] == 'C') {
					camera[i][j] = true;
					rCamStart.add(i);
					cCamStart.add(j);
				}
			}
		}
		boolean spawnKilled = false;
		for (int i = 0; i < rCamStart.size(); i++) {
			boolean wallReach = false;
			int tempI = rCamStart.get(i);
			int tempJ = cCamStart.get(i);
			while (!wallReach) {
				if (map[tempI][tempJ] == '.') {
					camera[tempI][tempJ] = true;
				} else if (map[tempI][tempJ] == 'W') {
					wallReach = true;
				} else if (map[tempI][tempJ] == 'S') {
					spawnKilled = true;
				}
				tempI--;
			}
			wallReach = false;
			tempI = rCamStart.get(i);
			tempJ = cCamStart.get(i);
			while (!wallReach) {
				if (map[tempI][tempJ] == '.') {
					camera[tempI][tempJ] = true;
				} else if (map[tempI][tempJ] == 'W') {
					wallReach = true;
				} else if (map[tempI][tempJ] == 'S') {
					spawnKilled = true;
				}
				tempJ++;
			}
			wallReach = false;
			tempI = rCamStart.get(i);
			tempJ = cCamStart.get(i);
			while (!wallReach) {
				if (map[tempI][tempJ] == '.') {
					camera[tempI][tempJ] = true;
				} else if (map[tempI][tempJ] == 'W') {
					wallReach = true;
				} else if (map[tempI][tempJ] == 'S') {
					spawnKilled = true;
				}
				tempI++;
			}
			wallReach = false;
			tempI = rCamStart.get(i);
			tempJ = cCamStart.get(i);
			while (!wallReach) {
				if (map[tempI][tempJ] == '.') {
					camera[tempI][tempJ] = true;
				} else if (map[tempI][tempJ] == 'W') {
					wallReach = true;
				} else if (map[tempI][tempJ] == 'S') {
					spawnKilled = true;
				}
				tempJ--;
			}
		}
		LinkedList<Integer> rQ = new LinkedList<Integer>();
		LinkedList<Integer> cQ = new LinkedList<Integer>();
		int[][] step = new int[rows][cols];
		for (int i = 0; i < rows; i++) {
			Arrays.fill(step[i], Integer.MAX_VALUE);
		}
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (map[i][j] == 'S') {
					rQ.add(i);
					cQ.add(j);
					step[i][j] = 0;
				}
			}
		}
		if (!spawnKilled) {
			while (!rQ.isEmpty()) {
				int r = rQ.poll();
				int c = cQ.poll();
				if (!(map[r][c] == 'U' || map[r][c] == 'R' || map[r][c] == 'D' || map[r][c] == 'L')) {
					if (r - 1 >= 0 && map[r - 1][c] != 'W' && !camera[r - 1][c] && step[r - 1][c] > step[r][c] + 1) {
						rQ.add(r - 1);
						cQ.add(c);
						step[r - 1][c] = step[r][c] + 1;
					}
					if (c + 1 < cols && map[r][c + 1] != 'W' && !camera[r][c + 1] && step[r][c + 1] > step[r][c] + 1) {
						rQ.add(r);
						cQ.add(c + 1);

						step[r][c + 1] = step[r][c] + 1;

					}
					if (r + 1 < rows && map[r + 1][c] != 'W' && !camera[r + 1][c] && step[r + 1][c] > step[r][c] + 1) {
						rQ.add(r + 1);
						cQ.add(c);

						step[r + 1][c] = step[r][c] + 1;

					}
					if (c - 1 >= 0 && map[r][c - 1] != 'W' && !camera[r][c - 1] && step[r][c - 1] > step[r][c] + 1) {
						rQ.add(r);
						cQ.add(c - 1);

						step[r][c - 1] = step[r][c] + 1;

					}
				} else {
					if (map[r][c] == 'U' && r - 1 >= 0 && map[r - 1][c] != 'W' && !camera[r - 1][c] && step[r - 1][c] > step[r][c]) {
						rQ.add(r - 1);
						cQ.add(c);
						step[r - 1][c] = step[r][c];

					} else if (map[r][c] == 'R' && c + 1 < cols && map[r][c + 1] != 'W' && !camera[r][c + 1] && step[r][c + 1] > step[r][c]) {
						rQ.add(r);
						cQ.add(c + 1);

						step[r][c + 1] = step[r][c];

					} else if (map[r][c] == 'D' && r + 1 < rows && map[r + 1][c] != 'W' && !camera[r + 1][c] && step[r + 1][c] > step[r][c]) {
						rQ.add(r + 1);
						cQ.add(c);

						step[r + 1][c] = step[r][c];

					} else if (map[r][c] == 'L' && c - 1 >= 0 && map[r][c - 1] != 'W' && !camera[r][c - 1] && step[r][c - 1] > step[r][c]) {
						rQ.add(r);
						cQ.add(c - 1);
						step[r][c - 1] = step[r][c];
					}
				}
			}
		}
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (map[i][j] == '.') {
					if (step[i][j] == Integer.MAX_VALUE) {
						System.out.println(-1);
					} else {
						System.out.println(step[i][j]);
					}
				}
			}
		}
	}
}
