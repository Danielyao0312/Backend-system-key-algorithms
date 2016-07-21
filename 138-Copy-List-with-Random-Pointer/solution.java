/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
/*
1. copy nodes (create a hashmap<oldNode, newNode>)
2. copy pointers (next, random)
3. return map.get(head)

一次 bug free!!!!
*/

public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) {
        	return null;
        }

        HashMap<RandomListNode, RandomListNode> map = new HashMap<>();

        // copy nodes
        RandomListNode p = head;
        while (p != null) {
        	map.put(p, new RandomListNode(p.label));
        	p = p.next;
        }

        //copy pointers
        p = head;
        while (p != null) {
        	RandomListNode newNode = map.get(p);
        	newNode.next = map.get(p.next);
        	newNode.random = map.get(p.random);
        	p = p.next;
        }

        return map.get(head);

    }
}