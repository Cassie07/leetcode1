/**
Given a linked list, swap every two adjacent nodes and return its head.

Example:

Given 1->2->3->4, you should return the list as 2->1->4->3.
Note:

Your algorithm should use only constant extra space.
You may not modify the values in the list's nodes, only nodes itself may be changed.
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode first=head;
        ListNode second=head; 
        ListNode ret=new ListNode(0);     // this is a neccessary node before we do reversing.
        ret.next=head;
        ListNode pre=ret;
        if(head==null){
            return null;
        }
        if(head.next==null){
            return head;
        }
        while(first!=null){        
            second=first.next;      
            if(second==null){        // when the number of node in list is odd. The node cannot consist pair with other node
                return ret.next;     // do not need to reverse
            }
            first.next=second.next; // connect the first node to the third node
            second.next=first;      // connect the second node to the first node
            pre.next=second;        // connect the node before the first node to the second node
            pre=first;
            first=first.next;
        }
        return ret.next;
    }
}
