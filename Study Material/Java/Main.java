import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine().trim());

        while (sc.hasNextLine()) {
            String line = sc.nextLine().trim();
            if (line.equalsIgnoreCase("shuffled")) break;
        }

        String[] shuffled = new String[N];
        for (int i = 0; i < N; i++) {
            shuffled[i] = sc.nextLine().trim().replaceAll("\\s+", " ");
        }

        while (sc.hasNextLine()) {
            String line = sc.nextLine().trim();
            if (line.equalsIgnoreCase("original")) break;
        }

        String[] original = new String[N];
        for (int i = 0; i < N; i++) {
            original[i] = sc.nextLine().trim().replaceAll("\\s+", " ");
        }

        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            map.put(original[i], i);
        }

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = map.get(shuffled[i]);
        }

        // Count number of contiguous increasing segments (blocks)
        int blocks = 1;
        for (int i = 1; i < N; i++) {
            if (arr[i] != arr[i - 1] + 1) {
                blocks++;
            }
        }

        int minOps = blocks - 1;
        System.out.println(minOps);
    }
}
