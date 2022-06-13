package byx.leetcode.nearest_exit_from_entrance_in_maze;

// https://leetcode.cn/problems/nearest-exit-from-entrance-in-maze/

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(entrance);
        maze[entrance[0]][entrance[1]] = '*'; // 使用'*'标记已搜索过的位置
        int result = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cur = queue.remove();
                int r = cur[0];
                int c = cur[1];

                // 到达出口
                if ((r == 0 || r == maze.length - 1 || c == 0 || c == maze[0].length - 1)
                        && !(r == entrance[0] && c == entrance[1])) {
                    return result;
                }

                addNext(maze, queue, r - 1, c);
                addNext(maze, queue, r + 1, c);
                addNext(maze, queue, r, c - 1);
                addNext(maze, queue, r, c + 1);
            }
            result++;
        }

        return -1;
    }

    private void addNext(char[][] maze, Queue<int[]> queue, int r, int c) {
        if (r < 0 || r >= maze.length || c < 0 || c >= maze[r].length || maze[r][c] != '.') {
            return;
        }
        maze[r][c] = '*';
        queue.add(new int[]{r, c});
    }

    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(1, s.nearestExit(new char[][]{
                {'+', '+', '.', '+'},
                {'.', '.', '.', '+'},
                {'+', '+', '+', '.'}
        }, new int[]{1, 2}));
        assertEquals(2, s.nearestExit(new char[][]{
                {'+', '+', '+'},
                {'.', '.', '.'},
                {'+', '+', '+'}
        }, new int[]{1, 0}));
        assertEquals(-1, s.nearestExit(new char[][]{
                {'.', '+'}
        }, new int[]{0, 0}));
    }
}
