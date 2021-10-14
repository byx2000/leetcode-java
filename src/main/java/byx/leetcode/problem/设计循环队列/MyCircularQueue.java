package byx.leetcode.problem.设计循环队列;

/**
 * https://leetcode-cn.com/problems/design-circular-queue/
 */
public class MyCircularQueue {
    private final int[] nums;
    private int front, tail;

    // 元素区间[front, tail)
    public MyCircularQueue(int k) {
        nums = new int[k + 1];
        front = tail = 0;
    }

    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        }

        nums[tail] = value;
        tail = (tail + 1) % nums.length;
        return true;
    }

    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }

        front = (front + 1) % nums.length;
        return true;
    }

    public int Front() {
        if (isEmpty()) {
            return -1;
        }
        return nums[front];
    }

    public int Rear() {
        if (isEmpty()) {
            return -1;
        }
        return nums[(tail + nums.length - 1) % nums.length];
    }

    public boolean isEmpty() {
        return front == tail;
    }

    public boolean isFull() {
        return (tail + 1) % nums.length == front;
    }
}
