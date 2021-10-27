package byx.leetcode.problem.单词拆分;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/word-break/
 */
public class Solution {
    private Boolean[] cache;

    public boolean wordBreak(String word, List<String> wordDict) {
        Set<String> dict = new HashSet<>(wordDict);
        cache = new Boolean[word.length()];
        return dp(word, dict, word.length() - 1);
    }

    // word[0]~word[index]是否可拆分
    private boolean dp(String word, Set<String> dict, int index) {
        if (cache[index] != null) {
            return cache[index];
        }

        if (dict.contains(word.substring(0, index + 1))) {
            return cache[index] = true;
        }

        for (int i = index; i >= 1; --i) {
            if (dict.contains(word.substring(i, index + 1)) && dp(word, dict, i - 1)) {
                return cache[index] = true;
            }
        }

        return cache[index] = false;
    }
}
