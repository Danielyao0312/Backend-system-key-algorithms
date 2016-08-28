/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        if (lists.length == 1) {
            return lists[0];
        }
        
        PriorityQueue<ListNode> pq = new PriorityQueue<>(lists.length, new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });

        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;

        for (ListNode i : lists) {
            if (i != null) {
                pq.add(i);
            }
        }

        while (!pq.isEmpty()) {
            ListNode cur = pq.poll();
            p.next = cur;
            p = p.next;
            if (cur.next != null) {
                pq.add(cur.next);
            }
        }
        
        return dummy.next;
    }
}