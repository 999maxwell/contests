//wip
import java.util.Scanner;
public class ccc17s3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] boards = new int[N];
		int[] heights = new int[4001];
		for (int i = 0; i < N; i++) {
			boards[i] = sc.nextInt();
		}
		for (int i = 0; i < N - 1; i++) {
			for (int j = i + 1; j < N; j++) {
				heights[boards[i] + boards[j]]++;
			}
		}
		int max = 0;
		for (int i = 0; i < 4001; i++) {
			if (heights[i] > max) {
				max = heights[i];
			}
		}
		int count = 0;
		for (int i = 0; i < 4001; i++) {
			if (heights[i] == max) {
				count++;
			}
		}
		System.out.println(max + " " + count);
	}

}
