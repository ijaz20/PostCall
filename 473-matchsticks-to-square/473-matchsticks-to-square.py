"""
class Solution:
    def makesquare(self, matchsticks: List[int]) -> bool:
        total = sum(matchsticks)
        if total % 4 != 0:
            return False
        matchsticks.sort(reverse=True)
        dp, n, side = [0] * 4, len(matchsticks), total//4
        #print(matchsticks, dp, n, side)
        def dfs(i):
            nonlocal dp, n, side            
            if i == n:
                return dp[0] == dp[1] == dp[2] == dp[3] == side
            result = False
            for x in range(4):
                if dp[x] + matchsticks[i] > side:
                    continue
                dp[x] += matchsticks[i]
                if dfs(i+1):
                    return True
                dp[x] -= matchsticks[i]
            return result
        return dfs(0)
"""
class Solution:
    def makesquare(self, matchsticks: List[int]) -> bool:
        value = sum(matchsticks)
        if value < 4:
            return False
        if value % 4 != 0:
            return False
        edge = value // 4
        matchsticks.sort(reverse=True)
        @cache
        def findedges(l1, l2, l3, l4, i):
            nonlocal edge
            if l1 == l2 == l3 == l4 == edge:
                return True
            if i > len(matchsticks) - 1:
                return False
            if l1 > edge or l2 > edge or l3 > edge or l4 > edge:
                return False
            return findedges(l1 + matchsticks[i], l2, l3, l4, i + 1) or findedges(l1, l2 + matchsticks[i] , l3, l4, i + 1) or findedges(l1, l2, l3 + matchsticks[i], l4, i + 1) or findedges(l1, l2, l3, l4 + matchsticks[i] , i + 1)
        return findedges(0, 0, 0, 0, 0)