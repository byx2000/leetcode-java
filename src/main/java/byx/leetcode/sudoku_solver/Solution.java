package byx.leetcode.sudoku_solver;

// https://leetcode.cn/problems/sudoku-solver/

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class Solution {
    public void solveSudoku(char[][] board) {
        dfs(board, 0);
    }

    private boolean dfs(char[][] board, int pos) {
        if (pos == 81) {
            return true;
        }

        int r = pos / 9;
        int c = pos % 9;

        if (board[r][c] != '.') {
            return dfs(board, pos + 1);
        }

        for (int i = 1; i <= 9; i++) {
            board[r][c] = (char) (i + '0');
            if (checkRow(board, r, c) && checkCol(board, r, c) && checkBox(board, r, c)) {
                if (dfs(board, pos + 1)) {
                    return true;
                }
            }
        }

        board[r][c] = '.';

        return false;
    }

    // 检查当前行是否有重复
    private boolean checkRow(char[][] board, int r, int c) {
        for (int i = 0; i < 9; i++) {
            if (i != c && board[r][i] == board[r][c]) {
                return false;
            }
        }
        return true;
    }

    // 检查当前列是否有重复
    private boolean checkCol(char[][] board, int r, int c) {
        for (int i = 0; i < 9; i++) {
            if (i != r && board[i][c] == board[r][c]) {
                return false;
            }
        }
        return true;
    }

    // 检查当前宫是否有重复
    private boolean checkBox(char[][] board, int r, int c) {
        // 计算(r, c)所在宫的左上角位置
        int r0 = r / 3 * 3;
        int c0 = c / 3 * 3;

        Set<Character> set = new HashSet<>();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                char d = board[r0 + i][c0 + j];
                if (d != '.' && set.contains(d)) {
                    return false;
                }
                set.add(d);
            }
        }

        return true;
    }

    @Test
    public void test() {
        Solution s = new Solution();

        char[][] board = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        s.solveSudoku(board);
        assertArrayEquals(new char[][]{
                {'5', '3', '4', '6', '7', '8', '9', '1', '2'},
                {'6', '7', '2', '1', '9', '5', '3', '4', '8'},
                {'1', '9', '8', '3', '4', '2', '5', '6', '7'},
                {'8', '5', '9', '7', '6', '1', '4', '2', '3'},
                {'4', '2', '6', '8', '5', '3', '7', '9', '1'},
                {'7', '1', '3', '9', '2', '4', '8', '5', '6'},
                {'9', '6', '1', '5', '3', '7', '2', '8', '4'},
                {'2', '8', '7', '4', '1', '9', '6', '3', '5'},
                {'3', '4', '5', '2', '8', '6', '1', '7', '9'}
        }, board);
    }
}
