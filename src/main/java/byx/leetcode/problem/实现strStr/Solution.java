package byx.leetcode.problem.实现strStr;

/**
 * https://leetcode-cn.com/problems/implement-strstr/
 */
public class Solution {
    public int strStr(String haystack, String needle) {
        if ("".equals(needle)) {
            return 0;
        }

        for (int i = 0; i < haystack.length(); ++i) {
            if (haystack.startsWith(needle, i)) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.strStr("hello", "ll"));
        System.out.println(solution.strStr("hello", ""));
    }
}
