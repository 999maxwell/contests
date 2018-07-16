import java.util.Scanner;

public class dmpg18b1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int count = 0;
		for (int i = 0; i < 3; i++) {
			int n = sc.nextInt();
			if (n % 3 == 0) {
				count += n / 3;
			} else {
				count += n / 3 + 1;
			}
		}
		System.out.println(count);

	}

}
