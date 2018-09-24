/**
148. Sort List
DescriptionHintsSubmissionsDiscussSolution
Sort a linked list in O(n log n) time using constant space complexity.

Example 1:

Input: 4->2->1->3
Output: 1->2->3->4
Example 2:

Input: -1->5->3->4->0
Output: -1->0->3->4->5
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
    public ListNode sortList(ListNode head) {
        if(head==null||head.next==null){
            return head;
        }
        ListNode slow=head;
        ListNode pre=head;
        ListNode fast=head;
        while(fast!=null&&fast.next!=null){  // Please remember this method to find middle node 
            pre=slow;
            slow=slow.next;
            fast=fast.next.next;
        }
        pre.next=null;               // A sentinel for the first array
        ListNode l1=sortList(head);
        ListNode l2=sortList(slow);
        return Merge(l1,l2);     
    }

    public ListNode Merge(ListNode l1, ListNode l2){
    // ListNode a is the start of left array, ListNode mid is the end of the left array
    // ListNode mid.next is the start of the right array, ListNode end is the end of the right array
        ListNode ret=new ListNode(0);
        ListNode cur=ret;
        while(l1!=null&&l2!=null){   // trick here: we don't need to consider the node next to the current node(the smaller one).
            if(l1.val<l2.val){
                cur.next=l1;
                l1=l1.next;
            }else{
                cur.next=l2;
                l2=l2.next;
            }
            cur=cur.next;
        }
        if(l1==null){      // When one array arrive the sentinel(null is a sentinel), the rest sorted element be added automatically.
            cur.next=l2;
        }else{
            cur.next=l1;
        }
        return ret.next;
    }
}

