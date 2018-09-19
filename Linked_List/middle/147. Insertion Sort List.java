/**
147. Insertion Sort List
DescriptionHintsSubmissionsDiscussSolution
Sort a linked list using insertion sort.


A graphical example of insertion sort. The partial sorted list (black) initially contains only the first element in the list.
With each iteration one element (red) is removed from the input data and inserted in-place into the sorted list
 

Algorithm of Insertion Sort:

Insertion sort iterates, consuming one input element each repetition, and growing a sorted output list.
At each iteration, insertion sort removes one element from the input data, finds the location it belongs within the sorted list, and inserts it there.
It repeats until no input elements remain.

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
    public ListNode insertionSortList(ListNode head) {
        if(head==null||head.next==null){
            return head;
        }
        
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        ListNode start=head;
        ListNode pre=dummy;
        ListNode cur=start.next;
        ListNode key=cur.next;
        ListNode tmp=head;
        head=dummy;
        while(cur!=null){
            if (head.next.val>cur.val){    // key node smaller than the first node
                tmp=head.next;
                key=cur.next;
                dummy.next=cur;
                cur.next=tmp;
                start.next=key;
                cur=key;
            }else if(start.val>cur.val){  // key node larger than the first node but smaller than its pre node (Nodes had been sorted)
                while(head.next.val<cur.val){
                    head=head.next;
                }
                key=cur.next;
                tmp=head.next;
                head.next=cur;
                cur.next=tmp;
                start.next=key;
                cur=key;
            }else{ // key node larger than its pre node 
                start=start.next;
                //System.out.println(head.next.val);
                cur=cur.next;
                key=cur;
            }
            head=dummy; // reset head to the first node of the linked list.
        }
        return dummy.next;
    }
}

