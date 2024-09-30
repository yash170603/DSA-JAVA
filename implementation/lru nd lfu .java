import java.util.HashMap;

class LRUCache {
    private HashMap<Integer, Node> map;
    private int capacity;
    private Node head, tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        } else {
            Node curr = map.get(key);
            remove(curr);
            insert(curr);
            return curr.value;
        }
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            remove(map.get(key));
            map.remove(key);
        }
        if (map.size() == capacity) {
            Node toRemove = tail.prev;
            remove(toRemove);
            map.remove(toRemove.key);
        }
        Node newNode = new Node(key, value);
        insert(newNode);
        map.put(key, newNode);
    }

    private void insert(Node node) {
        node.next = head.next;
        head.next.prev = node;
        node.prev = head;
        head.next = node;
    }

    private void remove(Node node) {
        if (node != null) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
    }

    private class Node {
        int key;
        int value;
        Node next;
        Node prev;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}




import java.util.*;

class LFUCache {
    private final int capacity;
    private int minFrequency;
    private final Map<Integer, Node> cache; // key to node
    private final Map<Integer, LinkedHashSet<Node>> frequencyMap; // frequency to nodes

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.minFrequency = 0;
        this.cache = new HashMap<>();
        this.frequencyMap = new HashMap<>();
    }

    public int get(int key) {
        if (!cache.containsKey(key)) {
            return -1;
        }
        Node node = cache.get(key);
        updateFrequency(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (capacity == 0) return;
        
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            node.value = value;
            updateFrequency(node);
        } else {
            if (cache.size() == capacity) {
                removeLeastFrequent();
            }
            Node newNode = new Node(key, value);
            cache.put(key, newNode);
            frequencyMap.computeIfAbsent(1, k -> new LinkedHashSet<>()).add(newNode);
            minFrequency = 1;
        }
    }

    private void updateFrequency(Node node) {
        int freq = node.frequency;
        frequencyMap.get(freq).remove(node);
        if (frequencyMap.get(freq).isEmpty()) {
            if (freq == minFrequency) {
                minFrequency++;
            }
            frequencyMap.remove(freq);
        }
        node.frequency++;
        frequencyMap.computeIfAbsent(node.frequency, k -> new LinkedHashSet<>()).add(node);
    }

    private void removeLeastFrequent() {
        LinkedHashSet<Node> nodes = frequencyMap.get(minFrequency);
        Node node = nodes.iterator().next();
        nodes.remove(node);
        if (nodes.isEmpty()) {
            frequencyMap.remove(minFrequency);
        }
        cache.remove(node.key);
    }

    class Node {
        int key, value;
        int frequency;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.frequency = 1;
        }
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key, value);
 */
