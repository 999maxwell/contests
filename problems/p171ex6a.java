import java.util.*;
public class p171ex6a {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		float[] numbers = new float[n];
		for (int i = 0; i < n; i++) {
			numbers[i] = sc.nextFloat();
		}
		Arrays.sort(numbers);
		System.out.println(String.format("%.4f", numbers[numbers.length - 1]));
	}

}
