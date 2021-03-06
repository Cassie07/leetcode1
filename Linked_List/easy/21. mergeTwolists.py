# 21. Merge two lists
# Question Description:
# Merge two sorted linked lists and return it as a new list. 
# The new list should be made by splicing together the nodes of the first two lists.

# Example:
# Input: 1->2->4, 1->3->4
# Output: 1->1->2->3->4->4

# Solution:
# Compare the elements in two lists. Add the smaller one into the list and update the pointer. 
# When one of the lists is traversed, add the rest elements of another list into the returned list directly.
# **********************************************************************************************************
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def mergeTwoLists(self, l1, l2):
        """
        :type l1: ListNode
        :type l2: ListNode
        :rtype: ListNode
        """
        head=new=ListNode(0)   # *
        while l1 and l2:
            if l1.val<=l2.val:
                head.next=l1
                l1=l1.next
            else:
                head.next=l2
                l2=l2.next
            head=head.next   # *
        if l1:
            head.next=l1
        else:
            head.next=l2
        return new.next
    
