import java.util.*;
public class ccc06j2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int first = sc.nextInt();
		int second = sc.nextInt();
		int count = 0;
		for (int i = 1; i <= first; i++) {
			for (int j = 1; j <= second; j++) {
				if (i + j == 10) count++;
			}
		}
		if (count != 1) {
				System.out.println("There are " + count + " ways to get the sum 10.");
		} else {
			System.out.println("There is 1 way to get the sum 10.");
		}	

	}

}
