import java.util.Scanner;
//public class countWords {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        String str = sc.nextLine();
//        String[] words = str.split( "[\s,;./|-]+");
//        System.out.println(words.length);
//    }
//}
public class countWords {
    public static void main(String[] args) {
        String S = "a\nyo\n";
        String[] words = S.trim().split("[\\s\\t\\n\\r\\f]+");
        System.out.println(words.length); // Output: 2
    }
}
