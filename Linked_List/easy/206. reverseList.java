/**
206. Reverse Linked List
DescriptionHintsSubmissionsDiscussSolution
Reverse a singly linked list.

Example:

Input: 1->2->3->4->5->NULL
Output: 5->4->3->2->1->NULL
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
    public ListNode reverseList(ListNode head) {
        ListNode pre=null; /** a pointer for reversing(connect the next field of current node to the node before it ) */
        ListNode tmp=head; /** a temporary pointer to update cur */
        ListNode cur=head; /** a pointer for current node*/
        while(cur!=null){
            tmp=cur.next; /** a memory space: update the cur pointer*/
            cur.next=pre; /** reverse: connected cur to its previouse node*/
            pre=cur; /** update pre*/
            cur=tmp; /** update cur*/
        }
        head=pre; /** update head: we should return a reversed linked list for the previouse linked list, thus we should change the position of head */
        return head;
    }
}
