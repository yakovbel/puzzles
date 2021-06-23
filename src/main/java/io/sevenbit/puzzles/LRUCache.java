package io.sevenbit.puzzles;

import java.util.HashMap;
import java.util.Map;

/**
 * Leetcode 146. LRU Cache
 */
class LRUCache {

    private final Map<Integer, Node> inner;
    private final int capacity;
    private Node first;
    private Node last;

    public LRUCache(int capacity) {
        if (capacity < 1) {
            throw new RuntimeException("capacity should be positive");
        }
        inner = new HashMap<>(capacity);
        this.capacity = capacity;
    }

    public int get(int key) {
        if (inner.containsKey(key)) {
            Node n = inner.get(key);
            moveToTheHead(n);
            System.out.println("get " + key);
            printList();
            return n.value;
        } else {
            return -1;
        }

    }

    private void moveToTheHead(Node n) {
        if(n == first) return;
        //remove old element
        if (n.prev != null) {
            n.prev.next = n.next; //[2,2] -> null
        }
        if (n.next != null) {
            n.next.prev = n.prev;
        } else {
            last = n.prev; //l:[2,2]
        }
        //insert to the beginning
        n.prev = null;
        n.next = first; //[1,1] -> [2,2] -> null
        first.prev = n; //
        first = n;
    }

    private void printList() {
        Node cur = first;
        var sb = new StringBuilder();
        while (cur != null) {
            sb.append(cur.value + "->");
            cur = cur.next;
        }
        System.out.println(sb.toString());
    }

    /*
    f,l:[1,1]
    [2,2],  f:[2,2]<->l:[1,1]
    read [1]
    */
    public void put(int key, int value) {
        Node n = inner.get(key);
        if (n != null) {
            n.value = value;
            moveToTheHead(n);
        } else {
            n = new Node(key, value, first, null);
            if (first != null) {
                first.prev = n;
                n.next = first;
            }
            first = n;

            inner.put(key, n);
            if (last == null) {
                last = n;
            }
        }


        if (inner.size() > capacity) {
            Node toRemove = last;
            last = last.prev;
            if (last != null) {
                last.next = null;
            }
            inner.remove(toRemove.key);
        }
        System.out.println("put:" + key + "->" + value);
        printList();
    }

    public class Node {
        int value;
        int key;
        Node next;
        Node prev;

        public Node(int key, int value, Node next, Node prev) {
            this.key = key;
            this.value = value;
            this.next = next;
            this.prev = prev;
        }
    }

    public static void main(String[] args) {
        var cache = new LRUCache(2);
        cache.put(2,1);
        cache.put(3,2);
        cache.get(3);
        cache.get(2);
        cache.put(4,3);
        cache.get(2);
        cache.get(3);
        cache.get(4);
    }
}

