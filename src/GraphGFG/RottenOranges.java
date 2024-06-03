package GraphGFG;

import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges {

    public static void main(String[] args) {
        int mat[][] = {{0, 1, 2}, {0, 1, 2}, {2, 1, 1}};
        System.out.println(orangesRotting(mat));
    }

    public static int orangesRotting(int[][] grid) {
        Queue<pair> q = new LinkedList<>();
        int row_len = grid.length;
        int col_len = grid[0].length;

        int row[] = {-1, 1, 0, 0};
        int col[] = {0, 0, -1, 1};
        int orange_cnt = 0;
        int cnt_min = 0;
        int cnt = 0;
        int time = 0;
        for (int i = 0; i < row_len; i++) {
            for (int j = 0; j < col_len; j++) {
                if (grid[i][j] == 2) {
                    q.offer(new pair(i, j));
                }
                if (grid[i][j] != 0) {
                    orange_cnt++;
                }
            }
        }
        if (orange_cnt == 0) return 0;

        while (!q.isEmpty()) {
            int size = q.size();
            cnt += size;
            for (int i = 0; i< size; i++) {
                int n_row = q.peek().first;
                int n_col = q.peek().second;
                q.poll();
                for (int k = 0; k < 4; k++) {
                    int new_row = n_row + row[k];
                    int new_col = n_col + col[k];

                    if (new_row >= 0 && new_col >= 0 && new_row < row_len && new_col < col_len && grid[new_row][new_col] == 1) {
                        grid[new_row][new_col] = 2;
                        q.offer(new pair(new_row, new_col));
                    }
                }
            }
            if (!q.isEmpty()) {
                cnt_min++;
            }
        }
        if (cnt == orange_cnt) {
            return cnt_min;
        } else {
            return -1;
        }

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
