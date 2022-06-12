package byx.leetcode.n_queens;

// https://leetcode.cn/problems/n-queens/

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Solution {
    private int n;
    private List<List<String>> result;
    private char[][] board;

    public List<List<String>> solveNQueens(int n) {
        this.n = n;
        this.result = new ArrayList<>();

        board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }

        dfs(0);
        return result;
    }

    private void dfs(int row) {
        if (row == n) {
            result.add(boardToString(board));
            return;
        }

        for (int i = 0; i < n; i++) {
            board[row][i] = 'Q';
            if (checkCol(row, i) && checkLine(row, i)) {
                dfs(row + 1);
            }
            board[row][i] = '.';
        }
    }

    // 检查当前列上是否有其它皇后
    private boolean checkCol(int r, int c) {
        for (int i = 0; i < r; i++) {
            if (board[i][c] == 'Q') {
                return false;
            }
        }
        return true;
    }

    // 检查当前斜线上是否有其它皇后
    private boolean checkLine(int r, int c) {
        for (int i = 1; i <= r; i++) {
            if (c - i >= 0 && board[r - i][c - i] == 'Q') {
                return false;
            }
            if (c + i < n && board[r - i][c + i] == 'Q') {
                return false;
            }
        }
        return true;
    }

    private List<String> boardToString(char[][] board) {
        List<String> r = new ArrayList<>();
        for (char[] row : board) {
            StringBuilder sb = new StringBuilder();
            for (char c : row) {
                sb.append(c);
            }
            r.add(sb.toString());
        }
        return r;
    }

    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(Set.of(List.of("Q")), new HashSet<>(s.solveNQueens(1)));
        assertEquals(Set.of(
                List.of(".Q..","...Q","Q...","..Q."),
                List.of("..Q.","Q...","...Q",".Q..")
        ), new HashSet<>(s.solveNQueens(4)));
    }
}
