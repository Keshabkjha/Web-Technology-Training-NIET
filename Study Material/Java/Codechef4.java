import java.util.Scanner;

class Codechef4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int t = scanner.nextInt(); // Number of test cases
        
        while (t-- > 0) {
            int n = scanner.nextInt(); // Number of elements in the array
            long[] v = new long[n];
            
            // Read the array elements
            for (int i = 0; i < n; i++) {
                v[i] = scanner.nextLong();
            }
            
            long c = 0, sm = 0, mn = Long.MAX_VALUE, idx = -1;
            
            // Process the array
            for (int i = 0; i < n; i++) {
                if (v[i] < 0) c++;
                sm += Math.abs(v[i]);
                long p = Math.abs(v[i]);
                if (p < mn) {
                    mn = p;
                    idx = i;
                }
            }
            
            // Output the result based on the count of negative numbers
            if (c % 2 == 0) {
                System.out.println(sm);
            } else {
                System.out.println(sm - 2 * mn);
            }
        }
        
        scanner.close();
    }
}
