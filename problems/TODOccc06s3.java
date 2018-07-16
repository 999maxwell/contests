import java.util.Scanner;
public class TODOccc06s3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int count = 0;
		int xR = sc.nextInt();
		int yR = sc.nextInt();
		int xJ = sc.nextInt();
		int yJ = sc.nextInt();
		double M = ((double) (yJ - yR) / (xJ - xR));
		double B = (double) (yR - (M * xR));
		int N = sc.nextInt();
		for (int i = 0; i < N; i++) {
			int C = sc.nextInt();
			int[][] corner = new int[C + 1][2];
			for (int j = 0; j < C; j++) {
				corner[j][0] = sc.nextInt();
				corner[j][1] = sc.nextInt();
			}
			corner[C][0] = corner[0][0];
			corner[C][1] = corner[0][1];
			boolean cross = false;
			for (int j = 0; j < C; j++) {
				int x1 = corner[j][0];
				int y1 = corner[j][1];
				int x2 = corner[j + 1][0];
				int y2 = corner[j + 1][1];
				if (x1 != x2) {
					double m = ((double) (y2 - y1) / (x2 - x1));
					double b = (double) (y1 - (m * x1));
					double x = ((double) (b - B) / (M - m));
						/*
					Mx + B = mx + b;
					Mx = mx + (b - B);
					Mx - mx = (b - B);
					x(M - m) = (b - B);
					x = (b - B) / (M - m);
						 */
					if (x2 > x1) {
						if (x2 >= x && x1 <= x) {
							cross = true;
						}
					} else {
						if (x2 <= x && x1 >= x) {
							cross = true;
						}
					}
				} else {
					double y = ((double) (M * x1 + B));
					if (y2 > y1) {
						if (y2 >= y && y1 <= y) {
							cross = true;
						}
					} else {
						if (y2 <= y && y1 >= y) {
							cross = true;
						}
					}
				}
			}
			if (cross) {
				count++;
			}
		}
		System.out.println(count);
	}

}
