import java.io.*;
import java.util.*;

public class TestClass {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);

        int n = Integer.parseInt(br.readLine().trim());
        String[] arr_val = br.readLine().split(" ");
        int[] val = new int[n];
        for (int i = 0; i < n; i++) {
            val[i] = Integer.parseInt(arr_val[i]);
        }

        int[][] edge = new int[n - 1][2];
        for (int i = 0; i < n - 1; i++) {
            String[] arr_edge = br.readLine().split(" ");
            edge[i][0] = Integer.parseInt(arr_edge[0]);
            edge[i][1] = Integer.parseInt(arr_edge[1]);
        }

        long out = solve(n, val, edge);
        System.out.println(out);

        wr.close();
        br.close();
    }

    static long solve(int n, int[] val, int[][] edge) {
        // Build adjacency list
        List<List<Integer>> tree = new ArrayList<>();
        for (int i = 0; i < n; i++) tree.add(new ArrayList<>());
        for (int[] e : edge) {
            tree.get(e[0]).add(e[1]);
            tree.get(e[1]).add(e[0]);
        }

        // Start DFS from root node 0
        long[] result = new long[1];
        dfs(0, -1, val, tree, new ArrayList<>(), result);
        return result[0];
    }

    static void dfs(int node, int parent, int[] val, List<List<Integer>> tree,
                    List<Integer> ancestors, long[] result) {
        int count = 0;
        for (int anc : ancestors) {
            long prod = 1L * val[node] * val[anc];
            long sqrt = (long) Math.sqrt(prod);
            if (sqrt * sqrt == prod) count++;
        }

        if (node != 0) result[0] += count;

        ancestors.add(node);
        for (int nei : tree.get(node)) {
            if (nei != parent) {
                dfs(nei, node, val, tree, ancestors, result);
            }
        }
        ancestors.remove(ancestors.size() - 1); // backtrack
    }
}
