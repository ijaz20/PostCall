class Solution:
    def countAsterisks(self, s: str) -> int:
        count, p =0, False
        for c in s:
            if c == '|':
                p = not p
            if not p and c == '*':
                count +=1
        return count
        