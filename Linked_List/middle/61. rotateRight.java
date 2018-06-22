/**
61. Rotate List
DescriptionHintsSubmissionsDiscussSolution
Given a linked list, rotate the list to the right by k places, where k is non-negative.

Example 1:

Input: 1->2->3->4->5->NULL, k = 2
Output: 4->5->1->2->3->NULL
Explanation:
rotate 1 steps to the right: 5->1->2->3->4->NULL
rotate 2 steps to the right: 4->5->1->2->3->NULL
Example 2:

Input: 0->1->2->NULL, k = 4
Output: 2->0->1->NULL
Explanation:
rotate 1 steps to the right: 2->0->1->NULL
rotate 2 steps to the right: 1->2->0->NULL
rotate 3 steps to the right: 0->1->2->NULL
rotate 4 steps to the right: 2->0->1->NULL

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
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null){
            return null;
        }
        if(k==0){
            return head;
        }
        ListNode pre=new ListNode(0);
        pre.next=head;
        ListNode end=head;
        ListNode cur=head;
        ListNode counts=head;
        int count=0;
        while(counts!=null){
            count=count+1;
            counts=counts.next;
            if(counts!=null){
                end=end.next;
            }
        }
        if(count==1){
            return pre.next;
        }
        int n=count-k;
        if (n==0){
            return pre.next;
        }else if(n>0){
            int num=n;
            ListNode start=head;
            ListNode prestart=head;
            while(num!=0){
                prestart=start;
                start=start.next;
                num=num-1;
            }
            pre.next=start;
            end.next=head;
            prestart.next=null;
        }else{
            int mod=k%count;
            if(mod==0){
                return pre.next;
            }
            int num=count-mod;
            ListNode start=head;
            ListNode prestart=head;
            while(num!=0){
                prestart=start;
                start=start.next;
                num=num-1;
            }
            pre.next=start;
            end.next=head;
            prestart.next=null;
        }
        return pre.next;
    }
}
