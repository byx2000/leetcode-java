package byx.leetcode.word_ladder_ii;

// https://leetcode.cn/problems/word-ladder-ii/

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> words = new HashSet<>(wordList);

        if (!words.contains(endWord)) {
            return Collections.emptyList();
        }

        Queue<List<String>> queue = new LinkedList<>();
        queue.add(List.of(beginWord));
        Set<List<String>> visited = new HashSet<>();
        visited.add(List.of(beginWord));
        List<List<String>> result = new ArrayList<>();
        boolean find = false;

        while (!find && !queue.isEmpty()) {
            //System.out.println(queue);
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                List<String> cur = queue.remove();
                String last = cur.get(cur.size() - 1);

                // 达到目标状态
                if (last.equals(endWord)) {
                    find = true;
                    result.add(cur);
                    continue;
                }

                char[] chs = last.toCharArray();
                for (int j = 0; j < chs.length; j++) {
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (chs[j] == c) {
                            continue;
                        }
                        char old = chs[j];
                        chs[j] = c;
                        String next = String.valueOf(chs);
                        List<String> path = new ArrayList<>(cur);
                        path.add(next);
                        if (words.contains(next) && (!visited.contains(path) || next.equals(endWord))) {
                            visited.add(path);
                            queue.add(path);
                        }
                        chs[j] = old;
                    }
                }
            }
        }

        return result;
    }

    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(Set.of(
                List.of("hit", "hot", "dot", "dog", "cog"),
                List.of("hit", "hot", "lot", "log", "cog")
        ), new HashSet<>(s.findLadders("hit", "cog", List.of("hot", "dot", "dog", "lot", "log", "cog"))));
        assertEquals(Set.of(), new HashSet<>(s.findLadders("hit", "cog", List.of("hot", "dot", "dog", "lot", "log"))));
        assertEquals(Set.of(
                List.of("red", "ted", "tad", "tax"),
                List.of("red", "ted", "tex", "tax"),
                List.of("red", "rex", "tex", "tax")
        ), new HashSet<>(s.findLadders("red", "tax", List.of("ted", "tex", "red", "tax", "tad", "den", "rex", "pee"))));
    }
}
