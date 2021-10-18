package byx.leetcode.problem.单词距离;

/**
 * https://leetcode-cn.com/problems/find-closest-lcci/
 */
public class Solution {
    public int findClosest(String[] words, String word1, String word2) {
        int i = 0, j = 0;
        int minDis = Integer.MAX_VALUE;

        while (true) {
            while (i < words.length && !word1.equals(words[i])) {
                i++;
            }
            while (j < words.length && !word2.equals(words[j])) {
                j++;
            }

            if (i == words.length || j == words.length) {
                break;
            }

            minDis = Math.min(minDis, Math.abs(i - j));

            if (i < j) {
                i++;
            } else {
                j++;
            }
        }

        return minDis;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findClosest(new String[]{"I", "am", "a", "student", "from", "a", "university", "in", "a", "city"}, "a", "student"));
    }
}
