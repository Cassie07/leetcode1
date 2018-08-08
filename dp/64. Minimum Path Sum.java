/**
64. Minimum Path Sum
DescriptionHintsSubmissionsDiscussSolution
Pick One
Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.

Note: You can only move either down or right at any point in time.

Example:

Input:
[
  [1,3,1],
  [1,5,1],
  [4,2,1]
]
Output: 7
Explanation: Because the path 1→3→1→1→1 minimizes the sum.
*/
class Solution {
    public int minPathSum(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        for(int i=1;i<m;i++){
            grid[0][i]=grid[0][i-1]+grid[0][i];
        }
        for(int i=1;i<n;i++){
            grid[i][0]=grid[i-1][0]+grid[i][0];
        }
        for(int i=1;i<n;i++){
            for(int j=1;j<m;j++){
                grid[i][j]=grid[i][j]+Math.min(grid[i-1][j],grid[i][j-1]);
            }
        }
        return grid[n-1][m-1];
    }
}
