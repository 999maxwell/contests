import java.util.*;
public class ccc11j3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		numbers.add(sc.nextInt());
		numbers.add(sc.nextInt());
		int count = 0;
		while(numbers.get(numbers.size() - 2) >= numbers.get(numbers.size() - 1)) {
			numbers.add(numbers.get(numbers.size() - 2) - numbers.get(numbers.size() - 1));
			count++;
		}
		System.out.println(count + 2);

	}

}
