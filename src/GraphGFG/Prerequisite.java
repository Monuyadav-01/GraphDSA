package GraphGFG;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Prerequisite {
    //++++++++++++++++++++++++++++++++++++++  BFS && Topological sort ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++


    public static boolean isPossible(int N, int P, int[][] prerequisites) {
        // Your Code goes here
        int inDegree[] = new int[N];
        Arrays.fill(inDegree, 0);
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < P; i++) {
            adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
            inDegree[prerequisites[i][0]]++;
        }
        /*
         *kahn algo
         * inDegree find karna
         * size == N (All tasks are completed)
         */
        Queue<Integer> q = new LinkedList<>();
        int counter = 0; // kitne size ka topological sort hoga
        for (int i = 0; i < N; i++) {
            if (inDegree[i] == 0) {
                q.add(i);
            }
        }
        while (!q.isEmpty()) {
            int top = q.peek();
            q.poll();
            counter++;
            for (int neighbour : adj.get(top)) {
                inDegree[neighbour]--;
                if (inDegree[neighbour] == 0) {
                    q.add(neighbour);
                }
            }
        }
        return counter == N;
    }

    // ++++++++++++++++++++++++++++++++++++++ Problem Solve using DFS ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    public static boolean isPos(int N, int P, int[][] prerequisites) {
        boolean vis[] = new boolean[N];
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < P; i++) {
            adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }

        for (int i = 0; i < N; i++) {
            if (dfs(i, adj, vis)) return false;
        }
        return true;
    }

    // +++++++++++++++++++++++++++++++++++++++ Function for DFS +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    public static boolean dfs(int start, ArrayList<ArrayList<Integer>> adj, boolean[] vis) {
        vis[start] = true;
        for (int neighbour : adj.get(start)) {
            if (!vis[neighbour]) {
                if (dfs(neighbour, adj, vis)) {
                    return true;
                }
            } else if (vis[neighbour]) return true;
        }
        vis[start] = false;
        return false;
    }

    public static void main(String[] args) {
        int[][] pre = {{1, 0}, {0, 1}};
        int N = 2;
        int P = 2;

        System.out.println(isPossible(N, P, pre));
        System.out.println(isPos(N, P, pre));
    }
}
