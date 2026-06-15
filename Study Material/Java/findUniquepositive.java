import java.util.*;

public class findUniquepositive {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
        System.out.println(findMinUniquePositive(matrix));
    }

    public static int findMinUniquePositive(int[][] matrix) {
        List<Integer> positives = new ArrayList<>();
        for (int[] row : matrix) {
            for (int num : row) {
                if (num > 0) positives.add(num);
            }
        }
        if (positives.isEmpty()) return -1;
        Collections.sort(positives);
        int n = positives.size();
        for (int i = 0; i < n; ) {
            int val = positives.get(i);
            int count = 1;
            while (i + count < n && positives.get(i + count).equals(val)) {
                count++;
            }
            if (count == 1) return val;
            i += count;
        }
        return -1;
    }
}
