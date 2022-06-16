package byx.leetcode.video_stitching;

// https://leetcode.cn/problems/video-stitching/

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Solution {
    public int videoStitching(int[][] clips, int time) {
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();

        // 放入左端点为0的片段
        for (int i = 0; i < clips.length; i++) {
            if (clips[i][0] == 0) {
                queue.add(i);
                visited.add(i);
            }
        }

        int result = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cur = clips[queue.remove()];

                // 到达终点
                if (cur[1] >= time) {
                    return result;
                }

                // 向队列中添加所有与cur相交的片段
                for (int j = 0; j < clips.length; j++) {
                    if (cur[1] >= clips[j][0] && !visited.contains(j)) {
                        queue.add(j);
                        visited.add(j);
                    }
                }
            }
            result++;
        }

        return -1;
    }

    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(3, s.videoStitching(new int[][]{{0, 2}, {4, 6}, {8, 10}, {1, 9}, {1, 5}, {5, 9}}, 10));
        assertEquals(-1, s.videoStitching(new int[][]{{0, 1}, {1, 2}}, 5));
        assertEquals(3, s.videoStitching(new int[][]{{0, 1}, {6, 8}, {0, 2}, {5, 6}, {0, 4}, {0, 3}, {6, 7}, {1, 3}, {4, 7}, {1, 4}, {2, 5}, {2, 6}, {3, 4}, {4, 5}, {5, 7}, {6, 9}}, 9));
    }
}
