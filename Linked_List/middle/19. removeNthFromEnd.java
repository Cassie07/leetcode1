/**
19. Remove Nth Node From End of List
DescriptionHintsSubmissionsDiscussSolution
Given a linked list, remove the n-th node from the end of list and return its head.

Example:

Given linked list: 1->2->3->4->5, and n = 2.

After removing the second node from the end, the linked list becomes 1->2->3->5.
Note:

Given n will always be valid.
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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode c=head;
        int count=0;
        while(c!=null){
            count++;
            c=c.next;
        }
        int k=count-n;
        if(k==0){
            return head.next;
        }
        ListNode pre=new ListNode(0);
        pre.next=head;
        ListNode cur=head;
        while(k!=0){
            pre=pre.next;
            cur=pre.next;
            k--; 
        }
        pre.next=cur.next;
        return head;
    }
}

/** Find the nth node and connect its previous node with its next node(remove the nth node itself). */
