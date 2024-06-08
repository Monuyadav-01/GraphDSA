package GraphGFG;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathUndirectedGraph {
//

    public static void main(String[] args) {
        int n = 4, m = 4;
        int[][] edges = {
                {0, 0}, {1, 1}, {1, 3}, {3, 1}
        };
        int src = 3;

        int ans[] = shortestPath(edges, n, m, src);
        for (int i : ans) {
            System.out.print(i + " ");
        }
    }

    public static int[] shortestPath(int[][] edges, int n, int m, int src) {
        // Code here
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] arr : edges) {
            int u = arr[0];
            int v = arr[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        int[] dist = new int[n];
        Arrays.fill(dist, -1);
        boolean[] visited = new boolean[n];


        Queue<Integer> q = new LinkedList<>();
        q.offer(src);
        visited[src] = true;
        dist[src] = 0;
        while (!q.isEmpty()) {
            int node = q.poll();
            int distNode = dist[node];
            for (int neighbour : adj.get(node)) {
                if (!visited[neighbour]) {
                    q.offer(neighbour);
                    visited[neighbour] = true;
                    dist[neighbour] = distNode + 1;


                }
            }

        }
        return dist;
    }

}
