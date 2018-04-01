'''283. Move Zeroes
DescriptionHintsSubmissionsDiscussSolution
Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.

For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].

Note:
You must do this in-place without making a copy of the array.
Minimize the total number of operations.
'''

class Solution:
    def moveZeroes(self, nums):
        """
        :type nums: List[int]
        :rtype: void Do not return anything, modify nums in-place instead.
        """
        a=0
        m=0
        while(a!=len(nums)-1):
            if nums[a]==0:
                b=a
                while not (nums[b]!=0 or b==len(nums)-1):
                    b+=1
                m=nums[a]
                nums[a]=nums[b]
                nums[b]=m
                a+=1
            else:
                a+=1
        return nums

if __name__ == '__main__':
    b=Solution()
    a=b.moveZeroes([4,2,4,0,0,3,0,5,1,0])
    print(a)