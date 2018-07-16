import java.util.Arrays;
import java.util.Scanner;
public class nccc3j4s2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] finalList = new int[N];
		for (int i = 0; i < N; i++) {
			int[] list = new int[N];
			for (int j = 0; j < N; j++) {
				list[j] = sc.nextInt();
			}
			Arrays.sort(list);
			finalList[i] = list[list.length / 2];
		}
		Arrays.sort(finalList);
		System.out.println(finalList[finalList.length / 2]);
	}

}
