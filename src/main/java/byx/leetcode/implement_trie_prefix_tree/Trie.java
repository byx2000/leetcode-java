package byx.leetcode.implement_trie_prefix_tree;

// https://leetcode.cn/problems/implement-trie-prefix-tree/

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Trie {
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

    public boolean search(String word) {
        Node n = root;
        for (int i = 0; i < word.length(); i++) {
            int c = word.charAt(i) - 'a';
            if (n.chs[c] == null) {
                return false;
            }
            n = n.chs[c];
        }
        return n.isWord;
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

    @Test
    public void test() {
        Trie trie = new Trie();
        trie.insert("apple");
        assertTrue(trie.search("apple"));
        assertFalse(trie.search("app"));
        assertTrue(trie.startsWith("app"));
        trie.insert("app");
        assertTrue(trie.search("app"));
    }
}
