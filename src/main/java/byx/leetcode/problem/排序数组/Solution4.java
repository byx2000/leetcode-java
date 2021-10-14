package byx.leetcode.problem.排序数组;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/sort-an-array/
 */
public class Solution4 {
    private static class Heap {
        private final List<Integer> nums = new ArrayList<>();

        public Heap() {
            nums.add(0);
        }

        private void swap(int i, int j) {
            int t = nums.get(i);
            nums.set(i, nums.get(j));
            nums.set(j, t);
        }

        public void add(int val) {
            nums.add(val);
            int index = nums.size() - 1;

            while (true) {
                int parent = index / 2;
                if (parent >= 1 && nums.get(index) < nums.get(parent)) {
                    swap(index, parent);
                    index = parent;
                } else {
                    break;
                }
            }
        }

        public int remove() {
            int val = nums.get(1);
            swap(1, nums.size() - 1);
            nums.remove(nums.size() - 1);
            int size = nums.size() - 1;
            int index = 1;

            while (true) {
                int c1 = index * 2;
                int c2 = index * 2 + 1;

                if (c1 > size && c2 > size) {
                    break;
                }

                if (c2 > size || nums.get(c1) < nums.get(c2)) {
                    if (nums.get(index) > nums.get(c1)) {
                        swap(index, c1);
                        index = c1;
                    } else {
                        break;
                    }
                } else {
                    if (nums.get(index) > nums.get(c2)) {
                        swap(index, c2);
                        index = c2;
                    } else {
                        break;
                    }
                }
            }

            return val;
        }
    }

    public int[] sortArray(int[] nums) {
        Heap heap = new Heap();

        for (int n : nums) {
            heap.add(n);
        }

        for (int i = 0; i < nums.length; ++i) {
            nums[i] = heap.remove();
        }

        return nums;
    }

    public static void main(String[] args) {
        Solution4 solution = new Solution4();
        System.out.println(Arrays.toString(solution.sortArray(new int[]{5, 2, 3, 1})));
        System.out.println(Arrays.toString(solution.sortArray(new int[]{5,1,1,2,0,0})));
    }
}
