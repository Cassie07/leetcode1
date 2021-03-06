"""
7. Reverse Integer

Given a 32-bit signed integer, reverse digits of an integer.

Example 1:

Input: 123
Output:  321
Example 2:

Input: -123
Output: -321
Example 3:

Input: 120
Output: 21
Note:
Assume we are dealing with an environment which could only hold integers within the 32-bit signed integer range. For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.

"""

# Solution
class Solution:
    def reverse(self, x):
        """
        :type x: int
        :rtype: int
        """
        list = []
        mod = []
        res = 0
        i = 0
        quotient = 0
        res_q =x
        mark = 0

        def divs(x):  # a function to get the list of remainder and a quotient which can be used as input in next iteration
            res_mod = x % 10
            quotient = x // 10
            mod.append(res_mod)
            return (mod, quotient)

        if res_q < 0:  # if res_q is a negtive number, we should change it into a positive number
            res_q = 0 - res_q
            mark = 1  # like a flag, to decide if the final result need to add "-" before it be returned
        else:
            res_q = res_q

        if res_q == 0:  # 0 can be a special num, we should consider it seperately
            return 0

        while res_q != 0:  # a loop to call function: get the list of remainder
            result = divs(res_q)
            res_q = result[1]
        i = len(result[0]) - 1
        for j in result[0]:  # reverse
            res = res + j * (10 ** i)
            i = i - 1
        if res > ((2 ** 32) // 2):  # reverse integer should be a 32bit signed number: 32bit- like a space which has the size of 2**31
            return 0  # for here, reverse integer is a signed number,therefor the range of the space should be [-(2**31)/2,(2**31)/2]

        if mark == 1:
            return -res
        else:
            return res
