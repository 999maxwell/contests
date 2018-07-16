import java.util.*;
public class ccc12s3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] readings = new int[n];
		int[] frequency = new int[1001];
		for (int i = 0; i < n; i++) {
			readings[i] = sc.nextInt();
		}
		Arrays.sort(readings);
		for (int i = 0; i < readings.length; i++) {
			frequency[readings[i]]++;
		}
		int largestFreq = 0;
		int secondFreq = 0;
		for (int i = 0; i < 1000; i++) {
			if (frequency[i] > largestFreq) {
				largestFreq = frequency[i];
			}
			if (frequency[i] > secondFreq && frequency[i] < largestFreq) {
				secondFreq = frequency[i];
			}
		}
		LinkedList<Integer> readingSort = new LinkedList<Integer>();
		LinkedList<Integer> readingSort2 = new LinkedList<Integer>();
		for (int i = 0; i < 1000; i++) {
			if (frequency[i] == largestFreq) {
				if (frequency[i] != 0) {
					readingSort.add(i);
				}
			} else if (frequency[i] == secondFreq) {
				if (frequency[i] != 0) {
					readingSort2.add(i);
				}
			}
		}

		Collections.sort(readingSort);
		Collections.sort(readingSort2);
		if (readingSort.size() >= 2) {
			System.out.println(readingSort.get(readingSort.size() - 1) - readingSort.get(0));

		} else {
			if (Math.abs(readingSort.get(readingSort.size() - 1) - readingSort2.get(0)) > Math.abs(readingSort.get(0) - readingSort2.get(readingSort2.size() - 1))) {
				System.out.println(Math.abs(readingSort.get(readingSort.size() - 1) - readingSort2.get(0)));
			} else {
				System.out.println(Math.abs(readingSort.get(0) - readingSort2.get(readingSort2.size() - 1)));
			}

		}
	}

}
