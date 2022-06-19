package byx.leetcode.word_break;

// https://leetcode.cn/problems/word-break/

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Solution {
    private String s;
    private Set<String> words;
    private Boolean[] cache;

    public boolean wordBreak(String s, List<String> wordDict) {
        this.s = s;
        this.words = new HashSet<>(wordDict);
        this.cache = new Boolean[s.length()];
        return dp(s.length() - 1);
    }

    // s[0~index]能否被words中的单词拆分
    private boolean dp(int index) {
        if (index < 0) {
            return true;
        }

        if (cache[index] != null) {
            return cache[index];
        }

        for (int i = index; i >= 0; i--) {
            if (words.contains(s.substring(i, index + 1)) && dp(i - 1)) {
                return cache[index] = true;
            }
        }

        return cache[index] = false;
    }

    @Test
    public void test() {
        Solution s = new Solution();
        assertTrue(s.wordBreak("leetcode", List.of("leet", "code")));
        assertTrue(s.wordBreak("applepenapple", List.of("apple", "pen")));
        assertFalse(s.wordBreak("catsandog", List.of("cats", "dog", "sand", "and", "cat")));
    }
}
