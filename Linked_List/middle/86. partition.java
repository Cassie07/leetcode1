/**
86. Partition List
DescriptionHintsSubmissionsDiscussSolution
Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

You should preserve the original relative order of the nodes in each of the two partitions.

Example:

Input: head = 1->4->3->2->5->2, x = 3
Output: 1->2->2->4->3->5
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
    public ListNode partition(ListNode head, int x) {
        if(head==null){
            return null;
        }
        ListNode left=new ListNode(0);
        ListNode rl=left;
        ListNode headl=left;
        ListNode right=new ListNode(0);
        ListNode rr=right;
        ListNode headr=right;
        int countl=0;
        int countr=0;
        while(head!=null){                
            if(head.val<x){
                rl=left;
                left.val=head.val;
                left.next=new ListNode(0);
                left=left.next;
                countl++;
            }else{
                rr=right;
                right.val=head.val;
                right.next=new ListNode(0);
                right=right.next;
                countr++;
            }
            head=head.next;
        }
        rl.next=null;
        rr.next=null;
        if(countl==0){
            return headr;
        }else if(countr==0){
            return headl;
        }else{
            rl.next=headr;
            return headl;
        }
    }
}

/** create two new linked list: left and right. If the value of the current node is smaller than the target value, add it to 
    the left linked list. If not, add it to the rifht linked list.
    Connect two linked list.
    (remove the extra zero node)
*/
