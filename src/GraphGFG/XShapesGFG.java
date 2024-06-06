package GraphGFG;

import java.util.LinkedList;
import java.util.Queue;

public class XShapesGFG {

    public static void main(String[] args) {
        char grid[][] = {{'X', 'O', 'X'}, {'O', 'X', 'O'}, {'X', 'X', 'X'}};
        System.out.println(xShape(grid));
    }

    public static int xShape(char[][] grid) {
        // code here

        Queue<pair> q = new LinkedList<>();
        int row_len = grid.length;
        int col_len = grid[0].length;
        boolean[][] visited = new boolean[row_len][col_len];
        int[] row = {-1, 1, 0, 0};
        int[] col = {0, 0, -1, 1};
        int cnt = 0;
        for (int i = 0; i < row_len; i++) {
            for (int j = 0; j < col_len; j++) {
                if (grid[i][j] == 'X' && !visited[i][j]) {
                    cnt++;
                    q.offer(new pair(i, j));
                    visited[i][j] = true;
                    while (!q.isEmpty()) {

                        int n_row = q.peek().first;
                        int n_col = q.peek().second;
                        q.poll();

                        for (int k = 0; k < 4; k++) {
                            int new_row = n_row + row[k];
                            int new_col = n_col + col[k];
                            if (new_row >= 0 && new_col >= 0 && new_row < row_len && new_col < col_len && !visited[new_row][new_col] && grid[new_row][new_col] == 'X') {
                                q.offer(new pair(new_row, new_col));
                                visited[new_row][new_col] = true;

                            }
                        }
                    }
                }
            }
        }
        return cnt;


    }

    static class pair {
        int first;
        int second;

        pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }


}
