class LRUCache {

    class Node {
        int key, val;
        Node next, prev;

        Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    private int cap;
    HashMap<Integer, Node> map = new HashMap<>();
    Node head = new Node(-1, -1);
    Node tail = new Node(-1, -1);

    public LRUCache(int capacity) {
        this.cap = capacity;

        head.next = tail;
        tail.prev = head;
    }

    private void insertToHead(Node newNode) {
        newNode.next = head.next;
        newNode.prev = head;
        head.next.prev = newNode;
        head.next = newNode;
    }

    private void remove(Node newNode) {
        newNode.prev.next = newNode.next;
        newNode.next.prev = newNode.prev;
    }
    
    public int get(int key) {
        if(!map.containsKey(key)) {
            return -1;
        }

        Node newNode = map.get(key);
        remove(newNode);
        insertToHead(newNode);
        return newNode.val;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)) {
            Node newNode = map.get(key);
            newNode.val = value;
            remove(newNode);
            insertToHead(newNode);
        } else {
            Node newNode = new Node(key, value);
            map.put(key, newNode);
            insertToHead(newNode);

            if(map.size() > cap) {
                Node LRU = tail.prev;
                remove(LRU);
                map.remove(LRU.key);
            }
        }
    }
} 


/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */ 