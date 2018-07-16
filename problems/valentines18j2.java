import java.util.Scanner;
public class valentines18j2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int x = sc.nextInt();
		int y = sc.nextInt();
		int sum = 0;
		int count = 0;
		while (true) {
			sum = sum + x;
			count++;
			if (2 * sum >= n) {
				System.out.println(count);
				break;
			}
			x = x - y;
			if (x <= 0) {
				System.out.println("RIP");
				break;
			}
		}
	}

}
