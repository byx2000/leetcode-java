package byx.leetcode.problem.跳跃游戏;

/**
 * https://leetcode-cn.com/problems/jump-game/
 */
public class Solution1 {
    public boolean canJump(int[] nums) {
        return dfs(nums, new boolean[nums.length], 0);
    }

    private boolean dfs(int[] nums, boolean[] flag, int index) {
        if (index == nums.length - 1) {
            return true;
        }

        for (int step = 1; step <= nums[index]; ++step) {
            if (index + step < nums.length && !flag[index + step]) {
                flag[index + step] = true;
                if (dfs(nums, flag, index + step)) {
                    return true;
                }
                flag[index + step] = false;
            }

            if (index - step >= 0 && !flag[index - step]) {
                flag[index - step] = true;
                if (dfs(nums, flag, index - step)) {
                    return true;
                }
                flag[index - step] = false;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Solution1 solution = new Solution1();
        System.out.println(solution.canJump(new int[]{2, 3, 1, 1, 4}));
        System.out.println(solution.canJump(new int[]{3, 2, 1, 0, 4}));
        System.out.println(solution.canJump(new int[]{2,0,6,9,8,4,5,0,8,9,1,2,9,6,8,8,0,6,3,1,2,2,1,2,6,5,3,1,2,2,6,4,2,4,3,0,0,0,3,8,2,4,0,1,2,0,1,4,6,5,8,0,7,9,3,4,6,6,5,8,9,3,4,3,7,0,4,9,0,9,8,4,3,0,7,7,1,9,1,9,4,9,0,1,9,5,7,7,1,5,8,2,8,2,6,8,2,2,7,5,1,7,9,6}));
    }
}
