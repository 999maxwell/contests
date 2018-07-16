import java.util.*;
public class p100ex4 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		String size = "";
		String gender = "";
		switch(s.charAt(0)) {
			case 'M':
				size = "midget";
				break;
			case 'J':
				size = "junior";
				break;
			case 'S':
				size = "senior";
				break;
			default:
				size = "invalid code";
		}
		switch(s.charAt(1)) {
			case 'G':
				gender = "girls";
				break;
			case 'B':
				gender = "boys";
				break;
			default:
				gender = "";
		}
		System.out.println(size + " " + gender); 
	}

}
