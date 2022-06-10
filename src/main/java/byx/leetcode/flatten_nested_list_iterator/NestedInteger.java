package byx.leetcode.flatten_nested_list_iterator;

import java.util.List;

public interface NestedInteger {
    boolean isInteger();
    Integer getInteger();
    List<NestedInteger> getList();

    class IntegerNode implements NestedInteger {
        private final int value;

        public IntegerNode(int value) {
            this.value = value;
        }

        @Override
        public boolean isInteger() {
            return true;
        }

        @Override
        public Integer getInteger() {
            return value;
        }

        @Override
        public List<NestedInteger> getList() {
            throw new UnsupportedOperationException("not list");
        }
    }

    class ListNode implements NestedInteger {
        private final List<NestedInteger> list;

        public ListNode(List<NestedInteger> list) {
            this.list = list;
        }

        @Override
        public boolean isInteger() {
            return false;
        }

        @Override
        public Integer getInteger() {
            throw new UnsupportedOperationException("not integer");
        }

        @Override
        public List<NestedInteger> getList() {
            return list;
        }
    }
}
