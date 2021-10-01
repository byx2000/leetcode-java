package byx.leetcode.problem.长度为三且各字符不同的子字符串;

/**
 * https://leetcode-cn.com/problems/substrings-of-size-three-with-distinct-characters/
 */
public class Solution {
    public int countGoodSubstrings(String s) {
        int cnt = 0;
        for (int i = 0; i + 2 < s.length(); ++i) {
            if (s.charAt(i) != s.charAt(i + 1) &&
                    s.charAt(i + 1) != s.charAt(i + 2) &&
                    s.charAt(i + 2) != s.charAt(i)) {
                cnt++;
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.countGoodSubstrings("xyzzaz"));
        System.out.println(solution.countGoodSubstrings("aababcabc"));
    }
}
