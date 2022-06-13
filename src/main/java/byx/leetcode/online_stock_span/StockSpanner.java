package byx.leetcode.online_stock_span;

// https://leetcode.cn/problems/online-stock-span/

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StockSpanner {
    // 存储每天的股票价格
    private final List<Integer> prices = new ArrayList<>();

    // dp[i]表示prices[i]左边大于prices[i]的第一个元素下标
    private final List<Integer> dp = new ArrayList<>();

    public StockSpanner() {

    }

    public int next(int price) {
        prices.add(price);
        int i = dp.size() - 1;
        while (i != -1 && prices.get(i) <= price) {
            i = dp.get(i);
        }
        dp.add(i);
        return prices.size() - 1 - i;
    }

    @Test
    public void test() {
        StockSpanner s = new StockSpanner();
        assertEquals(1, s.next(100));
        assertEquals(1, s.next(80));
        assertEquals(1, s.next(60));
        assertEquals(2, s.next(70));
        assertEquals(1, s.next(60));
        assertEquals(4, s.next(75));
        assertEquals(6, s.next(85));
    }
}
