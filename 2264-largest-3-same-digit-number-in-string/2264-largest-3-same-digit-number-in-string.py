class Solution:
    def largestGoodInteger(self, num: str) -> str:
        res, ran = -1, len(num)
        for i in range(ran-2):
            if num[i] == num[i+1] and num[i] == num[i+2] and int(num[i]) > res:
                res = int(num[i])
        return "" if res == -1 else str(res) * 3
                