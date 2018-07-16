import java.util.Scanner;
public class ccc07s2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Box[] boxes = new Box[n];
		for (int i = 0; i < n; i++) {
			int l = sc.nextInt();
			int w = sc.nextInt();
			int h = sc.nextInt();
			boxes[i] = new Box(l, w, h);
		}
		int m = sc.nextInt();
		for (int i = 0; i < m; i++) {
			//int count = 0;
			int itemL = sc.nextInt();
			int itemW = sc.nextInt();
			int itemH = sc.nextInt();
			int min = Integer.MAX_VALUE;
				for (int j = 0; j < n; j++) {
					if ((itemL <= boxes[j].l && itemW <= boxes[j].w && itemH <= boxes[j].h) || (itemL <= boxes[j].l && itemH <= boxes[j].w && itemW <= boxes[j].h) || (itemW <= boxes[j].l && itemL <= boxes[j].w && itemH <= boxes[j].h) ||
							(itemW <= boxes[j].l && itemH <= boxes[j].w && itemL <= boxes[j].h) || (itemH <= boxes[j].l && itemL <= boxes[j].w && itemW <= boxes[j].h) || (itemH <= boxes[j].l && itemW<= boxes[j].w && itemL <= boxes[j].h) ) {
						if (boxes[j].l * boxes[j].w * boxes[j].h < min) {
							min = boxes[j].l * boxes[j].w * boxes[j].h;
						}
					}
				}

			if (min == Integer.MAX_VALUE) {
				System.out.println("Item does not fit.");
			} else {
				System.out.println(min);
			}
		}
	}

	public static class Box {
		int l, w, h;
		public Box(int l, int w, int h) {
			this.l = l;
			this.w = w;
			this.h = h;
		}
	}
}
