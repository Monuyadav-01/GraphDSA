package Algorithms;

public class Floyd_Warshall {

    public static void main(String[] args) {
        int matrix[][] = {{0, 1, 43}, {1, 0, 6}, {-1, -1, 0}};
        shortest_distance(matrix);
    }

    public static void shortest_distance(int[][] matrix) {
        // Code here

        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == -1) {
                    matrix[i][j] = (int) 1e9;
                }
                if (i == j) matrix[i][j] = 0;
            }
        }
        // use intermediate node

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = Math.min(matrix[i][j], matrix[i][k] + matrix[k][j]);
                }
            }
        }
        // fill -1 where node id infinite
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 1e9) {
                    matrix[i][j] = -1;
                }
            }
        }


        for(int mat[] : matrix){
            for(int i : mat){
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }


}
