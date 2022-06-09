package byx.leetcode.design_add_and_search_words_data_structure;

// https://leetcode.cn/problems/design-add-and-search-words-data-structure/

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class WordDictionary {
    private static class Node {
        public Node[] chs = new Node[26];
        public boolean isWord = false;
    }

    private final Node root = new Node();

    public void addWord(String word) {
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

    private boolean search(String word, int index, Node n) {
        if (index == word.length()) {
            return n.isWord;
        }

        char c = word.charAt(index);
        if (c == '.') {
            for (Node next : n.chs) {
                if (next != null && search(word, index + 1, next)) {
                    return true;
                }
            }
            return false;
        } else {
            if (n.chs[c - 'a'] == null) {
                return false;
            }
            return search(word, index + 1, n.chs[c - 'a']);
        }
    }

    public boolean search(String word) {
        return search(word, 0, root);
    }

    @Test
    public void test() {
        WordDictionary dict = new WordDictionary();
        dict.addWord("bad");
        dict.addWord("dad");
        dict.addWord("mad");
        assertFalse(dict.search("pad"));
        assertTrue(dict.search("bad"));
        assertTrue(dict.search(".ad"));
        assertTrue(dict.search("b.."));
    }
}
