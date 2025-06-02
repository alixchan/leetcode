package BinarySearch;

public class FirstBadVersion278 /* extends VersionControl */ {
    /* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

    public int firstBadVersion(int n) {

        int left = 1;
        int right = n;
        
        while (left < right) {
            int mid = (left + right) >>> 1;
            
            if (isBadVersion(mid)) {
                right = mid; 
            } else {
                left = mid + 1; 
            }
        }
        
        return left;
    }
}

