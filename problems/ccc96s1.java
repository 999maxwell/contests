import java.util.*;
public class ccc96s1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int repeat = sc.nextInt();
		for (int i = 0; i < repeat; i++) {
			int n = sc.nextInt();
			int sum = 0;
			ArrayList<Integer> divisors = new ArrayList<Integer>();
			for (int j = 1; j < n; j++) {
				if (n % j == 0) {
					divisors.add(j);
				}
			}
			for (int j = 0; j < divisors.size(); j++) {
				sum += divisors.get(j);
			}
			if (sum < n) {
				System.out.println(n + " is a deficient number.");
			} else if (sum == n) {
				System.out.println(n + " is a perfect number.");
			} else if (sum > n) {
				System.out.println(n + " is an abundant number.");
			}
		}

	}

}
	
