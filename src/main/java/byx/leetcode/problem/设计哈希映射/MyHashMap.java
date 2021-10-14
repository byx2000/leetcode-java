package byx.leetcode.problem.设计哈希映射;

/**
 * https://leetcode-cn.com/problems/design-hashmap/
 */
public class MyHashMap {
    private static class Node {
        int key;
        int value;
        Node next;

        Node() {}

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }

        Node(int key, int value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    private static final int SIZE = 10000;
    private final Node[] nodes;

    public MyHashMap() {
        nodes = new Node[SIZE];
    }

    public void put(int key, int value) {
        Node node = new Node(key, value);
        int index = key % SIZE;

        if (nodes[index] == null) {
            nodes[index] = node;
        } else {
            // 查找key是否已存在，存在则更新value
            Node p = nodes[index];
            while (p != null) {
                if (p.key == key) {
                    p.value = value;
                    return;
                }
                p = p.next;
            }

            // 如果key不存在，则使用头插法插入键值对
            node.next = nodes[index];
            nodes[index] = node;
        }
    }

    public int get(int key) {
        int index = key % SIZE;
        if (nodes[index] == null) {
            return -1;
        }

        Node p = nodes[index];
        while (p != null) {
            if (p.key == key) {
                return p.value;
            }
            p = p.next;
        }

        return -1;
    }

    public void remove(int key) {
        int index = key % SIZE;

        if (nodes[index] == null) {
            return;
        }

        if (nodes[index].key == key) {
            nodes[index] = nodes[index].next;
            return;
        }

        Node p = nodes[index];
        while (p.next != null) {
            if (p.next.key == key) {
                p.next = p.next.next;
                return;
            }
            p = p.next;
        }
    }
}
