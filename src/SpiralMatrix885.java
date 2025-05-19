import java.util.List;
import java.util.ArrayList;

public class SpiralMatrix885 {
    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        List<int[]> result = new ArrayList<>();

        result.add(new int[]{rStart, cStart});

        int stepLength = 1;
        int count = 1;

        while (count < rows * cols) {
            for (int i = 0; i < stepLength; i++) {
                cStart++;
                if (rStart >= 0 && rStart < rows && cStart >= 0 && cStart < cols) {
                    result.add(new int[]{rStart, cStart});
                    count++;
                }
            }

            for (int i = 0; i < stepLength; i++) {
                rStart++;
                if (rStart >= 0 && rStart < rows && cStart >= 0 && cStart < cols) {
                    result.add(new int[]{rStart, cStart});
                    count++;
                }
            }

            stepLength++;

            for (int i = 0; i < stepLength; i++) {
                cStart--;
                if (rStart >= 0 && rStart < rows && cStart >= 0 && cStart < cols) {
                    result.add(new int[]{rStart, cStart});
                    count++;
                }
            }

            for (int i = 0; i < stepLength; i++) {
                rStart--;
                if (rStart >= 0 && rStart < rows && cStart >= 0 && cStart < cols) {
                    result.add(new int[]{rStart, cStart});
                    count++;
                }
            }

            stepLength++;
        }

        return result.toArray(new int[rows * cols][2]);
    }

}
