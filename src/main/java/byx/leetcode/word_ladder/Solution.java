package byx.leetcode.word_ladder;

// https://leetcode.cn/problems/word-ladder/

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> words = new HashSet<>(wordList);
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);
        int result = 1;

        while (!queue.isEmpty()) {
            int cnt = queue.size();
            for (int i = 0; i < cnt; i++) {
                String cur = queue.remove();

                if (cur.equals(endWord)) {
                    return result;
                }

                // 尝试改变cur的一个字符，如果修改后的单词在字典里，则继续搜索
                char[] chs = cur.toCharArray();
                for (int j = 0; j < chs.length; j++) {
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (chs[j] == c) {
                            continue;
                        }
                        char old = chs[j];
                        chs[j] = c;
                        String next = String.valueOf(chs);
                        if (words.contains(next) && !visited.contains(next)) {
                            visited.add(next);
                            queue.add(next);
                        }
                        chs[j] = old;
                    }
                }
            }
            result++;
        }

        return 0;
    }

    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(5, s.ladderLength("hit", "cog", List.of("hot", "dot", "dog", "lot", "log", "cog")));
        assertEquals(0, s.ladderLength("hit", "cog", List.of("hot", "dot", "dog", "lot", "log")));
    }
}
