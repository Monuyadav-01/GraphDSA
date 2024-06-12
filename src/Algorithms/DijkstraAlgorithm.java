package Algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class DijkstraAlgorithm {


    static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S) {
        // Write your code here
        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.dist));

        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[S] = 0;
        pq.add(new Pair(S, 0));

        while (!pq.isEmpty()) {
            int node = pq.peek().src;
            int distance = pq.peek().dist;
            pq.poll();

            if (distance > dist[node]) {
                continue;
            }
            for (ArrayList<Integer> neighbour : adj.get(node)) {
                int edgeNode = neighbour.get(0);
                int edgeWeight = neighbour.get(1);
                if (distance + edgeWeight < dist[edgeNode]) {
                    dist[edgeNode] = distance + edgeWeight;
                    pq.add(new Pair(edgeNode, dist[edgeNode]));
                }
            }
        }

        return dist;
    }

    public static void main(String[] args) {
// Example graph
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

    static class Pair {
        int src;
        int dist;

        Pair(int src, int dist) {
            this.src = src;
            this.dist = dist;
        }
    }
}
