package byx.leetcode.problem.单词搜索II;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/word-search-ii/
 */
public class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> result = new ArrayList<>();
        for (String word : words) {
            if (exist(board, word)) {
                result.add(word);
            }
        }
        return result;
    }

    private boolean exist(char[][] board, String word) {
        for (int r = 0; r < board.length; ++r) {
            for (int c = 0; c < board[r].length; ++c) {
                boolean[][] flag = new boolean[board.length][board[0].length];
                if (dfs(board, word, flag, r, c, 0)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean dfs(char[][] board, String word, boolean[][] flag, int r, int c, int index) {
        if (index == word.length()) {
            return true;
        }

        if (r < 0 || r >= board.length) {
            return false;
        }

        if (c < 0 || c >= board[0].length) {
            return false;
        }

        if (flag[r][c]) {
            return false;
        }

        if (board[r][c] != word.charAt(index)) {
            return false;
        }

        flag[r][c] = true;

        if (dfs(board, word, flag, r - 1, c, index + 1)) {
            return true;
        }

        if (dfs(board, word, flag, r + 1, c, index + 1)) {
            return true;
        }

        if (dfs(board, word, flag, r, c - 1, index + 1)) {
            return true;
        }

        if (dfs(board, word, flag, r, c + 1, index + 1)) {
            return true;
        }

        flag[r][c] = false;

        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findWords(new char[][]{{'o', 'a', 'a', 'n'}, {'e', 't', 'a', 'e'}, {'i', 'h', 'k', 'r'}, {'i', 'f', 'l', 'v'}}, new String[]{"oath", "pea", "eat", "rain"}));
        System.out.println(solution.findWords(new char[][]{{'a', 'b'}, {'c', 'd'}}, new String[]{"abcb"}));
    }
}
