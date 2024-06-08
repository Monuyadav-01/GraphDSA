package GraphLeetCode;

import java.rmi.UnexpectedException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class parallelCourse2 {
    public static void main(String[] args) {
        int n = 4;
        int[][] relations = {{2, 1}, {3, 1}, {1, 4}};
        int k = 2;

        System.out.println(minNumberOfSemesters(n, relations, k));
    }

    public static int minNumberOfSemesters(int n, int[][] relations, int k) {

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        int[] inDegree = new int[n];
        Arrays.fill(inDegree, 0);
        for (int[] arr : relations) {
            int u = arr[0] - 1;
            int v = arr[1] - 1;
            adj.get(u).add(v);
            inDegree[v]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0) {
                q.offer(i);
            }
        }
        int cnt = 0;


        while (!q.isEmpty()) {
            int size = q.size();
            int coursesThisSemester = Math.min(size, k); // Maximum k courses per semester

            for (int i = 0; i < coursesThisSemester; i++) {
                int node = q.poll();
                for (int neighbour : adj.get(node)) {
                    inDegree[neighbour]--;
                    if (inDegree[neighbour] == 0) {
                        q.add(neighbour);
                    }
                }
            }

            cnt++; // Increment the semester count after processing each semester
        }
        return cnt;
    }
}
