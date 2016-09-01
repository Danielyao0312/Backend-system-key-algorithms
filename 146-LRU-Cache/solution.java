/*
solution 1:  using LinkedHashMap!  取巧办法，linkedHashMap, 自带实现功能
*/

// public class LRUCache {
    
//     private Map<Integer, Integer> map;

//     public LRUCache(int capacity) {
//         map = new LinkedHashMap<Integer, Integer>(16, 0.75f, true) {
//             protected boolean removeEldestEntry(Map.Entry eldest) {
//                 return size() > capacity;
//             }
//         };
//     }

//     public int get(int key) {
//         return map.getOrDefault(key, -1);
//     }

//     public void set(int key, int value) {
//         map.put(key, value);
//     }

// }

/*
正规 solution:
double-linked list  +  hashmap
*/
public class LRUCache {

    private class Node {
        int key;
        int value;
        Node prev, next;
        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private int capacity;

    private Map<Integer, Node> map; // store <key, node>;

    private Node head;

    private Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        head = null;
        tail = null;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Node latest = map.get(key);
            moveToEnd(latest);
            return latest.value;
        } else {
            return -1;
        }
    }

    public void set(int key, int value) {
        if (!map.containsKey(key)) {  //if not exist, add a new node to end
            //if reach capacity:
            if (map.size() == capacity) {
                map.remove(head.key);
                remove(head);
            }
            Node newNode = new Node(key, value);
            map.put(key, newNode);
            addToEnd(newNode);

        } else {   // if exist, change its original value, then move to end
            Node latest = map.get(key);
            latest.value = value;
            moveToEnd(latest);
        }
    }

    private void moveToEnd(Node node) {   // 1. remove, 2. then add to end
        if (node == tail) {
            return;
        } else {
            remove(node);
            addToEnd(node);
        }
    }

    private void remove(Node node) {  // remove from the list
        Node pre = node.prev;
        Node post = node.next;

        if (node == head) {
            head = head.next;
            if (head != null) {
                head.prev = null;
            }
        } else if (node == tail) {
            tail = tail.prev;
            tail.next = null;
        } else {
            pre.next = post;
            post.prev = pre;
        }
    }

    private void addToEnd(Node node) {  // add to end of the list
        if (head == null) {
            head = node;
            tail = node;
        } else {
            node.prev = tail;
            tail.next = node;
            tail = node;
        }
    }

}

