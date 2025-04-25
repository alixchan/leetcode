public class Filter661 {
    public int[][] imageSmoother(int[][] img) {
        int m = img.length;
        int n = img[0].length;
        int[][] result = new int[m][n];

        int[][] directions = {
                {-1, -1}, {-1, 0}, {-1, 1},
                {0, -1},  {0, 0},  {0, 1},
                {1, -1},  {1, 0},  {1, 1}
        };

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int sum = 0;
                int count = 0;

                for (int[] dir : directions) {
                    int ni = i + dir[0];
                    int nj = j + dir[1];

                    if (ni >= 0 && ni < m && nj >= 0 && nj < n) {
                        sum += img[ni][nj];
                        count++;
                    }
                }

                result[i][j] = sum / count;
            }
        }

        return result;
    }
}
