package byx.leetcode.problem.排序数组;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/sort-an-array/
 */
public class Solution3 {
    public int[] sortArray(int[] nums) {
        int[] heap = new int[nums.length + 1];
        int size = 0;

        for (int n : nums) {
            insert(heap, size, n);
            size++;
        }

        for (int i = 0; i < nums.length; ++i) {
            nums[i] = remove(heap, size);
            size--;
        }

        return nums;
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    private void insert(int[] heap, int size, int val) {
        heap[size + 1] = val;
        int index = size + 1;

        while (true) {
            int parent = index / 2;
            if (parent >= 1 && heap[index] < heap[parent]) {
                swap(heap, index, parent);
                index = parent;
            } else {
                break;
            }
        }
    }

    private int remove(int[] heap, int size) {
        int val = heap[1];
        swap(heap, 1, size);

        int index = 1;
        while (true) {
            int c1 = 2 * index;
            int c2 = 2 * index + 1;

            if (c1 >= size && c2 >= size) {
                break;
            }

            if (c2 >= size || heap[c1] < heap[c2]) {
                if (heap[index] > heap[c1]) {
                    swap(heap, index, c1);
                    index = c1;
                } else {
                    break;
                }
            } else {
                if (heap[index] > heap[c2]) {
                    swap(heap, index, c2);
                    index = c2;
                } else {
                    break;
                }
            }
        }

        return val;
    }

    public static void main(String[] args) {
        Solution3 solution = new Solution3();
        System.out.println(Arrays.toString(solution.sortArray(new int[]{5, 2, 3, 1})));
        System.out.println(Arrays.toString(solution.sortArray(new int[]{5,1,1,2,0,0})));
    }
}
