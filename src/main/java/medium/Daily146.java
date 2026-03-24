package medium;

import java.util.HashMap;
import java.util.Map;

public class Daily146 {

    class LRUCache {

        private int capacity;
        private Map<Integer, Node> map = new HashMap<>();
        private Node head = new Node(0, 0);
        private Node tail = new Node(0, 0);

        public LRUCache(int capacity) {
            this.capacity = capacity;
            head.next = tail;
            tail.prev = head;
        }

        public int get(int key) {
            if (map.containsKey(key)) {
                var node = map.get(key);
                moveToHead(node);
                return node.value;
            } else return -1;
        }


        public void put(int key, int value) {
            if (map.containsKey(key)) {
                var existing = map.get(key);
                existing.value = value;
                moveToHead(existing);
            } else {
                var node = new Node(key, value);
                map.put(key, node);
                addToHead(node);
                if(map.size() > capacity){
                    var last = tail.prev;
                    removeNode(last);
                    map.remove(last.key);
                }

            }
        }

        private void moveToHead(Node node) {
            removeNode(node);
            addToHead(node);
        }

        private void addToHead(Node node) {
            node.next = head.next;
            node.prev = head;
            head.next.prev = node;
            head.next = node;
        }

        private void removeNode(Node node) {
            var prev = node.prev;
            var next = node.next;
            prev.next = next;
            next.prev = prev;
        }

        class Node {
            int key;
            int value;
            Node prev;
            Node next;

            public Node(int key, int value) {
                this.key = key;
                this.value = value;
            }
        }
    }
}
