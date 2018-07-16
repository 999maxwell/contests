import java.util.Arrays;
import java.util.Scanner;
public class valentines18j1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] numbers = new int[n];
		int max = 0;
		for (int i = 0; i < n; i++) {
			numbers[i] = sc.nextInt();
			if (numbers[i] > max) {
				max = numbers[i];
			}
		}
		if (max > 10000) {
			System.out.println("Something is wrong with these cuteness values");
		} else if (max > 1000) {
			System.out.println("Cuteness by definition is similarity to Cactus");
		} else {
			System.out.println("Cuteness by definition is similarity to Carol");
		}
	}

}
