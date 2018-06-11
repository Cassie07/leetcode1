/**
* 203. Remove Linked List Elements
* DescriptionHintsSubmissionsDiscussSolution
* Remove all elements from a linked list of integers that have value val.

* Example:

* Input:  1->2->6->3->4->5->6, val = 6
* Output: 1->2->3->4->5
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
    public ListNode removeElements(ListNode head, int val) {
        if(head==null){          /** if the linked list is empty, we can return it now and the algorithm will stop here.*/
            return head;
        }
        
        ListNode pre=head; /** a pointer for the previous element of the current element which we are checking now */
        ListNode cur=head.next; /** a pointer the current element that we are checking. */
        while (cur!=null && pre!=null){
            if (cur.val==val){     /** if the element is equal to the target element, we connent pre with cur.next*/
                pre.next=cur.next; /** (just like jump the current element) */
            }else{
                pre=pre.next; /** if not equal, we just move pre to pre.next*/
            }
            cur=cur.next;
        }
        if (head.val==val){    /** we do not check the first element before, thus we check it now before the return. */
            return head.next;
        }else{
            return head;
        }
    }
}
