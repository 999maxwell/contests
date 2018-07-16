import java.util.Arrays;
import java.util.Scanner;
public class dmopc17c5p3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();
		int[] a = new int[size];
		for (int i = 0; i < size; i++) {
			a[i] = sc.nextInt();
		}
		int output = 0;
		Arrays.sort(a);
		for (int i = 2; i <= a[0]; i++) {
			boolean met = false;
			if (isPrime(i)) {
				met = true;
				for (int j = 0; j < size; j++) {
					if (a[j] % i != 0) {
						met = false;
					}
				}
			}
			if (met) {
				output = i;
			}
		}
		if (output == 0) {
			System.out.println("DNE");
		} else {
			System.out.println(output);
		}
	}

	public static boolean isPrime(int n) {
		for (int i = 2; i <= n / 2; i++) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}
}
