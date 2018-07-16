import java.math.BigInteger;
import java.util.*;
public class ccc02s2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int denom = sc.nextInt();
		if (num % denom == 0) {
			System.out.println(num / denom);
		} else {
			int wholeNum = (int) (num / denom);
			int newNumerator = num % denom;
			int gcd = findGcd(num, denom);
			int newnewNumerator = newNumerator / gcd;
			int newDenominator = denom / gcd;
			if (wholeNum != 0) {
				System.out.println(wholeNum + " " + newnewNumerator + "/" + newDenominator);
			} else {
				System.out.println(newnewNumerator + "/" + newDenominator);
			}
		}
			
	}
	public static int findGcd(int a, int b) {
		BigInteger b1 = BigInteger.valueOf(a);
	    BigInteger b2 = BigInteger.valueOf(b);
	    BigInteger gcd = b1.gcd(b2);
	    return gcd.intValue();
	}

}
