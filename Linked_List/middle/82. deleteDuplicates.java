/**
82. Remove Duplicates from Sorted List II
DescriptionHintsSubmissionsDiscussSolution
Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.

Example 1:

Input: 1->2->3->3->4->4->5
Output: 1->2->5
Example 2:

Input: 1->1->1->2->3
Output: 2->3

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
        if (head==null){
            return null;
        }
        ListNode pre=new ListNode(0);
        pre.next=head;
        ListNode ret=pre;                // this is a node that we used to return.
        ListNode fast=head.next;
        ListNode slow=head;
        int or=head.val;                 // !!! this part is to avoid the value of re is equal to the first node and the second node
        int re=or-10;                    // if it is equal to the first node but the first node and the second node, the first ndoe will be overlook.
        while(fast!=null){
            if(fast.val==slow.val){      // There is duplicate between two nodes:
                re=pre.next.val;         // give the value fo duplicate to re(it will be used in next part)
                pre.next=fast.next;      // remove slow and fast(duplicate)
                if (pre.next==null){     // if there only two same nodes in the linked list, there will be a wrong compile if there
                    return ret.next;     // is no such codes.
                }
                slow=pre.next;           // update slow and fast.
                fast=slow.next;
            }else{                       // there is no duplicate between nodes:
                if(slow.val==re){        // when the number of duplicate is odd(there will be a node of duplicate not be removed)
                    pre.next=fast;       // remove it and update slow and fast
                    slow=fast;
                    fast=fast.next;
                }else{                   // when number of duplicate is even or the usual status(different nodes)
                    pre=pre.next;        // update
                    if(pre.next==null){
                        return ret.next;
                    }
                    slow=pre.next;
                    fast=slow.next;
                }
            }
        }
        if(slow.val==re){              // if there is only duplicate in the linked list and the number of them are odd.
            pre.next=fast;
        }
        return ret.next;
    }
}
