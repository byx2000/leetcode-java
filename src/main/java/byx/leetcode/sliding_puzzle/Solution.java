package byx.leetcode.sliding_puzzle;

// https://leetcode.cn/problems/sliding-puzzle/

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Solution {
    public int slidingPuzzle(int[][] board) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(toHash(board));
        Set<Integer> visited = new HashSet<>();
        visited.add(toHash(board));
        int result = 0;

        while (!queue.isEmpty()) {
            int cnt = queue.size();
            for (int i = 0; i < cnt; i++) {
                int hash = queue.remove();
                if (hash == 123450) {
                    return result;
                }
                int[][] cur = toBoard(hash);

                if (moveLeft(cur)) {
                    int h = toHash(cur);
                    if (!visited.contains(h)) {
                        visited.add(h);
                        queue.add(h);
                    }
                    moveRight(cur);
                }

                if (moveRight(cur)) {
                    int h = toHash(cur);
                    if (!visited.contains(h)) {
                        visited.add(h);
                        queue.add(h);
                    }
                    moveLeft(cur);
                }

                if (moveUp(cur)) {
                    int h = toHash(cur);
                    if (!visited.contains(h)) {
                        visited.add(h);
                        queue.add(h);
                    }
                    moveDown(cur);
                }

                if (moveDown(cur)) {
                    int h = toHash(cur);
                    if (!visited.contains(h)) {
                        visited.add(h);
                        queue.add(h);
                    }
                    moveUp(cur);
                }
            }
            result++;
        }

        return -1;
    }

    private int toHash(int[][] board) {
        int r = 0;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                r = r * 10 + board[i][j];
            }
        }
        return r;
    }

    private int[][] toBoard(int hash) {
        return new int[][]{
                {hash / 100000, hash % 100000 / 10000, hash % 10000 / 1000},
                {hash % 1000 / 100, hash % 100 / 10, hash % 10}
        };
    }

    // 交换a[i][j]和a[m][n]
    private void swap(int[][] a, int i, int j, int m, int n) {
        int t = a[i][j];
        a[i][j] = a[m][n];
        a[m][n] = t;
    }

    // 将空格向左移动
    private boolean moveLeft(int[][] board) {
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == 0) {
                    if (j - 1 >= 0) {
                        swap(board, i, j, i, j - 1);
                        return true;
                    }
                    break;
                }
            }
        }
        return false;
    }

    // 将空格向右移动
    private boolean moveRight(int[][] board) {
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == 0) {
                    if (j + 1 < 3) {
                        swap(board, i, j, i, j + 1);
                        return true;
                    }
                    break;
                }
            }
        }
        return false;
    }

    // 将空格向上移动
    private boolean moveUp(int[][] board) {
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == 0) {
                    if (i - 1 >= 0) {
                        swap(board, i, j, i - 1, j);
                        return true;
                    }
                    break;
                }
            }
        }
        return false;
    }

    // 将空格向下移动
    private boolean moveDown(int[][] board) {
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == 0) {
                    if (i + 1 < 2) {
                        swap(board, i, j, i + 1, j);
                        return true;
                    }
                    break;
                }
            }
        }
        return false;
    }

    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(1, s.slidingPuzzle(new int[][]{
                {1, 2, 3},
                {4, 0, 5}
        }));
        assertEquals(-1, s.slidingPuzzle(new int[][]{
                {1, 2, 3},
                {5, 4, 0}
        }));
        assertEquals(5, s.slidingPuzzle(new int[][]{
                {4, 1, 2},
                {5, 0, 3}
        }));
    }
}
