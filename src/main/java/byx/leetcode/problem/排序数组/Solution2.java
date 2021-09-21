package byx.leetcode.problem.排序数组;

import java.util.Arrays;
import java.util.Random;
import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/sort-an-array/
 */
public class Solution2 {
    public int[] sortArray(int[] nums) {
        qsort(nums, 0, nums.length - 1);
        return nums;
    }

    private static final Random RANDOM = new Random();

    private static class Frame {
        int left, right, mid, state;
        Frame(int left, int right) {
            this.left = left;
            this.right = right;
            state = 0;
        }
    }

    private void qsort(int[] nums, int left, int right) {
        Stack<Frame> stack = new Stack<>();
        stack.push(new Frame(left, right));

        while (!stack.isEmpty()) {
            Frame cur = stack.peek();

            if (cur.left >= cur.right) {
                stack.pop();
                continue;
            }

            if (cur.state == 0) {
                cur.state = 1;
                cur.mid = partition(nums, cur.left, cur.right);
                stack.push(new Frame(cur.left, cur.mid - 1));
            } else if (cur.state == 1) {
                cur.state = 2;
                stack.push(new Frame(cur.mid + 1, cur.right));
            } else if (cur.state == 2) {
                stack.pop();
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    private int partition(int[] nums, int left, int right) {
        swap(nums, left, left + RANDOM.nextInt(right - left + 1));

        int i = left + 1, j = right;
        while (i <= j) {
            while (i <= j && nums[i] <= nums[left]) i++;
            while (i <= j && nums[j] > nums[left]) j--;
            if (i < j) {
                swap(nums, i, j);
            }
        }
        swap(nums, left, j);
        return j;
    }

    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        System.out.println(Arrays.toString(solution.sortArray(new int[]{5, 2, 3, 1})));
        System.out.println(Arrays.toString(solution.sortArray(new int[]{5,1,1,2,0,0})));
    }
}
