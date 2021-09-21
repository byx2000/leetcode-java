package byx.leetcode.problem.完全平方数;

/**
 * https://leetcode-cn.com/problems/perfect-squares/
 */
public class Solution {
    private Integer[] cache;

    public int numSquares(int n) {
        cache = new Integer[n + 1];
        return dp(n);
    }

    private int dp(int n) {
        if (cache[n] != null) {
            return cache[n];
        }

        int s = (int) Math.sqrt(n);
        if (s * s == n) {
            return cache[n] = 1;
        }

        int result = Integer.MAX_VALUE;
        while (s > 0) {
            result = Math.min(result, 1 + dp(n - s * s));
            s--;
        }

        return cache[n] = result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.numSquares(12));
        System.out.println(solution.numSquares(13));
    }
}
