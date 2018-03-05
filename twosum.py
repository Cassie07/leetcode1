class Solution:
    def twoSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        #sum=0
        list=[]
        for i in range(0,len(nums)):
            for j in range(i+1,len(nums)):
                sum=nums[i]+nums[j]
                if sum==target:
                    list.append(i)
                    list.append(j)
                    return(list)
                else:
                    continue