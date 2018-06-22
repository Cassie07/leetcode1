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
        if(head==null){                   // if the linked list is empty. We just return itself.
            return null;
        }
        if(k==0){
            return head;                  // if k is 0, we also return itself.
        }
        ListNode pre=new ListNode(0);
        pre.next=head;
        ListNode end=head;
        ListNode cur=head;
        ListNode counts=head;
        int count=0;
        while(counts!=null){             // To count the total number of nodes in the linked list.
            count=count+1;
            counts=counts.next;
            if(counts!=null){
                end=end.next;
            }
        }
        if(count==1){                    // If there is only one node is the linked list, no matter how many k is, we just return
            return pre.next;             // the linked list itself.
        }
        int n=count-k;           
        if (n==0){                       // if k equal to the sum of the nodes in the linked list. We just return the linked list itself.
            return pre.next;
        }else if(n>0){                   // if k larger than the sum of the nodes in the linked list
            int num=n;                   // n is the number of the nodes which are not need to move
            ListNode start=head;         
            ListNode prestart=head;
            while(num!=0){               // the pointer prestart is pointing the last node which not need to be move.
                prestart=start;          // the pointer start is pointing the first node which need to be move.
                start=start.next;
                num=num-1;
            }
            pre.next=start;              // connect the pre pointer to start pointer and connect the end pointer to the first
            end.next=head;               // pointer in the original linked list
            prestart.next=null;
        }else{
            int mod=k%count;             // if k is multiple of the number of nodes in the linked list, we just return the 
            if(mod==0){                  // linked list itself.
                return pre.next;
            }
            int num=count-mod;           // these steps are same as before. Determining the number of nodes which need to be move.
            ListNode start=head;         // And find the start node of the part of the linked list which need to be move. Then repeating
            ListNode prestart=head;      // the steps as we introduce in last part.
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
