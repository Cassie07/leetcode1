/**
120. Triangle
DescriptionHintsSubmissionsDiscussSolution
Pick One
Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.

For example, given the following triangle

[
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
]
The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).

*/

class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        for(int i=triangle.size()-2;i>=0;i--){    // if a is a list, a.size() is to get the length of this list
            int n=triangle.get(i).size(); // a.get(i) means we want to get the ith element in a
            for (int j=0;j<n;j++){
                int a=triangle.get(i).get(j)+Math.min(triangle.get(i+1).get(j),triangle.get(i+1).get(j+1));
                triangle.get(i).set(j,a); // to update the element in list we should use a.set()
            }
        }
        return triangle.get(0).get(0);
    }
}
