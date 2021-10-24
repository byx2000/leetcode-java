package byx.leetcode.problem.四键键盘;

/**
 * https://www.lintcode.com/problem/867/description
 */
public class Solution {
    public int maxA(int n) {
        return dp(n, 0, 0);
    }

    // 还剩n次按键，当前有x个a，剪切板有y个a
    private int dp(int n, int x, int y) {
        if (n == 0) {
            return x;
        }

        int result = dp(n - 1, x + 1, y);
        if (y > 0) {
            result = Math.max(result, dp(n - 1, x + y, y));
        }
        if (n >= 3) {
            result = Math.max(result, dp(n - 3, x * 2, x));
        }

        return result;
    }
}
