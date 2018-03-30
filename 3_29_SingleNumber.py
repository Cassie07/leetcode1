'''136. Single Number

DescriptionHintsSubmissionsDiscussSolution
Given an array of integers, every element appears twice except for one. Find that single one.

Note:
Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?'''

'''Solution1
'''
class Solution:
    def singleNumber(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        copy=[]
        for i in nums:
            if i in copy:
                copy.remove(i)
            else:
                copy.append(i)
        return copy[0]

'''solution2
'''
class Solution(object):
    def singleNumber(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        a = 0
        for i in nums:
            a ^=i
            print(a)
        return a


if __name__ == '__main__':
    b=Solution()
    print(b.singleNumber([1,2,3,2,3]))