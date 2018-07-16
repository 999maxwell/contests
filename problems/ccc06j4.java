import java.util.ArrayList;
import java.util.Scanner;
public class ccc06j4 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Integer> inputA = new ArrayList<Integer>();
		ArrayList<Integer> inputB = new ArrayList<Integer>();
		int count = 0;
		while (true) {
			int x = sc.nextInt();
			if (count % 2 == 0) {
				inputA.add(x);
			} else {
				inputB.add(x);
			}
			if (x == 0) {
				if (sc.nextInt() == 0) {
					break;
				}
			}
			count++;
		}
		int[] a = new int[count / 2 + 5];
		a[0] = 1;
		a[1] = 1;
		a[2] = 2;
		a[3] = 3;
		a[4] = 3;
		for (int i = 5; i < count / 2 + 5; i++) {
			a[i] = inputA.get(i - 5);
		}
		int[] b = new int[count / 2 + 5];
		b[0] = 7;
		b[1] = 4;
		b[2] = 1;
		b[3] = 4;
		b[4] = 5;
		for (int i = 5; i < count / 2 + 5; i++) {
			b[i] = inputB.get(i - 5);
		}
		ArrayList<Integer> out = new ArrayList<Integer>();
		int c = 1;
		outerloop:
			while (true) {
				boolean flag = false;
				if (!out.contains(c)) {
					for (int i = 0; i < b.length; i++) {
						if (c == b[i]) {
							boolean check = false;
							for (int j = 0; j < a.length; j++) {
								if (c == b[j] && !out.contains(a[j])) {
									check = true;
									break;
								}
							}
							if (check) {
								flag = true;
							}
							break;
						}
					}
				}
				if (!flag && !out.contains(c)) {

					out.add(c);
					c = 1;
				} else {
					c++;
				}
				if (c > 7) {
					System.out.println("Cannot complete these tasks. Going to bed.");
					break;
				} else if (out.size() == 7) {
					for (int i = 0; i < 7; i++) {
						System.out.print(out.get(i) + " ");
					}
					break outerloop;
				}
			}
//		for (int i = 0; i < a.length; i++) {
//			System.out.print(b[i] + " ");
//		}
	}

}
