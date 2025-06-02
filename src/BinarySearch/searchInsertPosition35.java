package BinarySearch;

public class searchInsertPosition35 {
    public int searchInsert(int[] a, int target) {
       	int low = 0; 
        int high = a.length - 1;
        while (low <= high) { 
            int mid = (low + high) >>> 1;
            if (a[mid] < target) {
                low = mid + 1;
            } else if (a[mid] > target) {
                high = mid - 1; 
            } else {
                return mid;
            }
        }
        return low;
    }
}