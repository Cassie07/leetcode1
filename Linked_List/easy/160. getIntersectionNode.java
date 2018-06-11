/**
Write a program to find the node at which the intersection of two singly linked lists begins.


For example, the following two linked lists:

A:          a1 → a2
                   ↘
                     c1 → c2 → c3
                   ↗            
B:     b1 → b2 → b3
begin to intersect at node c1.


Notes:

If the two linked lists have no intersection at all, return null.
The linked lists must retain their original structure after the function returns.
You may assume there are no cycles anywhere in the entire linked structure.
Your code should preferably run in O(n) time and use only O(1) memory.*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode a=headA;
        ListNode b=headB;
        if (a==null||b==null){
            return null;
        }
        while(a!=b){
            if(a==null){
                a=headB;
            }else{
                a=a.next;
            }
            if(b==null){
                b=headA;
            }else{
                b=b.next;
            }
        }
        return a;
    }
}

/** an easy vesion for this problem
* while (a != b) {
*       a = (a != null) ? a.next : headB; // when a to end , then point to headB.
*       b = (b != null) ? b.next : headA;
*    }
* a simple explaination for this problem: why b=headA/a=headB?
* when headA and headB are not in the same length, the shorter one will be traversed first.
* eg: A = {1,3,5,7,9,11} and B = {2,4,9,11}
* B will be traversed first(at this time, node=7).Since B.length (=4) < A.length (=6), pB would reach the end of the merged list first, 
* because pB traverses exactly 2 nodes less than pA does. By redirecting pB to head A, and pA to head B, 
* we now ask pB to travel exactly 2 more nodes than pA would. So in the second iteration, 
* they are guaranteed to reach the intersection node at the same time.
*/
