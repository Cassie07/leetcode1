/**
82. Remove Duplicates from Sorted List II
DescriptionHintsSubmissionsDiscussSolution
Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.

Example 1:

Input: 1->2->3->3->4->4->5
Output: 1->2->5
Example 2:

Input: 1->1->1->2->3
Output: 2->3

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
    public ListNode deleteDuplicates(ListNode head) {
        if (head==null){
            return null;
        }
        ListNode pre=new ListNode(0);
        pre.next=head;
        ListNode ret=pre;
        ListNode fast=head.next;
        ListNode slow=head;
        int or=head.val;
        int re=or-10;
        while(fast!=null){
            if(fast.val==slow.val){
                re=pre.next.val;
                pre.next=fast.next;
                if (pre.next==null){
                    return ret.next;
                }
                slow=pre.next;
                fast=slow.next;
            }else{
                if(slow.val==re){
                    pre.next=fast;
                    slow=fast;
                    fast=fast.next;
                }else{
                    pre=pre.next;
                    if(pre.next==null){
                        return ret.next;
                    }
                    slow=pre.next;
                    fast=slow.next;
                }
            }
        }
        if(slow.val==re){
            pre.next=fast;
        }
        return ret.next;
    }
}
