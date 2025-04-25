import java.util.*;

public class WeakRow1337 {
    public int[] kWeakestRows(int[][] mat, int k) {
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> {
            return a[0] != b[0] ? b[0] - a[0] : b[1] - a[1];
        });

        for (int i = 0; i < mat.length; i++) {
            int soldiers = countSoldiers(mat[i]);
            heap.offer(new int[]{soldiers, i});
            if (heap.size() > k) {
                heap.poll();
            }
        }

        int[] result = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            result[i] = heap.poll()[1];
        }

        return result;
    }

    private int countSoldiers(int[] row) {
        int left = 0;
        int right = row.length;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (row[mid] == 1) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
