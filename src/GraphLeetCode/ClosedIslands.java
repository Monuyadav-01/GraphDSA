package GraphLeetCode;
import java.util.LinkedList;
import java.util.Queue;

//public class ClosedIslands {
//    public static void main(String[] args) {
//        int grid[][] =
//                {
//                        {0, 0, 1, 0, 0},
//                        {0, 1, 0, 1, 0},
//                        {0, 1, 1, 1, 0}
//                };
//
//        System.out.println(closedIsland(grid));
//    }
//
//    public static int closedIsland(int[][] grid) {
//
//        int row_len = grid.length;
//        int col_len = grid[0].length;
//
//        int row[] = {-1, 1, 0, 0};
//        int col[] = {0, 0, -1, 1};
//
//        Queue<pair> q = new LinkedList<>();
//        boolean[][] visited = new boolean[row_len][col_len];
//
//        int cnt = 0;
//        for (int i = 0; i < row_len; i++) {
//            for (int j = 0; j < col_len; j++) {
//                if (grid[i][j] == 0) {
//                    q.add(new pair(i, j));
//                    visited[i][j] = true;
//                    if ((i == 0 || i == row_len - 1 || j == 0 || j == col_len - 1) && grid[i][j] == 0 && !visited[i][j]) {
//                        if (grid[i][j] == 0 && !visited[i][j]) {
//                            while (!q.isEmpty()) {
//                                int nRow = q.peek().first;
//                                int nCol = q.peek().second;
//                                q.poll();
//
//                                for (int k = 0; k < 4; k++) {
//                                    int new_row = nRow + row[k];
//                                    int new_col = nCol + col[k];
//
//                                    if (new_row >= 0 && new_col >= 0 && new_row < row_len && new_col < col_len && !visited[new_row][new_col] && grid[new_row][new_col] == 0) {
//                                        q.offer(new pair(new_row, new_col));
//                                        visited[new_row][new_col] = true;
//                                    }
//
//                                }
//                            }
//                            cnt++;
//                        }
//                    }
//
//                }
//            }
//        }
//        return cnt;
//
//    }
//
//    static class pair {
//        int first;
//        int second;
//
//        pair(int first, int second) {
//            this.first = first;
//            this.second = second;
//        }
//    }
//}

public class ClosedIslands {
    public static void main(String[] args) {
        int grid[][] =
                {
                        {0, 0, 1, 0, 0},
                        {0, 1, 0, 1, 0},
                        {0, 1, 1, 1, 0}
                };

        System.out.println(closedIsland(grid));
    }

    public static int closedIsland(int[][] grid) {
        int row_len = grid.length;
        int col_len = grid[0].length;

        int[] row = {-1, 1, 0, 0};
        int[] col = {0, 0, -1, 1};

        Queue<pair> q = new LinkedList<>();
        boolean[][] visited = new boolean[row_len][col_len];

        int cnt = 0;
        for (int i = 0; i < row_len; i++) {
            for (int j = 0; j < col_len; j++) {
                // Start BFS if we find an unvisited land cell
                if (grid[i][j] == 0 && !visited[i][j]) {
                    if (isClosedIsland(grid, visited, i, j, row, col, row_len, col_len)) {
                        cnt++;
                    }
                }
            }
        }
        return cnt;
    }

    public static boolean isClosedIsland(int[][] grid, boolean[][] visited, int i, int j, int[] row, int[] col, int row_len, int col_len) {
        Queue<pair> q = new LinkedList<>();
        q.add(new pair(i, j));
        visited[i][j] = true;

        boolean isClosed = true;

        while (!q.isEmpty()) {
            int nRow = q.peek().first;
            int nCol = q.peek().second;
            q.poll();

            // Check if the current cell is on the boundary
            if (nRow == 0 || nRow == row_len - 1 || nCol == 0 || nCol == col_len - 1) {
                isClosed = false;
            }

            for (int k = 0; k < 4; k++) {
                int new_row = nRow + row[k];
                int new_col = nCol + col[k];

                if (new_row >= 0 && new_col >= 0 && new_row < row_len && new_col < col_len && !visited[new_row][new_col] && grid[new_row][new_col] == 0) {
                    q.offer(new pair(new_row, new_col));
                    visited[new_row][new_col] = true;
                }
            }
        }

        return isClosed;
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
