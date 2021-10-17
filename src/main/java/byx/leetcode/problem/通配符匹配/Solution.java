package byx.leetcode.problem.通配符匹配;

/**
 * https://leetcode-cn.com/problems/wildcard-matching/
 */
public class Solution {
    private Boolean[][] cache;

    public boolean isMatch(String s, String p) {
        cache = new Boolean[s.length() + 1][p.length() + 1];
        return dp(s, p, 0, 0);
    }

    // s[0]~s[i]是否与p[0]~p[j]匹配
    private boolean dp(String s, String p, int i, int j) {
        if (cache[i][j] != null) {
            return cache[i][j];
        }

        if (i == s.length()) {
            while (j < p.length()) {
                if (p.charAt(j) != '*') {
                    return cache[i][j] = false;
                }
                j++;
            }
            return cache[i][j] = true;
        }

        if (j == p.length()) {
            return cache[i][j] = i == s.length();
        }

        if (p.charAt(j) == '?') {
            return cache[i][j] = dp(s, p, i + 1, j + 1);
        } else if (p.charAt(j) == '*') {
            return cache[i][j] = dp(s, p, i, j + 1) || dp(s, p, i + 1, j);
        } else if (s.charAt(i) == p.charAt(j)) {
            return cache[i][j] = dp(s, p, i + 1, j + 1);
        } else {
            return cache[i][j] = false;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isMatch("aa", "a"));
        System.out.println(solution.isMatch("aa", "*"));
        System.out.println(solution.isMatch("cb", "?a"));
        System.out.println(solution.isMatch("adceb", "*a*b"));
        System.out.println(solution.isMatch("acdcb", "a*c?b"));
    }
}
