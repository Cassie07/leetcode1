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