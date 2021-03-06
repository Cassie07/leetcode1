/**
83. Remove Duplicates from Sorted List
DescriptionHintsSubmissionsDiscussSolution
Given a sorted linked list, delete all duplicates such that each element appear only once.

Example 1:

Input: 1->1->2
Output: 1->2
Example 2:

Input: 1->1->2->3->3
Output: 1->2->3
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
        ListNode cur=head; /* cur and head are pointers*/
        while (cur!=null&&cur.next!=null){
            if (cur.val==cur.next.val){
                cur.next=cur.next.next;
            }else{
                cur=cur.next;
            }
        }  
        return head;
    }
}
