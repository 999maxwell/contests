import java.util.Scanner;
public class ccc10j4 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			int N = sc.nextInt();
			if (N == 0) {
				break;
			}
			if (N == 1) {
				System.out.println(0);
			}
			int[] num = new int[N];
			for (int i = 0; i < N; i++) {
				num[i] = sc.nextInt();
			}
			int[] diff = new int[N - 1];
			for (int i = 0; i < N - 1; i++) {
				diff[i] = num[i + 1] - num[i];
			}
			
			for (int i = 1; i <= N - 1; i++) {
				boolean flag = true;
				for (int j = 0; j < N - 1; j++) {
					if (diff[j] != diff[j % i]) {
						flag = false;
						break;
					}
				}
				if (flag) {
					System.out.println(i);
					break;
				}
			}
		}

	}

}
