package BinarySearch;

public class GuessNumber374 {
/** 
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is higher than the picked number
 *			      1 if num is lower than the picked number
 *               otherwise return 0
 * int guess(int num);
 */

 public int guessNumber(int n) {
    int left = 1;
    int right = n;
    
    while (left <= right) {
        int mid = (right + left) >>> 1;
        int result = guess(mid);
        
        if (result == 0) {
            return mid;
        } else if (result == -1) {
            right = mid - 1;
        } else {
            left = mid + 1;
        }
    }
    return ~left;
}
