package Matrix;

public class ReshapeMatrix566 {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int m = mat.length, n = mat[0].length;

        if (m * n != r * c) {
            return mat;
        }

        int[][] reshaped = new int[r][c];
        for (int i = 0, idx = 0; i < m; i++) {
            for (int j = 0; j < n; j++, idx++) {
                reshaped[idx / c][idx % c] = mat[i][j];
            }
        }
        return reshaped;
    }
}