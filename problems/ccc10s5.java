import java.util.Scanner;
public class ccc10s5 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		int growth = sc.nextInt();
		Node binaryTree = createTreeNode(s);
	}

	public static Node createTreeNode(String s) {
		int index = -1;
		if (!s.startsWith("(")) {
			return new Node(Integer.parseInt(s));
		} else {
			s = s.substring(1, s.length() - 1).trim();
			if (s.startsWith("(")) { //left is node, parse further into left/right
				int count = 1;
				for (int i = 1; i < s.length(); i++) {
					if (s.charAt(i) == '(') {
						count++;
					} else if (s.charAt(i) == ')') {
						count--;
					}
					if (count == 0) {
						index = i + 1;
						break;
					}
				}
			} else { //if left is leaf
				index = s.indexOf(" ");
			}
		}

		//int index will be position to separate left node and right node
		String left = s.substring(0, index);
//		System.out.println(left);
		String right = s.substring(index + 1);
//		System.out.println(right);
		//root or internal node
		//second constructor to create node
		return new Node(createTreeNode(left), createTreeNode(right));
	}

	public static void optimize (Node node, int growth) {

		if (node.left == null) {
			Node leaf = node;
			leaf.maxNutrients = new int[growth + 1];
			for (int i = 0; i <= growth; i++) {
				leaf.maxNutrients[i] = leaf.value + i;
//				System.out.println("leafmax:"+ i + " " + leaf.maxNutrients[i]); //add growth to leaf and increase its maxNutrients
			}
		}
		else {
			Node n = node;
			int max, tmp;
			optimize(n.left, growth);
			int[] optL = new int [growth + 1];
			for (int i = 0; i <= growth; i++) {
				max = 0;
				for (int j = 0; j <= i; j++) {
					tmp = Math.min((1 + j) * (1 + j), n.left.maxNutrients[i - j]); //check for all possible combinations of
					//leaf/branch growth factor allocation: get minimum for either branch or leaf
					//i = total, j = branch, i - j = leaf
					if (tmp > max)
						max = tmp;
				}
				optL[i] = max;
//				System.out.println("optL" + i + " " + optL[i]);
			}
			optimize (n.right, growth);
			int[] optR = new int [growth + 1];
			for (int i = 0 ; i <= growth ; i++) {
				max = 0;
				for (int j = 0 ; j <= i ; j++) {
					tmp = Math.min ((1 + j) * (1 + j), n.right.maxNutrients[i - j]);
					if (tmp > max)
						max = tmp;
				}
				optR[i] = max;
//				System.out.println("optR" + i + " " + optR[i]);
			}
			n.maxNutrients = new int[growth + 1];
			for (int i = 0 ; i <= growth ; i++) {
				max = 0;
				for (int j = 0 ; j <= i ; j++)
				{
					tmp = optL [j] + optR [i - j];
					if (tmp > max)
						max = tmp;
				}
				n.maxNutrients [i] = max;
			}
		}
	}

	public static class Node {
		int[] maxNutrients;
		int value;
		Node left, right;
		//leaf constructor
		public Node(int v) {
			value = v;
			left = null;
			right = null;
		}
		//node connecting two leaves
		public Node(Node l, Node r) {
			value = 0;
			left = l;
			right = r;
		}
	}
}
