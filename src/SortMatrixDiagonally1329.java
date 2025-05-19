import java.util.Arrays;

public class SortMatrixDiagonally1329 {

    public int[][] diagonalSort(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        for (int i = 0; i < m; i++) {
            sortDiagonal(mat, i, 0, m, n);
        }

        for (int j = 1; j < n; j++) {
            sortDiagonal(mat, 0, j, m, n);
        }
        return mat;
    }

    private void sortDiagonal(int[][] mat, int i, int j, int m, int n) {
        int diagonalLength = Math.min(m - i, n - j);
        int[] diagonal = new int[diagonalLength];

        for (int k = 0; k < diagonalLength; k++) {
            diagonal[k] = mat[i + k][j + k];
        }

        Arrays.sort(diagonal);

        for (int k = 0; k < diagonalLength; k++) {
            mat[i + k][j + k] = diagonal[k];
        }
    }

}
