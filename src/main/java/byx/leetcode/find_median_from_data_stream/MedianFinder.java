package byx.leetcode.find_median_from_data_stream;

// https://leetcode.cn/problems/find-median-from-data-stream/

import org.junit.jupiter.api.Test;

import java.util.PriorityQueue;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MedianFinder {
    private final PriorityQueue<Integer> min = new PriorityQueue<>((a, b) -> b - a);
    private final PriorityQueue<Integer> max = new PriorityQueue<>();

    public void addNum(int num) {
        if (min.size() == max.size()) {
            if (min.isEmpty() || num < max.peek()) {
                min.add(num);
            } else {
                min.add(max.remove());
                max.add(num);
            }
        } else {
            if (num > min.peek()) {
                max.add(num);
            } else {
                max.add(min.remove());
                min.add(num);
            }
        }
    }

    public double findMedian() {
        if (min.size() == max.size()) {
            return (min.peek() + max.peek()) / 2.0;
        } else {
            return min.peek();
        }
    }

    @Test
    public void test() {
        MedianFinder finder = new MedianFinder();
        finder.addNum(1);
        finder.addNum(2);
        assertEquals(1.5, finder.findMedian());
        finder.addNum(3);
        assertEquals(2, finder.findMedian());
    }
}
