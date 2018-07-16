import java.util.Scanner;
public class ccc05s2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int c = sc.nextInt();
		int r = sc.nextInt();
		int a = 0;
		int b = 0;
		while (true) {
			int aa = sc.nextInt();
			a += aa;
			if (a < 0) {
				a = 0;
			} else if (a > c) {
				a = c;
			}
			int bb = sc.nextInt();
			b += bb;
			if (b < 0) {
				b = 0;
			} else if (b > r) {
				b = r;
			}
			if (aa == 0 && bb == 0) {
				break;
			}
			System.out.println(a + " " + b);
		}
	}

}
