package Algorithms;

import java.util.ArrayList;
import java.util.Arrays;

public class Bellmanfordalgo {

    public static void main(String[] args) {
        int V = 2;
        int S = 0;
        ArrayList<ArrayList<Integer>> edges = new ArrayList<>() {
            {
                add(new ArrayList<Integer>(Arrays.asList(0, 1, 9)));
            }
        };
        int ans[] = bellman_ford(V, edges, S);
        for (int i : ans) {
            System.out.print(i + " ");
        }
    }

    static int[] bellman_ford(int V, ArrayList<ArrayList<Integer>> edges, int S) {
        // Write your code here

        int[] dist = new int[V];
        Arrays.fill(dist, (int) 1e8);

        dist[S] = 0;

        for (int i = 0; i < V - 1; i++) {
            for (ArrayList<Integer> adj : edges) {
                int u = adj.get(0);
                int v = adj.get(1);
                int wt = adj.get(2);

                if (dist[u] != 1e8 && dist[u] + wt < dist[v]) {
                    dist[v] = dist[u] + wt;
                }
            }
        }

        // nth relax to check negative cycle
        for (ArrayList<Integer> adj : edges) {
            int u = adj.get(0);
            int v = adj.get(1);
            int wt = adj.get(2);

            if (dist[u] != 1e8 && dist[u] + wt < dist[v]) {
                int temp[] = new int[1];
                temp[0] = -1;
                return temp;

            }
        }
        return dist;
    }

}
