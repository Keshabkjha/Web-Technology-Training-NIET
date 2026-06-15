import java.util.Scanner;

public class ValleyTraverse {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String str = sc.next();
        int count = 0;
        int level = 0;
        for (char c : str.toCharArray()) {
            if (c == 'U') {
                level++;
            } else {
                level--;
            }
            if (level == 0 && c == 'U') {
                count++;
            }
        }
        System.out.println(count);
    }
}
