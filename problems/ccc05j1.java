import java.util.Scanner;
public class ccc05j1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int day = sc.nextInt();
		int eve = sc.nextInt();
		int wknd = sc.nextInt();
		float a = 0;
		float b = 0;
		if (day > 100) {
			a = (25 * (day - 100) + 15 * eve + 20 * wknd) / 100f;
		} else {
			a = (15 * eve + 20 * wknd) / 100f;
		}
		if (day > 250) {
			b = (45 * (day - 250) + 35 * eve + 25 * wknd) / 100f;
		} else {
			b = (35 * eve + 25 * wknd) / 100f;
		}
		
		System.out.println("Plan A costs " + a);
		System.out.println("Plan B costs " + b);
		if (a > b) {
			System.out.println("Plan B is cheapest.");
		} else if (b > a) {
			System.out.println("Plan A is cheapest.");
		} else {
			System.out.println("Plan A and B are the same price.");
		}
	}

}
