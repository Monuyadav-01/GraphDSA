package GraphLeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class CourseScedule2 {

    public static void main(String[] args) {
        int pre[][] = {
                {1, 0},
                {2, 0},
                {3, 1},
                {3, 2}
        };
        int n = 4;
        int ans[] = findOrder(n, pre);
        for(int i : ans){
            System.out.print(i + " ");
        }

    }

    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        /*
        Steps:->
        1. make an adj list
        2. use topological sort/kahn's algo :->
        2.1 make an inDegree array and store degrees of all courses
        2.2 make a queue and store a degree of '0' in q
        2.3 do inDegree of ele decrease when we reach on that ele
         */
        int[] inDegree = new int[numCourses];
        Arrays.fill(inDegree, 0);
        Queue<Integer> q = new LinkedList<>();
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        for (int pre[] : prerequisites) {
            int u = pre[0];
            int v = pre[1];
            adj.get(v).add(u);
            inDegree[u]++;
        }
        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0) {
                q.offer(i);
            }
        }
        ArrayList<Integer> arr = new ArrayList<>();
        while (!q.isEmpty()) {
            int node = q.peek();
            q.poll();
            arr.add(node);

            for (int neighbour : adj.get(node)) {
                inDegree[neighbour]--;
                if (inDegree[neighbour] == 0) {
                    q.offer(neighbour);
                }
            }
        }

        if(arr.size() == numCourses){
            int ans[] = new int[arr.size()];
            for (int i = 0; i < ans.length; i++) {
                ans[i] = arr.get(i);
            }
            return ans;
        }
        else{
            return new int[]{};
        }

    }
}
