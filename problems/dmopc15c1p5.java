//wip
import java.util.Scanner;
public class dmopc15c1p5 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int c = sc.nextInt();
		int r = sc.nextInt();
		int n = sc.nextInt();
		int[][] A = new int[r][c];
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				A[i][j] = sc.nextInt();
			}
		}
		int[][] prefixSum = new int[r][c];
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (i == 0 && j == 0) {
					prefixSum[i][j] = A[i][j];
				} else if (i == 0) {
					prefixSum[i][j] = A[i][j] + prefixSum[i][j - 1];
				} else if (j == 0) {
					prefixSum[i][j] = A[i][j] + prefixSum[i - 1][j];
				} else {
					prefixSum[i][j] = A[i][j] + prefixSum[i - 1][j] + prefixSum[i][j - 1] - prefixSum[i - 1][j - 1];
				}
			}
		}

		int max = 0;
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				for (int k = i; k < r; k++) {
					for (int l = j; l < c; l++) {
						if ((k - i + 1) * (l - j + 1) == n) {
							int temp = 0;
							if (i != 0 && j != 0) {
								temp = prefixSum[k][l] - prefixSum[k][j - 1] - prefixSum[i - 1][l] + prefixSum[i - 1][j - 1];
							} else if (i == 0 && j != 0)	{
								temp = prefixSum[k][l] - prefixSum[k][j - 1];
							} else if (i != 0 && j == 0)	{
								temp = prefixSum[k][l] - prefixSum[i - 1][l];
							} else {
								temp = prefixSum[k][l];
							}
							if (temp > max) {
								max = temp;
							}
						}
					}
				}
			}
		}
		System.out.println(max);
	}

}
