package byx.leetcode.problem.最多删除一个字符得到回文;

/**
 * https://leetcode-cn.com/problems/RQku0D/
 */
public class Solution {
    public boolean validPalindrome(String s) {
        int i = 0, j = s.length() - 1;

        while (i < j) {
            if (s.charAt(i) == s.charAt(j)) {
                i++;
                j--;
            } else {
                return check(s, i + 1, j) || check(s, i, j - 1);
            }
        }

        return true;
    }

    private boolean check(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.validPalindrome("aba"));
        System.out.println(solution.validPalindrome("abca"));
        System.out.println(solution.validPalindrome("abc"));
    }
}
