from collections import Counter

class Solution:
    def rearrangeCharacters(self, s: str, target: str) -> int:
        smap, tmap = Counter(s), Counter(target)
        return min(smap[e]//tmap[e] for e in tmap)
        