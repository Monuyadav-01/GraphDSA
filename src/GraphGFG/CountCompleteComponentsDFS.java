package GraphGFG;

import java.util.ArrayList;

public class CountCompleteComponentsDFS {
    public static void main(String[] args) {
//        CountCompleteComponentsDFS solution = new CountCompleteComponentsDFS();
        int n = 6;
        int[][] edges = {
                {0, 1}, {0, 2}, {1, 2}, {3, 4}
        };
        System.out.println(countCompleteComponents(n, edges));
    }

    public  static int countCompleteComponents(int n, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        boolean[] visited = new boolean[n];
        int ans = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                int[] counts = new int[2]; // counts[0] -> nodeCnt, counts[1] -> edgeCnt
                dfs(i, visited, adj, counts);
                int nodeCnt = counts[0];
                int edgeCnt = counts[1] / 2; // because graph is undirected
                if (edgeCnt == (nodeCnt * (nodeCnt - 1)) / 2) {
                    ans++;
                }
            }
        }
        return ans;
    }

    public static void dfs(int node, boolean[] visited, ArrayList<ArrayList<Integer>> adj, int[] counts) {
        visited[node] = true;
        counts[0]++; // increment node count
        for (int neighbour : adj.get(node)) {
            counts[1]++; // increment edge count
            if (!visited[neighbour]) {
                dfs(neighbour, visited, adj, counts);
            }
        }
    }
}

