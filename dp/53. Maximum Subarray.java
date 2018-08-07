/**
53. Maximum Subarray
DescriptionHintsSubmissionsDiscussSolution
Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.

Example:

Input: [-2,1,-3,4,-1,2,1,-5,4],
Output: 6
Explanation: [4,-1,2,1] has the largest sum = 6.
Follow up:

If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.
*/
// Second version =======> running time: O(n) ========> DP version
class Solution {
    public int maxSubArray(int[] nums) {
        int max=0;
        int res=nums[0];
        int n=nums.length;
        int[] dp=new int[n];
        for (int i=0;i<n;i++){
            dp[i]=Math.max(i==0? nums[i]:dp[i-1]+nums[i],nums[i]); // transfer function: dp[i]=max(dp[i-1]+nums[i],nums[i])
            res=Math.max(dp[i],res);
        }
        return res;
        
        /** dp[i] is the max sum of i elements. Thus dp[i-1] had been calculated. It means the biggest sum of i-1 elements has
            been calculated. if dp[i-1]+nums[i] not larger than nums[i], it means that the biggest sum of subarray in i elements 
            should be nums[i] itself.
        */
    }
}

// First version  =======> running time: O(n^2)
class Solution {
    public int maxSubArray(int[] nums) {
        int max=0;
        int sum=0;
        int res=nums[0];
        int n=nums.length;
        int[] dp=new int[n];
        for(int i=0; i<n; i++){
            sum=nums[i];
            max=sum;
            for(int j=i+1; j<n;j++){
                sum=sum+nums[j];
                max=Math.max(max,sum);
            }
            res=Math.max(res,max);
        }
        return res;
    }
}
