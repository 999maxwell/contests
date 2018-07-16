import java.util.Scanner;
public class valentines18j4s1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int h = (n + m) / 2;
		int forward = h;
		int backward = h;
		while (true) {
			if (isPalindrome(forward) && forward <= m) {
				System.out.println(forward);
				break; 
			} else if (isPalindrome(backward) && backward >= n) {
				System.out.println(backward);
				break;
			} else if (forward > m && backward < n) {
				break;
			}
			forward++;
			backward--;
		}
	}
	public static boolean isPalindrome(int x) {
		String s = Integer.toString(x);
		char[] arr = new char[s.length()];
		arr = s.toCharArray();
		boolean palindrome = true;
		int i = 0;
		int j = arr.length - 1;
		while (true) {
			if (arr[i] != arr[j]) {
				palindrome = false;
			}
			if (i >= j) {
				break;
			}
			i++;
			j--;
		}
		return palindrome;
 	}
}
