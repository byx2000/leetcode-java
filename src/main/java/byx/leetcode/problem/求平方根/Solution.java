package byx.leetcode.problem.求平方根;

/**
 * https://leetcode-cn.com/problems/jJ0w9p/
 */
public class Solution {
    public int mySqrt(int x) {
        long left = 0, right = x;
        long result = 0;

        while (left <= right) {
            long mid = left + (right - left) / 2;
            if (mid * mid == x) {
                return (int) mid;
            } else if (mid * mid < x) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return (int) result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.mySqrt(4));
        System.out.println(solution.mySqrt(8));
        System.out.println(solution.mySqrt(2147395599));
    }
}
