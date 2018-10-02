/**

75. Sort Colors
DescriptionHintsSubmissionsDiscussSolution
Given an array with n objects colored red, white or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white and blue.

Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

Note: You are not suppose to use the library's sort function for this problem.

Example:

Input: [2,0,2,1,1,0]
Output: [0,0,1,1,2,2]
Follow up:

A rather straight forward solution is a two-pass algorithm using counting sort.
First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total number of 0's, then 1's and followed by 2's.
Could you come up with a one-pass algorithm using only constant space?

*/

class Solution {
    public void sortColors(int[] nums) {
        int i=0;
        int red=0;
        int white=0;
        int blue=0;
        for(i=0;i<nums.length;i++){
            if(nums[i]==0){
                red+=1;
            }else if(nums[i]==1){
                white+=1;
            }else{
                blue+=1;
            }
        }
        int n=0;
        while(n<nums.length){
            if(red!=0){
                nums[n]=0;
                n+=1;
                red-=1;
            }else if(red==0&&white!=0){
                nums[n]=1;
                n+=1;
                white-=1;
            }else{
                nums[n]=2;
                n+=1;
                blue-=1;
            }
        }
    }
}
