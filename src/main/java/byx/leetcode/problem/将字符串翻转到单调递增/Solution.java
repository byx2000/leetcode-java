package byx.leetcode.problem.将字符串翻转到单调递增;

/**
 * https://leetcode-cn.com/problems/flip-string-to-monotone-increasing/
 */
public class Solution {
    public int minFlipsMonoIncr(String s) {
        int[] dp0 = new int[s.length()];
        int[] dp1 = new int[s.length()];

        dp0[0] = (s.charAt(0) == '0') ? 0 : 1;
        dp1[0] = (s.charAt(0) == '1') ? 0 : 1;

        for (int i = 1; i < s.length(); ++i) {
            if (s.charAt(i) == '0') {
                dp0[i] = dp0[i - 1];
                dp1[i] = 1 + Math.min(dp0[i - 1], dp1[i - 1]);
            } else {
                dp0[i] = 1 + dp0[i - 1];
                dp1[i] = Math.min(dp0[i - 1], dp1[i - 1]);
            }
        }

        return Math.min(dp0[s.length() - 1], dp1[s.length() - 1]);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minFlipsMonoIncr("00110"));
        System.out.println(solution.minFlipsMonoIncr("010110"));
        System.out.println(solution.minFlipsMonoIncr("00011000"));
    }
}
