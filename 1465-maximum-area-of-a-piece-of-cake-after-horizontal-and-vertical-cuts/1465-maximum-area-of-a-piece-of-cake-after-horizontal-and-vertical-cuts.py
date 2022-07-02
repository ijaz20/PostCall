class Solution:
    def maxArea(self, h: int, w: int, horizontalCuts: List[int], verticalCuts: List[int]) -> int:
        horizontalCuts = sorted(horizontalCuts)
        verticalCuts = sorted(verticalCuts);
        horizontalCuts.append(h);
        verticalCuts.append(w);
        
        maxH, maxW, prevH, prevW =(0,)*4
        for hc in horizontalCuts:            
            maxH = max(maxH, hc - prevH)
            prevH = hc
            
        for vc in verticalCuts:
            maxW = max(maxW, vc - prevW)
            prevW = vc
        return (maxH * maxW) % 1000000007;
        