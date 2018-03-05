import numpy as np

nums=[3,2,3]
target=6
sum = 0
list = []
if len(nums)>2:
            for i in range(0,len(nums)):
                for j in range(i+1,len(nums)):
                    sum=nums[i]+nums[j]
                    if sum==target:
                        list.append(i)
                        list.append(j)
                        print(list)
                    else:
                        continue
else:
    list.append(1)
    list.append(0)
    print(list)
