package GraphGFG;

import java.util.LinkedList;
import java.util.Queue;

public class ReplacewithX {

    public static void main(String[] args) {
        int n = 5, m = 4;
        char[][] mat = {
                {'X', 'X', 'X', 'X'},
                {'X', 'O', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'O', 'X', 'X'},
                {'X', 'X', 'O', 'O'}
        };

        char ans[][] = fill(n, m, mat);
        for (char a[] : ans) {
            System.out.print("[");

            for (char c : a) {
                System.out.print(c + ",");
            }
            System.out.print("]");
        }

    }

    static char[][] fill(int n, int m, char[][] a) {
        Queue<Pair> q = new LinkedList<>();
        boolean[][] visited = new boolean[n][m];
        int[] row = {-1, 1, 0, 0};
        int[] col = {0, 0, -1, 1};

        // first row
        for (int i = 0; i < m; i++) {
            if (a[0][i] == 'O') {
                q.offer(new Pair(0, i));
                visited[0][i] = true;
            }

        }
        // first col
        for (int i = 1; i < n; i++) {
            if (a[i][0] == 'O') {
                q.offer(new Pair(i, 0));
                visited[i][0] = true;
            }

        }
        // last row
        for (int i = 1; i < m; i++) {
            if (a[n - 1][i] == 'O') {
                q.offer(new Pair(n - 1, i));
                visited[n - 1][i] = true;
            }

        }
        // last col
        for (int i = 1; i < n - 1; i++) {
            if (a[i][m - 1] == 'O') {
                q.offer(new Pair(i, m - 1));
                visited[i][m - 1] = true;
            }

        }

        while (!q.isEmpty()) {
            int nRow = q.peek().f;
            int nCol = q.peek().s;
            q.poll();

            for (int k = 0; k < 4; k++) {
                int newRow = nRow + row[k];
                int newCol = nCol + col[k];

                if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < m && !visited[newRow][newCol] && a[newRow][newCol] == 'O') {
                    q.offer(new Pair(newRow, newCol));
                    visited[newRow][newCol] = true;
                }
            }


        }
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
