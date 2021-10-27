package byx.leetcode.problem.分割回文串II;

/**
 * https://leetcode-cn.com/problems/palindrome-partitioning-ii/
 */
public class Solution {
    private Integer[] cache1;
    private Boolean[][] cache2;

    public int minCut(String s) {
        cache1 = new Integer[s.length()];
        cache2 = new Boolean[s.length()][s.length()];
        return dp(s, s.length() - 1);
    }

    private boolean isPalindrome(String s, int i, int j) {
        if (cache2[i][j] != null) {
            return cache2[i][j];
        }

        if (i == j) {
            return cache2[i][j] = true;
        }

        if (i + 1 == j) {
            return cache2[i][j] = s.charAt(i) == s.charAt(j);
        }

        if (s.charAt(i) == s.charAt(j)) {
            return cache2[i][j] = isPalindrome(s, i + 1, j - 1);
        } else {
            return cache2[i][j] = false;
        }
    }

    // 分割s[0]~s[index]
    private int dp(String s, int index) {
        if (cache1[index] != null) {
            return cache1[index];
        }

        if (isPalindrome(s, 0, index)) {
            return cache1[index] = 0;
        }

        int res = index;
        for (int i = index - 1; i >= 0; --i) {
            if (isPalindrome(s, i + 1, index)) {
                res = Math.min(res, dp(s, i) + 1);
            }
        }
        return cache1[index] = res;
    }
}
