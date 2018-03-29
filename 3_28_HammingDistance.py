'''461. Hamming Distance

DescriptionHintsSubmissionsDiscussSolution
The Hamming distance between two integers is the number of positions at which the corresponding bits are different.

Given two integers x and y, calculate the Hamming distance.

Note:
0 ≤ x, y < 231.

Example:

Input: x = 1, y = 4

Output: 2

Explanation:
1   (0 0 0 1)
4   (0 1 0 0)
       ↑   ↑

The above arrows point to positions where the corresponding bits are different.
'''
'''1. generate tobin():
         (1) computing the remainder and add it into the list until the divisor not larger than 0
         (2) add the remainder of the divisor into the list
         (generate a reversed order of the real binary form)
   2. generate hammingDistance(): 
         (1) the length of two number when they transfer to list
         (2) when they are no in the same length, complement the short one to the same length as the long one
         (3) reversing them so that they can be the true binary form
         (4) compare each bit of same index in those two list, if they are not same, count one time'''
class Solution:
    def tobin(self, x):
        remainder = []
        if x == 1:
            re = x % 2
            remainder.append(re)
        else:
            while (x // 2 > 0):
                re = x % 2
                x = x // 2
                remainder.append(re)
            remainder.append(x % 2)
        # self.remainder.reverse()
        # print(remainder)
        return remainder

    def hammingDistance(self, x, y):
        """
        :type x: int
        :type y: int
        :rtype: int
        """
        count = 0
        a = self.tobin(x)
        b = self.tobin(y)
        if len(a) < len(b):
            for i in range(len(b) - len(a)):
                a.append(0)
        elif len(a) > len(b):
            for i in range(len(a) - len(b)):
                b.append(0)
        a.reverse()
        b.reverse()
        for i in range(len(a)):
            if a[i] != b[i]:
                count = count + 1
        return count


if __name__ == '__main__':
    b=Solution()
    print(b.hammingDistance(1,4))
