package Other;
import java.util.ArrayList;
import java.util.List;

class Solution {

    // https://leetcode.com/problems/running-sum-of-1d-array/submissions/1588934150/
    public static int[] runningSum(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            nums[i] += nums[i - 1];
        }
        return nums;
    }

    // https://leetcode.com/problems/pascals-triangle/
    public static List<List<Integer>> generate(int numRows) {

        List<List<Integer>> res = new ArrayList<>();
        if (numRows == 0) {
            return res;
        }
        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();
            row.add(1);

            if (!res.isEmpty()) {
                List<Integer> prev = res.get(res.size() - 1);

                for (int j = 1; j < i; j++) {
                    row.add(prev.get(j - 1) + prev.get(j));
                }
                row.add(1);

            }
            res.add(row);
        }
        return res;
    }

    // https://leetcode.com/problems/clear-digits/description/
    public static String removeDigits(String s) {
        StringBuilder sb = new StringBuilder(s);
        int i = 0;
        while (i < sb.length()) {
            if (Character.isDigit(sb.charAt(i))) {
                int ch = -1;
                for (int j = i - 1; j >= 0; j--) {
                    if (!Character.isDigit(sb.charAt(j))) {
                        ch = j;
                        break;
                    }
                }

                if (ch != -1) {
                    sb.deleteCharAt(i);
                    sb.deleteCharAt(ch);
                    i = 0;
                } else {
                    i++;
                }
            } else {
                i++;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
//        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        System.out.println(removeDigits("34asd12"));
    }
}
