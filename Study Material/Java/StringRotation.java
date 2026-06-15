import java.util.Scanner;
public class StringRotation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();
        System.out.println(areRotation(s1, s2));
    }
     public static boolean areRotation(String s1, String s2) {
         return s1.length() == s2.length() && (s1 + s1).contains(s2);
         //        return s1.indexOf(s2) != -1;
    }
}
