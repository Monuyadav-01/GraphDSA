package GraphLeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Loud_And_Rich {

    public static int[] loudAndRich(int[][] richer, int[] quiet) {

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int n = quiet.length;

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        int[] inDegree = new int[n];
        Arrays.fill(inDegree, 0);

        for (int[] rich : richer) {
            int u = rich[0];
            int v = rich[1];
            adj.get(u).add(v);
            inDegree[v]++;
        }

        Queue<Integer> q = new LinkedList<>();
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = i;
        }
        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0) {
                q.offer(i);
            }
        }
        while (!q.isEmpty()) {
            int node = q.peek();
            q.poll();
            for (int neighbour : adj.get(node)) {
                inDegree[neighbour]--;
                if (quiet[ans[neighbour]] > quiet[ans[node]]) {
                    ans[neighbour] = ans[node];

                }
                if (inDegree[neighbour] == 0) {
                    q.offer(neighbour);
                }
            }

        }
        return ans;

    }


    public static void main(String[] args) {
        int[][] richer = {

                {1, 0}, {2, 1}, {3, 1}, {4, 3}, {5, 3}, {6, 3}
        };

        int quiet[] = {3, 2, 5, 4, 6, 1, 7, 0};

        int ans[] = loudAndRich(richer, quiet);


        for (int i : ans) {
            System.out.print(i);
        }
    }
}
