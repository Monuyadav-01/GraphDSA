package GraphGFG;

import java.util.*;

public class AlienDictionary {
    public static void main(String[] args) {
        int N = 5, K = 4;
        String[] dict = {"baa", "abcd", "abca", "cab", "cad"};
        System.out.println(findOrder(dict, N, K));

    }

    public static String findOrder(String[] dict, int N, int K) {
        // Write your code here
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < K; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < N - 1; i++) {
            String n1 = dict[i];
            String n2 = dict[i + 1];

            int len = Math.min(n1.length(), n2.length());
            for (int ptr = 0; ptr < len; ptr++) {
                if (n1.charAt(ptr) != n2.charAt(ptr)) {
                    adj.get(n1.charAt(ptr) - 'a').add(n2.charAt(ptr) - 'a');
                    break;
                }
            }
        }

        List<Integer> topo = toPoSort(adj, K);
        String ans = "";
        for (int it : topo) {
            ans = ans + (char) (it + (int) ('a'));
        }

        return ans;

    }

    public static List<Integer> toPoSort(List<List<Integer>> adj, int V) {
        int[] degree = new int[V];
        ArrayList<Integer> ans = new ArrayList<>();
        Arrays.fill(degree, 0);
        for (int i = 0; i < V; i++) {
            for (int it : adj.get(i)) {
                degree[it]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < V; i++) {
            if (degree[i] == 0) {
                q.offer(i);
            }
        }
        while (!q.isEmpty()) {
            int top = q.peek();
            q.poll();
            ans.add(top);

            for (int it : adj.get(top)) {
                degree[it]--;
                if (degree[it] == 0) {
                    q.offer(it);
                }
            }
        }
        return ans;

    }
}
