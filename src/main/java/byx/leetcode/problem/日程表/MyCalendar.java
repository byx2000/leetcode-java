package byx.leetcode.problem.日程表;

import java.util.TreeSet;

/**
 * https://leetcode-cn.com/problems/fi9suh/
 */
public class MyCalendar {
    private static class Span {
        int start;
        int end;

        Span(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    private TreeSet<Span> set = new TreeSet<>((s1, s2) -> s1.start - s2.start);

    public MyCalendar() {

    }

    public boolean book(int start, int end) {
        Span span = new Span(start, end);
        Span floor = set.floor(span);
        Span ceiling = set.ceiling(span);

        if (floor == null && ceiling == null) {
            set.add(span);
            return true;
        } else if (floor == null) {
            if (end <= ceiling.start) {
                set.add(span);
                return true;
            } else {
                return false;
            }
        } else if (ceiling == null) {
            if (start >= floor.end) {
                set.add(span);
                return true;
            } else {
                return false;
            }
        } else {
            if (start >= floor.end && end <= ceiling.start) {
                set.add(span);
                return true;
            } else {
                return false;
            }
        }
    }
}
