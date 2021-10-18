package byx.leetcode.problem.单词接龙;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/word-ladder/
 */
public class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<Integer> book = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < wordList.size(); ++i) {
            if (match(beginWord, wordList.get(i))) {
                queue.add(i);
                book.add(i);
            }
        }

        int result = 2;
        while (!queue.isEmpty()) {
            int cnt = queue.size();
            while (cnt-- > 0) {
                int index = queue.remove();
                String s = wordList.get(index);
                if (s.equals(endWord)) {
                    return result;
                }

                for (int i = 0; i < wordList.size(); ++i) {
                    if (!book.contains(i) && match(s, wordList.get(i))) {
                        queue.add(i);
                        book.add(i);
                    }
                }
            }
            result++;
        }

        return 0;
    }

    private boolean match(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }

        int cnt = 0;
        for (int i = 0; i < s1.length(); ++i) {
            if (s1.charAt(i) != s2.charAt(i)) {
                if (cnt > 0) {
                    return false;
                }
                cnt++;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.ladderLength("hit", "cog", List.of("hot", "dot", "dog", "lot", "log", "cog")));
        System.out.println(solution.ladderLength("hit", "cog", List.of("hot", "dot", "dog", "lot", "log")));
    }
}
