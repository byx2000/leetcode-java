package byx.leetcode.palindrome_partitioning;

// https://leetcode.cn/problems/palindrome-partitioning/

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Solution {
    private Boolean[][] cache;

    public List<List<String>> partition(String s) {
        cache = new Boolean[s.length()][s.length()];
        List<List<String>> result = new ArrayList<>();
        dfs(s, 0, new LinkedList<>(), result);
        return result;
    }

    // 判断s[i~j]是否为回文串
    private boolean isPalindrome(String s, int i, int j) {
        if (cache[i][j] != null) {
            return cache[i][j];
        }

        if (i == j) {
            return cache[i][j] = true;
        }

        if (i + 1 == j) {
            return cache[i][j] = s.charAt(i) == s.charAt(j);
        }

        return cache[i][j] = s.charAt(i) == s.charAt(j) && isPalindrome(s, i + 1, j - 1);
    }

    /**
     * 从s[index]开始划分
     * @param s      待划分字符串
     * @param index  开始划分的索引
     * @param path   保存当前划分方案
     * @param result 保存所有划分方案
     */
    private void dfs(String s, int index, LinkedList<String> path, List<List<String>> result) {
        if (index == s.length()) {
            result.add(new ArrayList<>(path));
            return;
        }

        // 划分成s[index~i]和s[i+1~len-1]
        for (int i = index; i < s.length(); i++) {
            if (isPalindrome(s, index, i)) {
                path.addLast(s.substring(index, i + 1));
                dfs(s, i + 1, path, result);
                path.removeLast();
            }
        }
    }

    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(Set.of(
                List.of("a", "a", "b"),
                List.of("aa", "b")
        ), new HashSet<>(s.partition("aab")));
        assertEquals(Set.of(
                List.of("a")
        ), new HashSet<>(s.partition("a")));
    }
}
