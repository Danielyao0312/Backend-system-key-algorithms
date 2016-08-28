/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    
    // solution 1:  using priorityQueue
    // public ListNode mergeKLists(ListNode[] lists) {
    //     if (lists.length == 0) {
    //         return null;
    //     }
    //     if (lists.length == 1) {
    //         return lists[0];
    //     }
        
    //     PriorityQueue<ListNode> pq = new PriorityQueue<>(lists.length, new Comparator<ListNode>() {
    //         @Override
    //         public int compare(ListNode o1, ListNode o2) {
    //             return o1.val - o2.val;
    //         }
    //     });

    //     ListNode dummy = new ListNode(-1);
    //     ListNode p = dummy;

    //     // O(n * logn) : k is the maxLen of a sublist of lists, n is lists.length
    //     for (ListNode i : lists) {
    //         if (i != null) {
    //             pq.add(i);
    //         }
    //     }
        
    //     // O(n * k * logn)
    //     while (!pq.isEmpty()) {
    //         ListNode cur = pq.poll();
    //         p.next = cur;
    //         p = p.next;
    //         if (cur.next != null) {
    //             pq.add(cur.next);
    //         }
    //     }
        
    //     return dummy.next;
    // }
    
    // solution 2: using mergeSort
      public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        if (lists.length == 1) {
            return lists[0];
        }
        
        return mergeLists(lists, 0, lists.length - 1);
    }

    private ListNode mergeLists(ListNode[] lists, int i, int j) {
        if (i == j) {
            return lists[i];
        }

        int mid = (i + j) / 2;
        ListNode left = mergeLists(lists, i, mid);
        ListNode right = mergeLists(lists, mid + 1, j);

        return merge(left, right);
    }

    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                p.next = l1;
                l1 = l1.next;
                p = p.next;
            } else {
                p.next = l2;
                l2 = l2.next;
                p = p.next;
            }
        }
        if (l1 != null) {
            p.next = l1;
        } else {
            p.next = l2; 
        }

        return dummy.next;
    }
    
    
}