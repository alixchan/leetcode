public class ScoreAfterFlippingMatrix861 {

    public int matrixScore(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            if (grid[i][0] == 0) {
                flipRow(grid, i);
            }
        }

        for (int j = 1; j < grid[0].length; j++) {
            int countOnes = 0;
            for (int[] ints : grid) {
                if (ints[j] == 1) {
                    countOnes++;
                }
            }
            if (countOnes < grid.length - countOnes) {
                flipColumn(grid, j);
            }
        }
        int total = 0;
        for (int[] row : grid) {
            total += binaryToInt(row);
        }

        return total;
    }

    private void flipRow(int[][] grid, int row) {
        for (int j = 0; j < grid[row].length; j++) {
            grid[row][j] = grid[row][j] == 0 ? 1 : 0;
        }
    }

    private void flipColumn(int[][] grid, int col) {
        for (int i = 0; i < grid.length; i++) {
            grid[i][col] = grid[i][col] == 0 ? 1 : 0;
        }
    }

    private int binaryToInt(int[] binary) {
        int num = 0;
        for (int bit : binary) {
            num = num * 2 + bit;
        }
        return num;
    }
}
