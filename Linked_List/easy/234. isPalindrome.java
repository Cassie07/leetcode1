/**
234. Palindrome Linked List
DescriptionHintsSubmissionsDiscussSolution
Given a singly linked list, determine if it is a palindrome.

Example 1:

Input: 1->2
Output: false
Example 2:

Input: 1->2->2->1
Output: true
Follow up:
Could you do it in O(n) time and O(1) space?
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
    public boolean isPalindrome(ListNode head) {
        /**ListNode headr=reverseList(head);
        while(headr!=null&&head!=null){
            if (headr.val!=head.val){
                return false;
            }else{
                headr=headr.next;
                head=head.next;
            }
        }*/
        ListNode tmp=head;     /** this is a temporary pointer which can push items into stack and not change the position of head pointer */
        Stack<Integer> s=new Stack(); /** add items into a stack*/
        while(tmp!=null){
            s.push(tmp.val);
            tmp=tmp.next;
        }
        while(head!=null){     /** compare the value of each items in linked list with the items in stack*/
            if (head.val==s.pop()){ /** there is a character of stack: first in, last out. Therefore, there first item be poped is the last item in the linked list*/
                head=head.next;  /** if there is a palindrome, the first and last item should be the same. And all pair of items should follow this rule */
            }else{
                return false;
            }
        }
        return true;
    }
}
