package byx.leetcode.problem.两个字符串的删除操作;

/**
 * https://leetcode-cn.com/problems/delete-operation-for-two-strings/
 */
public class Solution {
    public int minDistance(String s1, String s2) {
        return dp(s1, s2, new Integer[s1.length()][s2.length()], 0, 0);
    }

    private int dp(String s1, String s2, Integer[][] cache, int i, int j) {
        if (i == s1.length()) {
            return s2.length() - j;
        }

        if (j == s2.length()) {
            return s1.length() - i;
        }

        if (cache[i][j] != null) {
            return cache[i][j];
        }

        if (s1.charAt(i) == s2.charAt(j)) {
            return cache[i][j] = dp(s1, s2, cache, i + 1, j + 1);
        } else {
            return cache[i][j] = 1 + Math.min(dp(s1, s2, cache, i + 1, j), dp(s1, s2, cache, i, j + 1));
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minDistance("sea", "eat"));
        System.out.println(solution.minDistance("dinitrophenylhydrazine", "acetylphenylhydrazine"));
    }
}
