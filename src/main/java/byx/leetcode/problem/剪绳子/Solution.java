package byx.leetcode.problem.剪绳子;

/**
 * https://leetcode-cn.com/problems/jian-sheng-zi-lcof/
 */
public class Solution {
    private Integer[] cache;

    public int cuttingRope(int n) {
        cache = new Integer[n + 1];
        int maxVal = n - 1;
        for (int i = 2; i < n; ++i) {
            maxVal = Math.max(maxVal, i * dp(n - i));
        }
        return maxVal;
    }

    private int dp(int n) {
        if (cache[n] != null) {
            return cache[n];
        }

        int maxVal = n;
        for (int i = 1; i < n; ++i) {
            maxVal = Math.max(maxVal, i * dp(n - i));
        }

        return cache[n] = maxVal;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.cuttingRope(2));
        System.out.println(solution.cuttingRope(10));
        System.out.println(solution.cuttingRope(32));
    }
}
