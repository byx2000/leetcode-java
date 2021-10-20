package byx.leetcode.problem.两个字符串的最小ASCII删除和;

/**
 * https://leetcode-cn.com/problems/minimum-ascii-delete-sum-for-two-strings/
 */
public class Solution {
    public int minimumDeleteSum(String s1, String s2) {
        return dp(s1, s2, new Integer[s1.length()][s2.length()], 0, 0);
    }

    private int dp(String s1, String s2, Integer[][] cache, int i, int j) {
        if (i == s1.length()) {
            int sum = 0;
            while (j < s2.length()) {
                sum += s2.charAt(j++);
            }
            return sum;
        }

        if (j == s2.length()) {
            int sum = 0;
            while (i < s1.length()) {
                sum += s1.charAt(i++);
            }
            return sum;
        }

        if (cache[i][j] != null) {
            return cache[i][j];
        }

        if (s1.charAt(i) == s2.charAt(j)) {
            return cache[i][j] = dp(s1, s2, cache, i + 1, j + 1);
        } else {
            return cache[i][j] = Math.min(s1.charAt(i) + dp(s1, s2, cache, i + 1, j), s2.charAt(j) + dp(s1, s2, cache, i, j + 1));
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minimumDeleteSum("sea", "eat"));
        System.out.println(solution.minimumDeleteSum("delete", "leet"));
    }
}
