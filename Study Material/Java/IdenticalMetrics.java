import java.util.*;
public class IdenticalMetrics {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] a = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                a[i][j] = sc.nextInt();
            }
        }
        int[][] b = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                b[i][j] = sc.nextInt();
            }
        }
        boolean identical = true;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <m; j++) {
                if (a[i][j] != b[i][j]) {
                    identical = false;
                    break;
                }
            }
            if (!identical) {
                break;
            }
        }
        if (identical) {
            System.out.println("Identical");
        } else {
            System.out.println("Not Identical");
        }
    }
}
