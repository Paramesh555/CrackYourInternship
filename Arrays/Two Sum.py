class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        ans = []
        for i in range(0,len(nums)):
            temp = nums[i]
            for j in range(i+1,len(nums)):
                sum = temp + nums[j]
                if sum == target:
                    ans = [i,j]
                    return ans

        