package byx.leetcode.problem.定长子串中元音的最大数目;

/**
 * https://leetcode-cn.com/problems/maximum-number-of-vowels-in-a-substring-of-given-length/
 */
public class Solution {
    public int maxVowels(String s, int k) {
        int i = 0, j = 0;
        int cnt = 0;
        int maxCnt = 0;

        while (j < s.length()) {
            if (j - i < k) {
                if (isVowel(s.charAt(j))) {
                    cnt++;
                    maxCnt = Math.max(maxCnt, cnt);
                }
                j++;
            } else {
                if (isVowel(s.charAt(j))) {
                    cnt++;
                }
                j++;
                if (isVowel(s.charAt(i))) {
                    cnt--;
                }
                i++;
                maxCnt = Math.max(maxCnt, cnt);
            }
        }

        return maxCnt;
    }

    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxVowels("abciiidef", 3));
        System.out.println(solution.maxVowels("aeiou", 2));
        System.out.println(solution.maxVowels("leetcode", 3));
        System.out.println(solution.maxVowels("rhythms", 4));
        System.out.println(solution.maxVowels("tryhard", 4));
    }
}
