
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

/*
3 pointers: 
p1 => l1
p2 => l2
p3 => new list

add every element in p1, p2=> get digit 
put (digit + carry) as the new node of p3


*/

public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) {
        	return l2;
        }
        if (l2 == null) {
        	return l1;
        }

        int carry = 0;
        ListNode p1, p2, p3, dummy;
        dummy = new ListNode(0);
        p3 = dummy;
        p1 = l1;
        p2 = l2;

        while (p1 != null || p2 != null) {
        	if (p1 != null) {
        		carry += p1.val;
        		p1 = p1.next;
        	}
        	if (p2 != null) {
        		carry += p2.val;
        		p2 = p2.next;
        	}

        	p3.next = new ListNode(carry % 10);
        	carry = carry / 10;

        	p3 = p3.next;
        }

        // take care with the last node
        if (carry == 1) {
        	p3.next = new ListNode(1);
        }

        return dummy.next;

    }
}