package GraphLeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ParallelCourseIII {
    public static void main(String[] args) {
        int[] time = {3, 2, 5};
        int[][] relation = {{1, 3}, {2, 3}};
        int n = 3;
        System.out.println(minimumTime(n, relation, time));
    }

    public static int minimumTime(int n, int[][] relations, int[] time) {
        /*
         *make an adj lst
         * use kahn algo
         * make a queue
         * take degree
         * take there time max to complete this
         */
        int[] inDegree = new int[n];
        Arrays.fill(inDegree, 0);
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] arr : relations) {
            int u = arr[0] - 1;
            int v = arr[1] - 1;
            adj.get(u).add(v);
            inDegree[v]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0) q.offer(i);
        }

        int[] courseTime = new int[n];
        Arrays.fill(courseTime, 0);
        while (!q.isEmpty()) {
            int node = q.peek();
            q.poll();
            for (int neighbour : adj.get(node)) {
                inDegree[neighbour]--;
                if (inDegree[neighbour] == 0) {
                    q.offer(neighbour);
                }
                courseTime[neighbour] = Math.max(courseTime[neighbour], courseTime[node] + time[node]);
            }
        }
        int ans =0;
        for(int i = 0;i< courseTime.length;i++){
            ans =Math.max(ans, courseTime[i] + time[i]);
        }
        return ans;
    }
}
