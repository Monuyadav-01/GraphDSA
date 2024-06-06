package GraphGFG;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class CourseScedule {
    public static void main(String[] args) {


    }

    static int[] findOrder(int n, int m, ArrayList<ArrayList<Integer>> prerequisites) {
        // add your code here
        ArrayList<Integer> arr = new ArrayList<>();
        int[] inDegree = new int[n];
        Arrays.fill(inDegree , 0);
        for(ArrayList<Integer> pre : prerequisites){
            int v = pre.get(0);
            inDegree[v]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i<n;i++){
            if (inDegree[i] == 0){
                q.offer(i);
            }
        }

        while (!q.isEmpty()) {
            int top = q.peek();
            arr.add(top);
            q.poll();
            for (int node : prerequisites.get(top)) {
                inDegree[node]--;
                if (inDegree[node] == 0) {
                    q.offer(node);
                }
            }
        }
        int[] ans = new int[arr.size()];
        for(int i =0;i<arr.size();i++){
            ans[i] = arr.get(i);
        }
        return ans;

    }
}
