import java.util.HashMap;
import java.util.Map;

class LFUCache {

    private final int capacity;
    private int minFreq;

    // key -> node
    private final Map<Integer, Node> nodeMap;

    // frequency -> doubly linked list
    private final Map<Integer, DoublyLinkedList> freqMap;

    static class Node {
        int key;
        int value;
        int frequency;

        Node prev;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.frequency = 1;
        }
    }

    static class DoublyLinkedList {

        Node head;
        Node tail;
        int size;

        DoublyLinkedList() {
            head = new Node(0, 0);
            tail = new Node(0, 0);

            head.next = tail;
            tail.prev = head;
        }

        // Most recently used node is placed next to head
        void insertNextToHead(Node node) {
            node.next = head.next;
            node.prev = head;

            head.next.prev = node;
            head.next = node;

            size++;
        }

        void removeNode(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;

            size--;
        }

        // Least recently used node is present before tail
        Node removeLastNode() {
            if (size == 0) {
                return null;
            }

            Node lruNode = tail.prev;
            removeNode(lruNode);

            return lruNode;
        }
    }

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.minFreq = 0;

        nodeMap = new HashMap<>();
        freqMap = new HashMap<>();
    }

    public int get(int key) {

        if (!nodeMap.containsKey(key)) {
            return -1;
        }

        Node node = nodeMap.get(key);

        increaseFrequency(node);

        return node.value;
    }

    public void put(int key, int value) {

        if (capacity == 0) {
            return;
        }

        // Key already exists
        if (nodeMap.containsKey(key)) {
            Node node = nodeMap.get(key);

            node.value = value;
            increaseFrequency(node);

            return;
        }

        // Cache is full: remove LFU node
        if (nodeMap.size() == capacity) {

            DoublyLinkedList minFreqList = freqMap.get(minFreq);

            // Among same-frequency nodes, remove LRU
            Node nodeToRemove = minFreqList.removeLastNode();

            nodeMap.remove(nodeToRemove.key);
        }

        // New node always starts with frequency 1
        Node newNode = new Node(key, value);

        DoublyLinkedList frequencyOneList =
                freqMap.computeIfAbsent(
                        1,
                        frequency -> new DoublyLinkedList()
                );

        frequencyOneList.insertNextToHead(newNode);
        nodeMap.put(key, newNode);

        minFreq = 1;
    }

    private void increaseFrequency(Node node) {

        int oldFrequency = node.frequency;

        DoublyLinkedList oldFrequencyList =
                freqMap.get(oldFrequency);

        oldFrequencyList.removeNode(node);

        /*
         * If this node belonged to the minimum frequency
         * and its old list is now empty, minimum frequency increases.
         */
        if (oldFrequency == minFreq &&
                oldFrequencyList.size == 0) {

            minFreq++;
        }

        node.frequency++;

        DoublyLinkedList newFrequencyList =
                freqMap.computeIfAbsent(
                        node.frequency,
                        frequency -> new DoublyLinkedList()
                );

        // Node becomes MRU in its new frequency group
        newFrequencyList.insertNextToHead(node);
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */