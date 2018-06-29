/**
143. Reorder List
DescriptionHintsSubmissionsDiscussSolution
Given a singly linked list L: L0→L1→…→Ln-1→Ln,
reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…

You may not modify the values in the list's nodes, only nodes itself may be changed.

Example 1:

Given 1->2->3->4, reorder it to 1->4->2->3.
Example 2:

Given 1->2->3->4->5, reorder it to 1->5->2->4->3.
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
/**reverse the sublist of Ln...Ln/2, two start pointer of L0....Ln/2 and Ln/2....Ln*/
class Solution {
    public ListNode reorderList(ListNode head) {
        ListNode ret=head;
        ListNode record=head;
        ListNode first=head;
        int count=0;
        while(head!=null){
            count++;
            head=head.next;
        }
        if(count<=2){
            return head;
        }else{
            int n=(count-1)/2;
            int k=count-n;
            ListNode prestart=new ListNode(0);
            while(k!=0){
                k--;
                prestart=record;
                record=record.next;
            }

            ListNode pre=record;
            ListNode cur=record.next;
            ListNode tmp=new ListNode(0);
            while(cur!=null){
                tmp=cur.next;
                cur.next=pre;
                pre=cur;
                cur=tmp;
            }
            record.next=null;
            prestart.next=pre;
        
            ListNode second=pre;
            while(second!=null){
                prestart.next=second.next;
                second.next=first.next;
                first.next=second;
                first=second.next;
                second=prestart.next;
            }
            return ret;
        }
    }
}

