package FS;

public class PathMaximumGold1219 {
    public int getMaximumGold(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int maxGold = 0;
        int rows = grid.length, cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] > 0) {
                    int currentGold = dfs(grid, i, j, visited);
                    maxGold = Math.max(maxGold, currentGold);
                }
            }
        }
        return maxGold;
    }

    private int dfs(int[][] grid, int row, int col, boolean[][] visited) {
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length
                || grid[row][col] == 0 || visited[row][col]) {
            return 0;
        }

        visited[row][col] = true;

        int up = dfs(grid, row - 1, col, visited);
        int down = dfs(grid, row + 1, col, visited);
        int left = dfs(grid, row, col - 1, visited);
        int right = dfs(grid, row, col + 1, visited);

        visited[row][col] = false;

        return grid[row][col] +
                Math.max(
                        Math.max(up, down),
                        Math.max(left, right)
                );
    }
}
