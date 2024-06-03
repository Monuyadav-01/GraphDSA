package GraphGFG;

import java.util.LinkedList;
import java.util.Queue;

public class CovidProblem {


    public static int helpaterp(int[][] hospital) {
        // code here

        int row[] = {-1, 1, 0, 0};
        int col[] = {0, 0, -1, 1};


        int row_len = hospital.length;
        int col_len = hospital[0].length;

        Queue<pair> q = new LinkedList<>();

        for (int i = 0; i < row_len; i++) {
            for (int j = 0; j < col_len; j++) {
                if (hospital[i][j] == 2) {
                    q.offer(new pair(i, j));
                }
            }
        }

        int time = 0;

        while (!q.isEmpty()) {
            time++;
            int curr_pat = q.size();
            while (curr_pat != 0) {
                int i = q.peek().r;
                int j = q.peek().c;
                q.poll();
                curr_pat--;

                for (int k = 0; k < 4; k++) {
                    int newRow = i + row[k];
                    int newCol = j + col[k];

                    if (newRow >= 0 && newCol >= 0 && newRow < row_len && newCol < col_len && hospital[newRow][newCol] == 1) {
                        hospital[newRow][newCol] = 2;
                        q.offer(new pair(newRow, newCol));

                    }
                }



            }
        }

        for (int i = 0; i < row_len; i++) {
            for (int j = 0; j < col_len; j++) {
                if (hospital[i][j] == 1) {
                    return -1;
                }
            }
        }
        return time-1;
    }

    public static void main(String[] args) {
        int hospital[][] = {

                {2, 1, 0, 2, 1},
                {1, 0, 1, 2, 1},
                {1, 0, 0, 2, 1}
        };

        System.out.println(helpaterp(hospital));
    }

    static class pair {
        int r;
        int c;

        pair(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }


}


