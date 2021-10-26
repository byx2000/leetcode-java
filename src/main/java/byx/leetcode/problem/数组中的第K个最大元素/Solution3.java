package byx.leetcode.problem.数组中的第K个最大元素;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/xx4gT2/
 */
public class Solution3 {
    private static class Heap {
        private final List<Integer> nums = new ArrayList<>(List.of(0));

        private void swap(int i, int j) {
            int t = nums.get(i);
            nums.set(i, nums.get(j));
            nums.set(j, t);
        }

        public void add(int val) {
            nums.add(val);
            int index = nums.size() - 1;

            while (index > 1) {
                int parent = index / 2;
                if (nums.get(index) < nums.get(parent)) {
                    swap(index, parent);
                    index = parent;
                } else {
                    break;
                }
            }
        }

        public int peek() {
            return nums.get(1);
        }

        public int remove() {
            int val = nums.get(1);
            swap(1, nums.size() - 1);
            nums.remove(nums.size() - 1);
            int index = 1;
            int size = nums.size() - 1;

            while (index <= size) {
                int c1 = index * 2, c2 = index * 2 + 1;
                if (c1 > size && c2 > size) {
                    break;
                } else if (c2 > size) {
                    if (nums.get(index) > nums.get(c1)) {
                        swap(index, c1);
                        index = c1;
                    } else {
                        break;
                    }
                } else {
                    if (nums.get(c1) < nums.get(c2)) {
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
            }

            return val;
        }

        public int size() {
            return nums.size() - 1;
        }
    }

    public int findKthLargest(int[] nums, int k) {
        Heap heap = new Heap();
        for (int n : nums) {
            heap.add(n);
            if (heap.size() > k) {
                heap.remove();
            }
        }
        return heap.peek();
    }
}
