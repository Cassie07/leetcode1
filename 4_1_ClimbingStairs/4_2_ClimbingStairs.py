'''
70. Climbing Stairs
Description:
You are climbing a stair case. It takes n steps to reach to the top.
Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

Note: Given n will be a positive integer.

Example 1:

Input: 2
Output:  2
Explanation:  There are two ways to climb to the top.

1. 1 step + 1 step
2. 2 steps
Example 2:

Input: 3
Output:  3
Explanation:  There are three ways to climb to the top.

1. 1 step + 1 step + 1 step
2. 1 step + 2 steps
3. 2 steps + 1 step
'''

class Solution:
    def climbStairs(self, n):
        """
        :type n: int
        :rtype: int
        """
        c=1
        lista=[]
        c+=(n-1)
        for i in range(n):
            lista.append(i)

        for i in range(2,n//2+1):
            listb = []
            for j in range(2*i-1):
                listb.append(0)
            sum = 0
            #print(lista)
            for k in range(n - 2):
                sum = sum + lista[k]
                #print(sum)
                if n >=2 * i:
                    if sum!=0:
                     listb.append(sum)
                else:
                  listb.append(0)
            c += sum
            lista=listb
            #print(lista)
        return c

if __name__ == '__main__':
    b=Solution()
    print(b.climbStairs(6))