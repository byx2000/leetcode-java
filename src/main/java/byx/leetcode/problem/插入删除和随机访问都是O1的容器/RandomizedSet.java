package byx.leetcode.problem.插入删除和随机访问都是O1的容器;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/FortPu/
 */
class RandomizedSet {
    private final List<Integer> nums = new ArrayList<>();
    private final Map<Integer, Integer> indexs = new HashMap<>();
    private final static Random random = new Random();

    /** Initialize your data structure here. */
    public RandomizedSet() {

    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (indexs.containsKey(val)) {
            return false;
        }

        indexs.put(val, nums.size());
        nums.add(val);
        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!indexs.containsKey(val)) {
            return false;
        }

        int index = indexs.get(val);
        indexs.put(nums.get(nums.size() - 1), index);
        indexs.remove(val);

        int t = nums.get(nums.size() - 1);
        nums.set(nums.size() - 1, nums.get(index));
        nums.set(index, t);
        nums.remove(nums.size() - 1);
        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        return nums.get(random.nextInt(nums.size()));
    }
}
