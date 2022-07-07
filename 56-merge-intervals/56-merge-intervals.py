class Solution:
    def merge(self, ivl: List[List[int]]) -> List[List[int]]:
        ivl = sorted(ivl, key=lambda x: (x[0], x[1]))
        n, res, curr, i =len(ivl), [], ivl[0], 1
        while i < n:
            if curr[1] >= ivl[i][0]:
                curr[1] = max(curr[1], ivl[i][1])
            else:
                res.append(curr)
                curr = ivl[i]
            i+=1
        res.append(curr)
        return res
            
            