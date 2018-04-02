"""121. Best Time to Buy and Sell Stock
DescriptionHintsSubmissionsDiscussSolution
Say you have an array for which the ith element is the price of a given stock on day i.

If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.

Example 1:
Input: [7, 1, 5, 3, 6, 4]
Output: 5

max. difference = 6-1 = 5 (not 7-1 = 6, as selling price needs to be larger than buying price)
Example 2:
Input: [7, 6, 4, 3, 1]
Output: 0

In this case, no transaction is done, i.e. max profit = 0.
"""
'''update the smallest and largest difference dynamically'''
'''Ex. like[2,7,1,4], the first difference=abs(2-7)=5 and the first smallest=2 , 
       the temporary variable different=5.Then, 2-1=1>0, update the smallest. 
       Thus, the smallest=1, the new difference=abs(1-4)=3. 
       Because the new difference(3) is not larger than different(the old difference=5), 
       the different(temporary maxprofit) should not be update. After all loops, we return
       the final different(that is the final maxprofit now)
       (ps: all difference here are abs(difference) in code and difference is profit, 
            different is a terminal variable to save the temporary maxprofit
            )
       '''
class Solution:
    def maxProfit(self, prices):
        """
        :type prices: List[int]
        :rtype: int
        """
        if len(prices)!=0:
            different=0
            smallest=prices[0]
            for i in range(1,len(prices)):
                difference=smallest-prices[i]
                if difference<0:
                    if different<abs(difference):
                        different=abs(difference)
                else:
                    smallest=prices[i]
            return different
        else:
            return 0

if __name__ == '__main__':
    b=Solution()
    a=b.maxProfit([2,1,2,0,1])
    print a

'''for the first algorithm version, it shows that Time limit exceeded. To find whether the problem is algorithm or the programming language, i also use java
   to realize the algorithm. Finally, I decide to change another algorithm. But this is my first java code. Just copy it here'''
class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length!=0){
            List<Integer> difference = new ArrayList<Integer>();
            int count=0;
            for (int i=0;i<prices.length;i++){
                for (int j=i;j<prices.length;j++){
                     int different=prices[i]-prices[j];
                    if (different<0){
                        difference.add(different);
                        count=count+1;
                    }
                }
            }
            if(count!=0){
                int sm=0-difference.get(0);
                for (int k=0;k<count;k++){
                    if(sm<0-difference.get(k)){
                        sm=0-difference.get(k);
                    }
                }
                return sm;
            }
            else{
                return 0;
            }
        }
        else{
            return 0;
        }
    }
}
