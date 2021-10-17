package byx.leetcode.problem.最近最少使用缓存;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * https://leetcode-cn.com/problems/OrIXps/
 */
public class LRUCache2 {
    private class Node {
        int key;
        int value;
        long time;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.time = currentTime();
        }
    }

    private long time;
    private final int capacity;
    private final Map<Integer, Node> map;
    private final PriorityQueue<Node> pq = new PriorityQueue<>((n1, n2) -> (int) (n1.time - n2.time));

    public LRUCache2(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>(capacity);
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.time = currentTime();
            pq.remove(node);
            pq.add(node);
            return node.value;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.value = value;
            node.time = currentTime();
            pq.remove(node);
            pq.add(node);
        } else {
            if (map.size() < capacity) {
                Node node = new Node(key, value);
                map.put(key, node);
                pq.add(node);
            } else {
                Node node = pq.remove();
                map.remove(node.key);
                node.key = key;
                node.value = value;
                node.time = currentTime();
                map.put(key, node);
                pq.add(node);
            }
        }
    }

    private long currentTime() {
        return time++;
    }
}
