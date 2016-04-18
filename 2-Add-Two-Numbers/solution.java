/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
 /*
 这道题就是给的加数是倒着给的，你返回的结果也是倒着写的，所以进位也反着进就好。
 维护一个carry，加数大于9时候carry为1，也要注意两个数相加如果大于8的话，要写取模后的值。
 */
 public class Solution{
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1==null)
            return l2;
        if(l2==null)
            return l1;
        
        int carry = 0;
        ListNode dummy = new ListNode(-1);
        ListNode l3 = dummy;
        
        while(l1!=null || l2!=null){
            if(l1!=null){
                carry += l1.val;
                l1 = l1.next;
            }
            if(l2!=null){
                carry += l2.val;
                l2 = l2.next;
            }
            
            l3.next = new ListNode(carry % 10);
            carry = carry/10;
            l3 = l3.next;
        }
        // check carry for the last node
        if(carry == 1) 
            l3.next=new ListNode(1);
        return dummy.next;
    } 
 }
 