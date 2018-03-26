'''solution 1'''
'''(runtime beats 90%)i separate the num(38) in to a string('38') and then change it into a list(['3','8'])'''
class Solution:
    #def _init_()
    def addDigits(self, num):
        """
        :type num: int
        :rtype: int
        """
        print(num)
        while(num>=10):
            sum=0
            str_n = str(num)
            list_n = list(str_n)
            for i in list_n:
                sum=sum+int(i)
            num=sum
        return num


'''solution 2'''
''' (runtime beats 96%)this is an easier method'''
class Solution:
    #def _init_()
    def addDigits(self, num):
        """
        :type num: int
        :rtype: int
        """
        print(num)
        while(num>=10):
            num=num//10+num%10
        return num

'''solution 3'''
'''WITHOUT ANY  loop/recursion in O(1) runtime'''
