import java.util.Scanner;
public class dmopc17c5p1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '0') {
				System.out.print("O");
			} else if (s.charAt(i) == '1'){
				System.out.print("l");
			} else if (s.charAt(i) == '3'){
				System.out.print("E");
			} else if (s.charAt(i) == '4'){
				System.out.print("A");
			} else if (s.charAt(i) == '5'){
				System.out.print("S");
			} else if (s.charAt(i) == '6'){
				System.out.print("G");
			} else if (s.charAt(i) == '8'){
				System.out.print("B");
			} else if (s.charAt(i) == '9'){
				System.out.print("g");
			} else {
				System.out.print(s.charAt(i));
			}
		}
	}

}
