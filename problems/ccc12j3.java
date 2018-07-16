import java.util.Scanner;
public class ccc12j3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int k = sc.nextInt();
		String top = "";
		String middle = "";
		String bottom = "";
		for (int i = 0; i < k; i++) {
			top += "*";
		}
		for (int i = 0; i < k; i++) {
			top += "x";
		}
		for (int i = 0; i < k; i++) {
			top += "*";
		}
		for (int i = 0; i < k; i++) {
			middle += " ";
		}
		for (int i = 0; i < 2 * k; i++) {
			middle += "x";
		}
		for (int i = 0; i < k; i++) {
			bottom += "*";
		}
		for (int i = 0; i < k; i++) {
			bottom += " ";
		}
		for (int i = 0; i < k; i++) {
			bottom += "*";
		}
		for (int i = 0; i < k; i++) {
			System.out.println(top);
		}
		for (int i = 0; i < k; i++) {
			System.out.println(middle);
		}
		for (int i = 0; i < k; i++) {
			System.out.println(bottom);
		}

	}

}
