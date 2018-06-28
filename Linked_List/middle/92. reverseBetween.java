/**
92. Reverse Linked List II
DescriptionHintsSubmissionsDiscussSolution
Reverse a linked list from position m to n. Do it in one-pass.

Note: 1 ≤ m ≤ n ≤ length of list.

Example:

Input: 1->2->3->4->5->NULL, m = 2, n = 4
Output: 1->4->3->2->5->NULL
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
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(m==n){
            return head;
        }
        ListNode cur=head,prestart=head,start=head,end=head,tmp=head;
        ListNode pre=new ListNode(0);
        pre.next=cur;
        ListNode ret=pre;
        int count=1;
        while(count<=n){
            if(count==m){
                start=cur;
                prestart=pre;
                pre=pre.next;
                cur=cur.next;
            }else if(count>m){
                end=cur;
                tmp=cur.next;
                cur.next=pre;
                pre=cur;
                cur=tmp;
            }else{
                pre=pre.next;
                cur=cur.next;
            }
            count++;
        }
        prestart.next=end;
        start.next=cur;
        return ret.next;
    }
}
