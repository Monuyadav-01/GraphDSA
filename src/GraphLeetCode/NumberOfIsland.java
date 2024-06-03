package GraphLeetCode;
import java.util.LinkedList;
import java.util.Queue;
public class NumberOfIsland {
    public static void main(String[] args) {
        char[][] grid = {
                {'1', '1', '1', '0', '0'},
                {'1', '1', '0', '0', '1'},
                {'1', '0', '0', '1', '1'},
                {'0', '0', '1', '0', '0'}
        };
        System.out.println("Number of islands: " + numIslands(grid)); // Output: 4
    }
    public  static int numIslands(char[][] grid) {
        int row_len = grid.length;
        int col_len = grid[0].length;
        int cnt = 0;
        int[] row = {-1, 1, 0, 0, -1, 1, -1, 1};
        int[] col = {0, 0, -1, 1, -1, -1, 1, 1};
        Queue<pair> q = new LinkedList<>();
        for (int i = 0; i < row_len; i++) {
            for (int j = 0; j < col_len; j++) {
                if (grid[i][j] == '1') {
                    cnt++;
                    q.offer(new pair(i, j));
                    grid[i][j] = '0';
                    while (!q.isEmpty()) {
                        int n_row = q.peek().f;
                        int n_col = q.peek().s;
                        q.poll();
                        for (int k = 0; k < 8; k++) {
                            int new_row = n_row + row[k];
                            int new_col = n_col + col[k];

                            if (new_row >= 0 && new_row < row_len && new_col >= 0 && new_col < col_len && grid[new_row][new_col] == '1') {
                                grid[new_row][new_col] = '0';
                                q.offer(new pair(new_row, new_col));
                            }
                        }
                    }
                }
            }
        }
        return cnt;
    }
   static class pair {
        int f;
        int s;

        pair(int f, int s) {
            this.f = f;
            this.s = s;
        }
    }
}
