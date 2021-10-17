package byx.leetcode.problem.LFU缓存;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * https://leetcode-cn.com/problems/lfu-cache/
 */
public class LFUCache {
    private class Node {
        int key;
        int value;
        long lastTime;
        long freq;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.lastTime = currentTime();
            this.freq = 1;
        }
    }

    private long time;
    private final int capacity;
    private final Map<Integer, Node> map;
    private final PriorityQueue<Node> pq = new PriorityQueue<>((n1, n2) -> {
        if (n1.freq == n2.freq) {
            return (int) (n1.lastTime - n2.lastTime);
        }
        return (int) (n1.freq - n2.freq);
    });

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>(capacity);
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.freq++;
            node.lastTime = currentTime();
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
            node.freq++;
            node.lastTime = currentTime();
            pq.remove(node);
            pq.add(node);
        } else if (map.size() < capacity) {
            Node node = new Node(key, value);
            map.put(key, node);
            pq.add(node);
        } else if (!map.isEmpty()) {
            Node node = pq.remove();
            map.remove(node.key);
            node.key = key;
            node.value = value;
            node.freq = 1;
            node.lastTime = currentTime();
            map.put(key, node);
            pq.add(node);
        }
    }

    private long currentTime() {
        return time++;
    }
}
