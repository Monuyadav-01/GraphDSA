package GraphGFG;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class ShortestPathACG {

    public static void main(String[] args) {
        int N = 4;
        int M = 2;
        int [][] edges = {
                {0,1,2},
                {0,2,1}
        };

        int[] ans = shortestPath(N, M, edges);
        for(int i : ans){
            System.out.print(i + " ");
        }
    }

    public static int[] shortestPath(int N, int M, int[][] edges) {
        //Code here
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int weight = edge[2];

            adj.get(u).add(new Pair(v, weight));
        }

        boolean visited[] = new boolean[N];
        Stack<Integer> st = new Stack<>();
        toPoSort(0, visited, st, adj);

        int[] dist = new int[N];
        Arrays.fill(dist, (int) 1e9);
        dist[0] = 0;
        while (!st.isEmpty()) {
            int node = st.peek();
            st.pop();

          for(int i  = 0;i<adj.get(node).size();i++){
              int neighbour = adj.get(node).get(i).src;
              int weight = adj.get(node).get(i).weight;

              dist[neighbour]  = Math.min(dist[neighbour] , weight + dist[node]);
          }
        }
        for(int i = 0;i<dist.length;i++){
            if(dist[i] == 1e9) dist[i] = -1;
        }
        return dist;

    }

    public static void toPoSort(int start, boolean[] visited, Stack<Integer> st, ArrayList<ArrayList<Pair>> adj) {
        st.push(start);
        visited[start] = true;
        for(int j =0;j<adj.get(start).size();j++){
            int node = adj.get(start).get(j).src;
            if (!visited[node]) {
                visited[node] = true;
                toPoSort(node, visited, st, adj);
            }
        }

    }

    private static class Pair {
        int src;
        int weight;

        Pair(int src, int weight) {
            this.src = src;
            this.weight = weight;
        }
    }
}
