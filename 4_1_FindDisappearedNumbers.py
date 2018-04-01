# coding=utf-8
'''
448. Find All Numbers Disappeared in an Array
DescriptionHintsSubmissionsDiscussSolution
Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.
Find all the elements of [1, n] inclusive that do not appear in this array.

Could you do it without extra space and in O(n) runtime? You may assume the returned list does not count as extra space.

Example:
Input:
[4,3,2,7,8,2,3,1]

Output:
[5,6]

'''
'''Hmmmmm, a really interesting thing is that the first version code just finished to running 30/34 test samples. When meeting a real large list, 
   it shows that Time limited exceed! Thus, I changed my code to get an easier way.
   
   idea：get the difference set for the completed set and the set which has disappeared numbers
'''
class Solution:
    def findDisappearedNumbers(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        n = len(nums)
        nums = list(set(range(1,n+1))-set(nums))
        return nums

if __name__ == '__main__':
    b=Solution()
    a=b.findDisappearedNumbers([4,3,2,7,8,2,3,1])
    print a