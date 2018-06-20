/**
2. Add Two Numbers
DescriptionHintsSubmissionsDiscussSolution
You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Example

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
Explanation: 342 + 465 = 807.
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode l3=new ListNode(0);
        ListNode tmp=l3;
        ListNode pre=l3;
        int count=0;
        while(l1!=null&&l2!=null){
            int sum=l1.val+l2.val;
            if(sum>=10){
                l3.next=new ListNode(1);
                l3.val=l3.val+sum%10;
            }else{
                l3.val=l3.val+sum;
                if(l3.val>=10){
                    l3.val=l3.val%10;
                    l3.next=new ListNode(1);
                }else{
                    l3.next=new ListNode(0);
                }
            }
            l1=l1.next;
            l2=l2.next;
            pre=l3;
            l3=l3.next;
            count=sum;
        }
        
        if(l1==null){
            while(l2!=null){
                if(l3.val==1){
                    count=l2.val+l3.val;
                    if(count>=10){
                        l3.next=new ListNode(1);
                        l3.val=count%10;
                    }else{
                        l3.val=count;
                        l3.next=new ListNode(0);
                    }
                }else{
                        l3.val=l3.val+l2.val;
                        l3.next=new ListNode(0);
                    }
                pre=l3;
                l3=l3.next;
                l2=l2.next;
            }
        }else if(l2==null){
            while(l1!=null){
                if(l3.val==1){
                    count=l1.val+l3.val;
                    if(count>=10){
                        l3.next=new ListNode(1);
                        l3.val=count%10;
                    }else{
                        l3.val=count;
                        l3.next=new ListNode(0);
                    }
                }else{
                        l3.val=l3.val+l1.val;
                        l3.next=new ListNode(0);
                    }
                pre=l3;
                l3=l3.next;
                l1=l1.next;
            }
        }
        
        if(l3.val==0){
            pre.next=null;
            return tmp;
        }else{
            return tmp;
        }
    }
}
