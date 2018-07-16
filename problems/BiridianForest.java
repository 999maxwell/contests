//NOT CURRENTLY USABLE; NEEDS MEMORY FIXING
import java.util.*;
public class BiridianForest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int rows = sc.nextInt();
		int cols = sc.nextInt();
		int twb = 0; //tilesWithBreeders
		LinkedList<Integer> battles = new LinkedList<Integer>();
		sc.nextLine();
		char[][] map = new char[rows][cols];
		for (int i = 0; i < rows; i++) {
			String s = sc.nextLine();
			map[i] = s.toCharArray();
			for (int j = 0; j < cols; j++) {
				if (Character.isDigit(map[i][j]) && map[i][j] != '0') {
					battles.add(Character.getNumericValue(map[i][j]));
					twb++;
				}
			}
		}
		int[][][] step = new int[twb + 1][rows][cols];
		for (int i = 0; i < twb + 1; i++) {
			for (int j = 0; j < rows; j++) {
				Arrays.fill(step[i][j], Integer.MAX_VALUE);
			}
		}
		LinkedList<LinkedList<Integer>> rQ = new LinkedList<LinkedList<Integer>>();
		LinkedList<LinkedList<Integer>> cQ = new LinkedList<LinkedList<Integer>>();

		int rE = 0;
		int cE = 0;

		rQ.add(new LinkedList<Integer>());
		cQ.add(new LinkedList<Integer>());
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (map[i][j] == 'S') {
					rQ.get(0).add(i);
					cQ.get(0).add(j);
					step[0][i][j] = 0;
				} else if (map[i][j] == 'E') {
					rE = i;
					cE = j;
				}
			}
		}

		int tempB = 1;
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (Character.isDigit(map[i][j]) && map[i][j] != '0') {
					rQ.add(new LinkedList<Integer>());
					cQ.add(new LinkedList<Integer>());
					rQ.get(rQ.size() - 1).add(i);
					cQ.get(cQ.size() - 1).add(j);
					step[tempB][i][j] = 0;
					tempB++;
				}
			}
		}

		for (int i = 0; i < twb + 1; i++) {
			while (!rQ.get(i).isEmpty()) {

				int r = rQ.get(i).poll();
				int c = cQ.get(i).poll();

				if (r - 1 >= 0 && map[r - 1][c] != 'T' && step[i][r - 1][c] > step[i][r][c] + 1) {
					rQ.get(i).add(r - 1);
					cQ.get(i).add(c);
					step[i][r - 1][c] = step[i][r][c] + 1;
				}
				if (c + 1 < cols && map[r][c + 1] != 'T' && step[i][r][c + 1] > step[i][r][c] + 1) {
					rQ.get(i).add(r);
					cQ.get(i).add(c + 1);
					step[i][r][c + 1] = step[i][r][c] + 1;
				}
				if (r + 1 < rows && map[r + 1][c] != 'T' && step[i][r + 1][c] > step[i][r][c] + 1) {
					rQ.get(i).add(r + 1);
					cQ.get(i).add(c);
					step[i][r + 1][c] = step[i][r][c] + 1;
				}
				if (c - 1 >= 0 && map[r][c - 1] != 'T' && step[i][r][c - 1] > step[i][r][c] + 1) {
					rQ.get(i).add(r);
					cQ.get(i).add(c - 1);
					step[i][r][c - 1] = step[i][r][c] + 1;
				}
			}
		}
		int b = 0;
		for (int i = 1; i < twb + 1; i++) {
			if (step[0][rE][cE] >= step[i][rE][cE]) {
				b += battles.get(i - 1);
			}
		}
		System.out.println(b);
	}

}
