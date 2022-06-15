package byx.leetcode.search_suggestions_system;

// https://leetcode.cn/problems/search-suggestions-system/

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        // 将所有产品插入字典树
        Trie trie = new Trie();
        for (String p : products) {
            trie.insert(p);
        }

        Node n = trie.root;
        List<List<String>> result = new ArrayList<>();

        for (int i = 0; i < searchWord.length(); i++) {
            int c = searchWord.charAt(i) - 'a';
            if (n == null || n.chs[c] == null) {
                result.add(Collections.emptyList());
                n = null;
            } else {
                n = n.chs[c];
                ArrayList<String> list = new ArrayList<>(n.pq);
                list.sort(String::compareTo);
                result.add(list);
            }
        }

        return result;
    }

    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(List.of(
                List.of("mobile", "moneypot", "monitor"),
                List.of("mobile", "moneypot", "monitor"),
                List.of("mouse", "mousepad"),
                List.of("mouse", "mousepad"),
                List.of("mouse", "mousepad")
        ), s.suggestedProducts(new String[]{"mobile", "mouse", "moneypot", "monitor", "mousepad"}, "mouse"));
        assertEquals(List.of(
                List.of("havana"),
                List.of("havana"),
                List.of("havana"),
                List.of("havana"),
                List.of("havana"),
                List.of("havana")
        ), s.suggestedProducts(new String[]{"havana"}, "havana"));
        assertEquals(List.of(
                List.of("baggage", "bags", "banner"),
                List.of("baggage", "bags", "banner"),
                List.of("baggage", "bags"),
                List.of("bags")
        ), s.suggestedProducts(new String[]{"bags", "baggage", "banner", "box", "cloths"}, "bags"));
        assertEquals(List.of(
                List.of(),
                List.of(),
                List.of(),
                List.of(),
                List.of(),
                List.of(),
                List.of()
        ), s.suggestedProducts(new String[]{"havana"}, "tatiana"));
    }
}

class Node {
    public Node[] chs = new Node[26];
    public PriorityQueue<String> pq = new PriorityQueue<>(Comparator.reverseOrder());
}

class Trie {
    public final Node root = new Node();

    public void insert(String word) {
        Node n = root;
        for (int i = 0; i < word.length(); i++) {
            int c = word.charAt(i) - 'a';
            if (n.chs[c] == null) {
                n.chs[c] = new Node();
            }
            n = n.chs[c];

            n.pq.add(word);
            if (n.pq.size() > 3) {
                n.pq.remove();
            }
        }
    }
}
