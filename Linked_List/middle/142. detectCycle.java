/**
142. Linked List Cycle II
DescriptionHintsSubmissionsDiscussSolution
Given a linked list, return the node where the cycle begins. If there is no cycle, return null.

Note: Do not modify the linked list.

Follow up:
Can you solve it without using extra space?

*/

// https://www.cnblogs.com/hiddenfox/p/3408931.html
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode slow=head;
        ListNode fast=head;
        while(fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast){
                ListNode slow2=head;
                while(slow2!=slow){
                    slow2=slow2.next;
                    slow=slow.next;
                }
                return slow;
            }
        }
        return null;
    }
}
