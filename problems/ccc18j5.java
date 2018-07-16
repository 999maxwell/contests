import java.util.*;
public class ccc18j5 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		boolean[][] pages = new boolean[N][N];
		LinkedList<Integer> ends = new LinkedList<Integer>();
		for (int i = 0; i < N; i++) {
			int n = sc.nextInt();
			if (n == 0) {
				ends.add(i);
			} else {
				for (int j = 0; j < n; j++) {
					int toPage = sc.nextInt() - 1;
					pages[i][toPage] = true;
				}
			}
		}
		int min = Integer.MAX_VALUE;
		int[] step = new int[N];
		Arrays.fill(step, Integer.MAX_VALUE);
		step[0] = 1;
		LinkedList<Integer> pageQ = new LinkedList<Integer>();
		pageQ.add(0);
		while (!pageQ.isEmpty()) {
			int p = pageQ.poll();
			for (int i = 0; i < N; i++) {
				if (pages[p][i]) {
					if (step[i] > step[p] + 1) {
						if (ends.contains(i)) {
							step[i] = step[p] + 1;
							if (min > step[i]) {
								min = step[i];
							}
						} else {
							step[i] = step[p] + 1;
							pageQ.add(i);
						}
					}
				}
			}
		}
		boolean allBooks = true;
		for (int i = 0; i < N; i++) {
			if (step[i] == Integer.MAX_VALUE) {
				allBooks = false;
				break;
			}
		}
		if (allBooks) {
			System.out.println("Y");
		} else {
			System.out.println("N");
		}
		System.out.println(min);
	}

}
