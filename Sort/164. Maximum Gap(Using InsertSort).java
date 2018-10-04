/**
164. Maximum Gap
DescriptionHintsSubmissionsDiscussSolution
Given an unsorted array, find the maximum difference between the successive elements in its sorted form.

Return 0 if the array contains less than 2 elements.

Example 1:

Input: [3,6,9,1]
Output: 3
Explanation: The sorted form of the array is [1,3,6,9], either
             (3,6) or (6,9) has the maximum difference 3.
Example 2:

Input: [10]
Output: 0
Explanation: The array contains less than 2 elements, therefore return 0.
Note:

You may assume all elements in the array are non-negative integers and fit in the 32-bit signed integer range.
Try to solve it in linear time/space.
*/

class Solution {
    public int maximumGap(int[] nums) {
        if(nums.length<2){
            return 0;
        }
        nums=InsertSort(nums);
        int i=0;
        int max=0;
        for (i=1;i<nums.length;i++){
            int m=nums[i]-nums[i-1];
            if(m>max){
                max=m;
            }
        }
        return max;
    }
    
    // 3 6 9 1
    public int[] InsertSort(int[] nums){
        int i=0;
        int j=0;
        int k=0;
        int key;
        for(i=1;i<nums.length;i++){
            key=nums[i];
            k=i;
            for (j=i-1;j>=0;j--){
                if(nums[j]>key){
                    nums[j+1]=nums[j];
                    k=j;
                }
            }
            nums[k]=key;
        }
        return nums;
    }
}
