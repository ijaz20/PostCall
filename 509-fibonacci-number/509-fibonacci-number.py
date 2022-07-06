class Solution:
    def fib(self, n: int) -> int:
        def dfs(i):
            if i < 2:
                return i
            return dfs(i-1) + dfs(i-2)
        return dfs(n)