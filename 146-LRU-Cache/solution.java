class DoubleLinkedListNode {
    public int key;
    public int val;
    public DoubleLinkedListNode pre;
    public DoubleLinkedListNode next;

    public DoubleLinkedListNode(int key, int val) {
        this.key = key;
        this.val = val;
    }
}


public class LRUCache {
    

    private HashMap<Integer, DoubleLinkedListNode> map = new HashMap<>();

    private DoubleLinkedListNode head;

    private DoubleLinkedListNode end;

    private int capacity;

    private int len;


    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.len = 0;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            DoubleLinkedListNode latest = map.get(key);
            removeNode(latest);
            setHead(latest);
            return latest.val;

        } else {
            return -1;
        }
    }

    public void set(int key, int value) {
        if (map.containsKey(key)) {
            DoubleLinkedListNode oldNode = map.get(key);
            oldNode.val = value;
            removeNode(oldNode);
            setHead(oldNode);
        } else {
            DoubleLinkedListNode newNode = new DoubleLinkedListNode(key, value);
            if (len < capacity) {
                setHead(newNode);
                map.put(key, newNode);
                len ++;
            } else {
                map.remove(end.key);
                end = end.pre;
                if (end != null) {
                    end.next = null;
                }
                
                setHead(newNode);
                map.put(key, newNode);
            }

        }
    }
    
    private void removeNode(DoubleLinkedListNode node) {
        DoubleLinkedListNode cur = node, pre = cur.pre, post = cur.next;

        if (pre != null) {
            pre.next = post;
        } else {
            head = post;
        }

        if (post != null) {
            post.pre = pre;
        } else {
            end = pre;
        }

    }

    private void setHead(DoubleLinkedListNode node) {
        node.next = head;
        node.pre = null;

        if (head != null) {
            head.pre = node;
        }

        head = node;

        if (end == null) {  // ??不太理解
            end = node;
        }

    }


}

