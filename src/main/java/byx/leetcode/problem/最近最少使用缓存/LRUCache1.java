package byx.leetcode.problem.最近最少使用缓存;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/OrIXps/
 */
public class LRUCache1 {
    private static class Node {
        int key;
        int value;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private final LinkedList<Node> nodes = new LinkedList<>();
    private final Map<Integer, Node> map = new HashMap<>();
    private final int capacity;

    public LRUCache1(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }

        Node n = map.get(key);
        moveToHead(n);

        return n.value;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node n = map.get(key);
            n.value = value;
            moveToHead(n);
        } else if (map.size() < capacity) {
            Node n = new Node(key, value);
            nodes.addFirst(n);
            map.put(key, n);
        } else {
            Node n = nodes.getLast();
            map.remove(n.key);
            n.key = key;
            n.value = value;
            map.put(key, n);
            moveToHead(n);
        }
    }

    private void moveToHead(Node n) {
        nodes.remove(n);
        nodes.addFirst(n);
    }
}
