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
        ListNode tmp=head;
        Stack<Integer> s=new Stack();
        while(tmp!=null){
            s.push(tmp.val);
            tmp=tmp.next;
        }
        while(head!=null){
            if (head.val==s.pop()){
                head=head.next;
            }else{
                return false;
            }
        }
        return true;
    }
}
