package GraphGFG;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ReplacewithX {

    public static void main(String[] args) {
        int n = 5, m = 4;
        char[][] mat = {
                {'X', 'O', 'X', 'X'},
                {'X', 'O', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'O', 'X', 'X'},
                {'X', 'X', 'O', 'O'}
        };

    }

    static char[][] fill(int n, int m, char[][] a) {
        Queue<Pair> q = new LinkedList<>();
        boolean[][] visited = new boolean[n][m];
        int[] row = {-1, 1, 0, 0};
        int[] col = {0, 0, -1, 1};

        // first row
        for(int i =0;i<m;i++){
            q.offer(new Pair(0, i));
            visited[0][i] = true;
        }
        for(int )

        // Replace all unvisited 'O's with 'X'
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (a[i][j] == 'O' && !visited[i][j]) {
                    a[i][j] = 'X';
                }
            }
        }

        return a;
    }

    static class Pair {
        int f;
        int s;

        Pair(int f, int s) {
            this.f = f;
            this.s = s;
        }
    }
}
