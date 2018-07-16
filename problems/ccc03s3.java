import java.util.Scanner;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
public class ccc03s3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int amt = sc.nextInt();
		int R = sc.nextInt();
		int C = sc.nextInt();
		char[][] map = new char[R][C];
		sc.nextLine();
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

		LinkedList<Integer> roomOrder = new LinkedList<Integer>();
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] == '.' && step[i][j] == Integer.MAX_VALUE) {
					int roomCount = 1;
					step[i][j] = 0;
					rQ.add(i);
					cQ.add(j);
					while (!rQ.isEmpty()) {
						int r = rQ.pop();
						int c = cQ.pop();
						if (r - 1 >= 0 && map[r - 1][c] == '.' && step[r - 1][c] > step[r][c] + 1) {
							rQ.add(r - 1);
							cQ.add(c);
							step[r - 1][c] = step[r][c] + 1;
							roomCount++;
						}
						if (c + 1 < C && map[r][c + 1] == '.' && step[r][c + 1] > step[r][c] + 1) {
							rQ.add(r);
							cQ.add(c + 1);
							step[r][c + 1] = step[r][c] + 1;
							roomCount++;
						}
						if (r + 1 < R && map[r + 1][c] == '.' && step[r + 1][c] > step[r][c] + 1) {
							rQ.add(r + 1);
							cQ.add(c);
							step[r + 1][c] = step[r][c] + 1;
							roomCount++;
						}
						if (c - 1 >= 0 && map[r][c - 1] == '.' && step[r][c - 1] > step[r][c] + 1) {
							rQ.add(r);
							cQ.add(c - 1);
							step[r][c - 1] = step[r][c] + 1;
							roomCount++;
						}
					}
					roomOrder.add(roomCount);
				}
			}
		}

		int rooms = 0;
		Collections.sort(roomOrder);
		for (int i = roomOrder.size() - 1; i >= 0; i--) {
			if (roomOrder.get(i) <= amt) {
				amt -= roomOrder.get(i);
				rooms++;
			} else {
				break;
			}
		}
		if (rooms == 1) {
			System.out.println("1 room, " + amt + " square metre(s) left over");
		} else {
			System.out.println(rooms + " rooms, " + amt + " square metre(s) left over");
		}
	}

}
