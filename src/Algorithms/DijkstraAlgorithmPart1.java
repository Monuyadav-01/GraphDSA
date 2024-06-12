package Algorithms;

import java.util.ArrayList;
import java.util.Arrays;

public class DijkstraAlgorithmPart1 {

    static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S) {
        boolean[] explored = new boolean[V];
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[S] = 0;
        int count = V;
        while (count != 0) {
            int node = -1;
            int value = Integer.MAX_VALUE;
            for (int i = 0; i < V; i++) {
                if (!explored[i] && value > dist[i]) {
                    node = i;
                    value = dist[i];
                }
            }
            count--;
            explored[node] = true;
            // Relax the array
            for (int j = 0; j < adj.get(node).size(); j++) {
                int neighbour = adj.get(node).get(j).get(0);
                int weight = adj.get(node).get(j).get(1);
                if (!explored[neighbour] && dist[node] + weight < dist[neighbour]) {
                    dist[neighbour] = dist[node] + weight;
                }
            }
        }
        return dist;
    }

    public static void main(String[] args) {
        int V = 5;
        ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        adj.get(0).add(new ArrayList<>(Arrays.asList(1, 9)));
        adj.get(0).add(new ArrayList<>(Arrays.asList(2, 6)));
        adj.get(0).add(new ArrayList<>(Arrays.asList(3, 5)));
        adj.get(0).add(new ArrayList<>(Arrays.asList(4, 3)));
        adj.get(2).add(new ArrayList<>(Arrays.asList(1, 2)));
        adj.get(2).add(new ArrayList<>(Arrays.asList(3, 4)));

        int startNode = 0;
        int[] distances = dijkstra(V, adj, startNode);

        System.out.println("Shortest distances from node " + startNode + ":");
        for (int i = 0; i < distances.length; i++) {
            System.out.println("Distance to node " + i + ": " + distances[i]);
        }
    }
}
