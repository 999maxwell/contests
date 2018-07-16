import java.util.*;
public class ccc16j3 {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        int n = 0;
        for (int i = 0; i < input.length(); i++) {
            for (int j = i + 1; j < input.length() + 1; j++) {
                if (checkPalindrome(input.substring(i, j))) {
                    if ((j - i) > n) {
                        n = (j - i);
                    }
                }
            }
        }
        System.out.println(n);
    }
    public static boolean checkPalindrome (String str) {
        StringBuilder sb = new StringBuilder(str);  
        sb.reverse();  
        String rev = sb.toString();  
        if (str.equals(rev)) {  
            return true;  
        } else{  
            return false;  
        }  
    }
}