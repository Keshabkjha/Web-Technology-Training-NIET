import java.util.Scanner;
import java.util.ArrayList;

public class Codechef3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int t = scanner.nextInt(); 
        while (t-- > 0) {
            int n = scanner.nextInt(); 
            ArrayList<Integer> v = new ArrayList<>(n);
            for (int i = 0; i < n; i++) {
                v.add(scanner.nextInt());
            }
            
            int l = -1, r = -1;
            for (int i = 0; i < n; i++) {
                if (v.get(i) > 0) {
                    l = i;
                    break;
                }
            }
            
            for (int i = n - 1; i >= 0; i--) {
                if (v.get(i) > 0) {
                    r = i;
                    break;
                }
            }
            
            if (l == r) {
                System.out.println("0");
            } else {
                int c = 0;
                for (int i = l; i <= r; i++) {
                    if (v.get(i) < 0) {
                        c++;
                    }
                }
                System.out.println(c);
            }
        }
        
        scanner.close();
    }
}
