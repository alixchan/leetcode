public class ImageOverlap835 {
    public int largestOverlap(int[][] img1, int[][] img2) {
        int maxOverlap = 0;
        int n = img1.length;

        for (int verticalShift = -n + 1; verticalShift < n; verticalShift++) {
            for (int horizontalShift = -n + 1; horizontalShift < n; horizontalShift++) {
                maxOverlap = Math.max(maxOverlap, calculateOverlap(img1, img2, verticalShift, horizontalShift));
            }
        }

        return maxOverlap;
    }

    private int calculateOverlap(int[][] img1, int[][] img2, int verticalShift, int horizontalShift) {
        int overlap = 0;
        int n = img1.length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                int shiftedI = i + verticalShift;
                int shiftedJ = j + horizontalShift;

                if (isInBounds(shiftedI, shiftedJ, n)) {
                    if (img1[i][j] == 1 && img2[shiftedI][shiftedJ] == 1) {
                        overlap++;
                    }
                }
            }
        }

        return overlap;
    }

    private boolean isInBounds(int i, int j, int n) {
        return i >= 0 && i < n && j >= 0 && j < n;
    }
}