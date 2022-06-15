package byx.leetcode.short_encoding_of_words;

// https://leetcode.cn/problems/short-encoding-of-words/

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Solution {
    public int minimumLengthEncoding(String[] words) {
        // 将所有单词按照长度从大到小排序
        Arrays.sort(words, (a, b) -> b.length() - a.length());

        Trie trie = new Trie();
        int result = 0;

        // 如果单词倒序之后不在trie树的前缀中，则将该单词倒序插入trie树，并增加编码长度
        for (String word : words) {
            String rev = new StringBuilder(word).reverse().toString();
            if (!trie.startsWith(rev)) {
                result += word.length() + 1;
                trie.insert(rev);
            }
        }

        return result;
    }

    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(10, s.minimumLengthEncoding(new String[]{"time", "me", "bell"}));
        assertEquals(2, s.minimumLengthEncoding(new String[]{"t"}));
    }
}

class Trie {
    private static class Node {
        public Node[] chs = new Node[26];
        public boolean isWord = false;
    }

    private final Node root = new Node();

    public void insert(String word) {
        Node n = root;
        for (int i = 0; i < word.length(); i++) {
            int c = word.charAt(i) - 'a';
            if (n.chs[c] == null) {
                n.chs[c] = new Node();
            }
            n = n.chs[c];
        }
        n.isWord = true;
    }

    public boolean startsWith(String prefix) {
        Node n = root;
        for (int i = 0; i < prefix.length(); i++) {
            int c = prefix.charAt(i) - 'a';
            if (n.chs[c] == null) {
                return false;
            }
            n = n.chs[c];
        }
        return true;
    }
}
