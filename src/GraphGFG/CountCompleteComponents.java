package GraphGFG;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class CountCompleteComponents {
    public static void main(String[] args) {

        int n = 6;
        int edges[][] = {
                {0, 1}, {0, 2}, {1, 2}, {3, 4}
        };
        System.out.println(countCompleteComponents(n, edges));
    }

    public static int countCompleteComponents(int n, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int edge[] : edges) {
            int u = edge[0];
            int v = edge[1];

            adj.get(u).add(v);
            adj.get(v).add(u);
        }


        int ans = 0;

        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                q.offer(i);
                visited[i] = true;
                int edgeCnt = 0;
                int nodeCnt = 0;
                while (!q.isEmpty()) {
                    int node = q.poll();
                    nodeCnt++;
                    for (int neighbour : adj.get(node)) {
                        edgeCnt++;
                        if (!visited[neighbour]) {

                            q.offer(neighbour);
                            visited[neighbour] = true;
                        }
                    }
                    // because graph is undirected
                }
                if (edgeCnt /2 == (nodeCnt * (nodeCnt - 1)) / 2) {
                    ans++;
                }
            }
        }


        return ans;
    }
}
