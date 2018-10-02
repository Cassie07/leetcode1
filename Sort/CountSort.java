class Solution {
    public void CountSort(int[] nums) {
      int min=nums[0];
      int max=nums[0];
      int i=0;
      for(i=1;i<nums.length;i++){
          if (nums[i]<min){
              min=nums[i];
          }else if(nums[i]>max){
              max=nums[i];
          }
      }
      int n=max-min+1;
      int[] c=new int[n];
      for(i=0;i<n;i++){
          c[i]=0;
      }
      for(i=0;i<nums.length;i++){
          c[nums[i]]=c[nums[i]]+1;
      }
      for(i=1;i<c.length;i++){
          c[i]=c[i]+c[i-1];
      }
      int[] b=new int[nums.length+1];
      for(i=nums.length-1;i>=0;i--){
          b[c[nums[i]]]=nums[i];
          c[nums[i]]=c[nums[i]]-1;
      }
      for(i=0;i<nums.length;i++){
          nums[i]=b[i+1];
      }
    }
}
