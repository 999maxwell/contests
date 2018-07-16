import java.util.Scanner;
public class dmopc17c5p0 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int b = sc.nextInt();
		int p = sc.nextInt();
		sc.nextLine();
		String v = sc.nextLine();
		
		if (p * 2 > b) {
			System.out.println("NO PIZZA");
		} else if (p * 5 > b) {
			if (v.equals("Y")) {
				System.out.println("D");
			} else {
				System.out.println("C");
			}
		} else {
			if (v.equals("Y")) {
				System.out.println("B");
			} else {
				System.out.println("A");
			}
		}
	}

}
