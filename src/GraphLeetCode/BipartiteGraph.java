package GraphLeetCode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BipartiteGraph {

    public static void main(String[] args) {
        int graph[][] =
                {
                        {1, 3},
                        {0, 2},
                        {1, 3},
                        {0, 2}
                };
        System.out.println(isBipartite(graph));
    }

    public static boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int color[] = new int[n];
        Queue<Integer> q = new LinkedList<>();
        Arrays.fill(color, -1);
        for (int i = 0; i < n; i++) {
            if (color[i] == -1) {
                color[i] = 0;
                q.offer(i);
            }

                while (!q.isEmpty()) {

                    int node = q.peek();
                    q.poll();
                    for (int it : graph[node]) {
                        // color assign nhi hua h

                        if (color[it] == -1) {
                            color[it] = 1 - color[node];
                            q.offer(it);
                        }
                        // color assign ho gya h
                        else if (color[node] == color[it]) {
                            return false;
                        }

                    }
                }
            }
        return  true;

        }
    }

