import  java.util.*;
public class ccc08s2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			int radius = sc.nextInt();
			int pennies = 0;
			if (radius == 0) break;
			for (int i = 1; i <= radius; i++) {
				pennies += Math.sqrt(Math.pow(radius, 2) - Math.pow(i, 2));
			}
			pennies *= 4;
			pennies += (radius * 4) + 1;
			System.out.println(pennies);
		}
	}

}
