from collections import Counter
class Solution:
    def removeAnagrams(self, words: List[str]) -> List[str]:
        res, n, i = [], len(words), 0
        while i < n:            
            running = ''.join(sorted(words[i]))
            res.append(words[i])
            while i<n and running == ''.join(sorted(words[i])):
                i+=1
            else:
                continue;
            
        return res