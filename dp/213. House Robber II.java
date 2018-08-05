/**
213. House Robber II
DescriptionHintsSubmissionsDiscussSolution
You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed. All houses at this place are arranged in a circle. That means the first house is the neighbor of the last one. Meanwhile, adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.

Example 1:

Input: [2,3,2]
Output: 3
Explanation: You cannot rob house 1 (money = 2) and then rob house 3 (money = 2),
             because they are adjacent houses.
Example 2:

Input: [1,2,3,1]
Output: 4
Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
             Total amount you can rob = 1 + 3 = 4.
*/

import com.sun.org.apache.xalan.internal.xsltc.util.IntegerArray;
import java.util.Arrays;
public class Solution {
    public static void main(String[] args) {
        int[] num={1, 2, 3, 4, 5, 1, 2, 3, 4, 5};
        Solution s= new Solution();
        System.out.println(s.robcompare(num));
    }
    private int rob(int[] num,int left,int right) {
        int[] nums=Arrays.copyOfRange(num,left,right);
        int n=nums.length;
        if(n==0){
            return 0;
        }
        if (n<=1){
            return nums[0];
        }
        int[] dp=new int[n];
        dp[0]=nums[0];
        dp[1]=Math.max(nums[1],nums[0]);
        int i;
        for(i=2;i<n;i++){
            dp[i]=Math.max(dp[i-1],dp[i-2]+nums[i]);
        }
        return dp[i-1];
    }
    public int robcompare(int[] num) {
        int n=num.length;
        if(n==0){
            return 0;
        }
        if (n<=1){
            return num[0];
        }
        return Math.max(rob(num,0,n-1),rob(num,1,n));
    }
}
