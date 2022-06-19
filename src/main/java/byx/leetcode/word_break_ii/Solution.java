package byx.leetcode.word_break_ii;

// https://leetcode.cn/problems/word-break-ii/

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Solution {
    private String s;
    private Set<String> words;
    private LinkedList<String> path;
    private List<String> result;

    public List<String> wordBreak(String s, List<String> wordDict) {
        this.s = s;
        this.words = new HashSet<>(wordDict);
        this.path = new LinkedList<>();
        this.result = new ArrayList<>();
        dfs(0);
        return result;
    }

    private void dfs(int index) {
        if (index == s.length()) {
            result.add(String.join(" ", path));
            return;
        }

        for (int i = index; i < s.length(); i++) {
            String sub = s.substring(index, i + 1);
            if (words.contains(sub)) {
                path.add(sub);
                dfs(i + 1);
                path.removeLast();
            }
        }
    }

    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(Set.of("cats and dog", "cat sand dog"), new HashSet<>(s.wordBreak("catsanddog", List.of("cat", "cats", "and", "sand", "dog"))));
        assertEquals(Set.of("pine apple pen apple", "pineapple pen apple", "pine applepen apple"), new HashSet<>(s.wordBreak("pineapplepenapple", List.of("apple", "pen", "applepen", "pine", "pineapple"))));
        assertEquals(Set.of(), new HashSet<>(s.wordBreak("catsandog", List.of("cats", "dog", "sand", "and", "cat"))));
    }
}
