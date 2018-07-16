import java.util.Scanner;
public class nccc3j2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		boolean b = false;

		for (int i = 1; i <= s.length(); i++) {
			if (checkPalindrome(s.substring(0, i)) && checkPalindrome(s.substring(i)) 
					&& !s.substring(0, i).equals("") && !s.substring(i).equals("")) {
				System.out.println("YES");
				b = true;
				break;
			} 
//			System.out.println(s.substring(0, i));
//			System.out.println(s.substring(i));
//			System.out.println("break");
		}
		if (!b) {
			System.out.println("NO");
		}
	//	System.out.println(checkPalindrome("racear"));
	}

	public static boolean checkPalindrome (String str) {
		StringBuilder sb = new StringBuilder(str);  
		sb.reverse();  
		String rev = sb.toString();  
		if (str.equals(rev)) {  
			return true;  
		} else {  
			return false;  
		}  
	}
}
