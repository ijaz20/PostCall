class Solution:
    def convertTime(self, current: str, correct: str) -> int:
        old, new = current.split(":"), correct.split(":")
        hr = int(new[0]) - int(old[0])
        mts = 0
        if hr == 0:
            mts = int(new[1]) - int(old[1])
        else:
            if hr > 1:
                mts += (hr-1) * 60
            mts += (60- int(old[1])) + int(new[1])
        
        res, dirs = 0, [60, 15, 5, 1]
        for i in dirs:
            res += mts//i    
            mts %= i            
        return res