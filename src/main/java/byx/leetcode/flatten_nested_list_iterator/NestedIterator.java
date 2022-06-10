package byx.leetcode.flatten_nested_list_iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// https://leetcode.cn/problems/flatten-nested-list-iterator/

public class NestedIterator implements Iterator<Integer> {
    private final List<Integer> nums = new ArrayList<>();
    private int index = 0;

    public NestedIterator(List<NestedInteger> nestedList) {
        nestedList.forEach(this::dfs);
    }

    private void dfs(NestedInteger node) {
        if (node.isInteger()) {
            nums.add(node.getInteger());
            return;
        }
        node.getList().forEach(this::dfs);
    }

    @Override
    public Integer next() {
        return nums.get(index++);
    }

    @Override
    public boolean hasNext() {
        return index < nums.size();
    }
}
